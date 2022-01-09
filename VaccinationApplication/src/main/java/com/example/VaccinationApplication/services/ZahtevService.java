package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.documents.Zahtev;
import org.springframework.stereotype.Service;

@Service
public class ZahtevService {
	
	private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/vaccination-system/zahtevi";

    public ZahtevService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
    }

    public String getXml(String documentId){
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }

    public Zahtev saveXml(String xmlString){
    	Zahtev zahtev = (Zahtev) mapper.convertToObject(xmlString, "Zahtev",
    			Zahtev.class);
        String documentId = zahtev.getPodnosilacZahteva().getJedinstveniMaticniBrojGradjana() + ".xml";
        dataAccessLayer.saveDocument(zahtev, folderId, documentId, Zahtev.class);
        return zahtev;
    }

    public String convertToXml(Zahtev zahtev){
        return mapper.convertToXml(zahtev,  Zahtev.class);
    }
}
