package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import org.springframework.stereotype.Service;

@Service
public class InteresovanjeService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/vaccination-system/interesovanja";

    public InteresovanjeService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
    }

    public String getXml(String documentId){
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }

    public Interesovanje saveXml(String xmlString){
        Interesovanje interesovanje = (Interesovanje) mapper.convertToObject(xmlString, "Interesovanje",
                Interesovanje.class);
        String documentId = interesovanje.getPodaciOPrimaocu().getJMBG() + ".xml";
        dataAccessLayer.saveDocument(interesovanje, folderId, documentId, Interesovanje.class);
        return interesovanje;
    }

    public String convertToXml(Interesovanje interesovanje){
        return mapper.convertToXml(interesovanje,  Interesovanje.class);
    }
}
