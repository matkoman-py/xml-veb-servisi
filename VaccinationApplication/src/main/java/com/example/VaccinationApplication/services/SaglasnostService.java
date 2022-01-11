package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.saglasnost.Saglasnost;
import org.springframework.stereotype.Service;

@Service
public class SaglasnostService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/vaccination-system/saglasnosti";

    public SaglasnostService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
    }

    public String getXmlAsText(String documentId){
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }

    public Saglasnost getXmlAsObject(String documentId) {
        String xmlString = dataAccessLayer.getDocument(folderId, documentId).get();
        return (Saglasnost) mapper.convertToObject(xmlString, "Saglasnost", Saglasnost.class);
    }

    public Saglasnost saveXmlFromText(String xmlString) {
        Saglasnost saglasnost = (Saglasnost) mapper.convertToObject(xmlString, "Saglasnost",
                Saglasnost.class);
        String documentId = saglasnost.getDrzavljanstvo().getJMBG() + ".xml";
        
        //SAGLASNOST === ZELENI SERTIFIKAT ----> (MORA KAD SE INITUJE SAGLASNOSTS DA SADRZI REFERENCU NA ODGOVARAJUCE INTERESOVANJE)
        //DODATI INTERESOVANJESERVICE KAO POLJE U OVAJ SERVICE
        //POZVATI METODU LINK IZ INTERESOVANJESERVICE
        
        
        dataAccessLayer.saveDocument(saglasnost, folderId, documentId, Saglasnost.class);
        return saglasnost;
    }

    public Saglasnost saveXmlFromObject(Saglasnost saglasnost) {
        String documentId = saglasnost.getDrzavljanstvo().getJMBG() + ".xml";
        dataAccessLayer.saveDocument(saglasnost, folderId, documentId, Saglasnost.class);
        return saglasnost;
    }

    public String convertToXml(Saglasnost saglasnost) {
        return mapper.convertToXml(saglasnost,  Saglasnost.class);
    }

    public Saglasnost convertToObject(String xmlString) {
        return (Saglasnost) mapper.convertToObject(xmlString, "Saglasnost", Saglasnost.class);
    }
}
