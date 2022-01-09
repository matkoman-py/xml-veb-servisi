package com.example.officialsapplication.services;

import com.example.officialsapplication.dao.DataAccessLayer;
import com.example.officialsapplication.mappers.MultiwayMapper;
import com.example.officialsapplication.model.users.izvestaj.IzvestajOImunizaciji;
import org.springframework.stereotype.Service;

@Service
public class IzvestajOImunizacijiService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/vaccination-system/izvestaji";

    public IzvestajOImunizacijiService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
    }

    public String getXmlAsText(String documentId) {
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }

    public IzvestajOImunizaciji getXmlAsObject(String documentId) {
        String xmlString = dataAccessLayer.getDocument(folderId, documentId).get();

        return (IzvestajOImunizaciji) mapper.convertToObject(xmlString, "Izvestaj_o_imunizaciji",
                IzvestajOImunizaciji.class);
    }

    public IzvestajOImunizaciji saveXmlFromText(String xmlString) {
        IzvestajOImunizaciji izvestaj = (IzvestajOImunizaciji) mapper.convertToObject(xmlString, "Izvestaj_o_imunizaciji",
                IzvestajOImunizaciji.class);
        String documentId = izvestaj.getId() + ".xml";
        dataAccessLayer.saveDocument(izvestaj, folderId, documentId, IzvestajOImunizaciji.class);
        return izvestaj;
    }

    public IzvestajOImunizaciji saveXmlFromObject(IzvestajOImunizaciji izvestaj) {
        String documentId = izvestaj.getId() + ".xml";
        dataAccessLayer.saveDocument(izvestaj, folderId, documentId, IzvestajOImunizaciji.class);
        return izvestaj;
    }

    public String convertToXml(IzvestajOImunizaciji izvestaj) {
        return mapper.convertToXml(izvestaj, IzvestajOImunizaciji.class);
    }

    public IzvestajOImunizaciji convertToObject(String xmlString) {
        return (IzvestajOImunizaciji) mapper.convertToObject(xmlString, "Izvestaj_o_imunizaciji",
                IzvestajOImunizaciji.class);
    }
}
