package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.documents.Potvrda;
import org.springframework.stereotype.Service;

@Service
public class PotvrdaService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/vaccination-system/potvrde";

    public PotvrdaService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
    }

    public String getXml(String documentId){
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }

    public Potvrda saveXml(String xmlString){
        Potvrda potvrda = (Potvrda) mapper.convertToObject(xmlString, "PotvrdaOVakcinaciji",
                Potvrda.class);
        String documentId = potvrda.getSifraPotvrde() + ".xml";
        dataAccessLayer.saveDocument(potvrda, folderId, documentId, Potvrda.class);
        return potvrda;
    }

    public String convertToXml(Potvrda potvrda){
        return mapper.convertToXml(potvrda,  Potvrda.class);
    }
}
