package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import com.example.VaccinationApplication.model.potvrda.Potvrda;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;

@Service
public class InteresovanjeService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/vaccination-system/interesovanja";

    public InteresovanjeService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
    }

    public String getXmlText(String documentId){
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }

    public Interesovanje getXmlAsObject(String documentId){
        String xmlString = dataAccessLayer.getDocument(folderId, documentId).get();

        return (Interesovanje) mapper.convertToObject(xmlString, "Interesovanje",
                Interesovanje.class);
    }

    public Interesovanje saveXmlFromText(String xmlString){
        Interesovanje interesovanje = (Interesovanje) mapper.convertToObject(xmlString, "Interesovanje",
                Interesovanje.class);
        String documentId = interesovanje.getPodaciOPrimaocu().getJMBG().getValue() + ".xml";
        dataAccessLayer.saveDocument(interesovanje, folderId, documentId, Interesovanje.class);
        return interesovanje;
    }

    public Interesovanje saveXmlFromObject(Interesovanje interesovanje){
        String documentId = interesovanje.getPodaciOPrimaocu().getJMBG().getValue() + ".xml";
        dataAccessLayer.saveDocument(interesovanje, folderId, documentId, Interesovanje.class);
        return interesovanje;
    }

    public String convertToXml(Interesovanje interesovanje){
        return mapper.convertToXml(interesovanje,  Interesovanje.class);
    }

    public Interesovanje convertToObject(String xmlString) throws FileNotFoundException, TransformerException {
        return (Interesovanje) mapper.convertToObject(xmlString, "Interesovanje", Interesovanje.class);
    }
}
