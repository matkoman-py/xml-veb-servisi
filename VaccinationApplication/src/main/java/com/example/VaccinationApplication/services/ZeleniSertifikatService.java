package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.mappers.MultiwayMapper;

import com.example.VaccinationApplication.model.zeleni_sertifikat.ZeleniSertifikat;
import org.springframework.stereotype.Service;

@Service
public class ZeleniSertifikatService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/vaccination-system/zeleni-sertifikati";

    public ZeleniSertifikatService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
    }

    public String getXmlAsText(String documentId){
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }
    
    public ZeleniSertifikat getXmlAsObject(String documentId){
    	String xmlString = dataAccessLayer.getDocument(folderId, documentId).get();
    	
        return (ZeleniSertifikat) mapper.convertToObject(xmlString, "ZeleniSertifikat",
        		ZeleniSertifikat.class);
    }

    public ZeleniSertifikat saveXmlFromText(String xmlString){
        ZeleniSertifikat zeleniSertifikat = (ZeleniSertifikat) mapper.convertToObject(xmlString, "ZeleniSertifikat",
        		ZeleniSertifikat.class);
        String documentId = zeleniSertifikat.getBrojSertifikata().getValue().replace('/', '-') + ".xml";
        dataAccessLayer.saveDocument(zeleniSertifikat, folderId, documentId, ZeleniSertifikat.class);
        return zeleniSertifikat;
    }
    
    public ZeleniSertifikat saveXmlFromObject(ZeleniSertifikat zeleniSertifikat){
        String documentId = zeleniSertifikat.getBrojSertifikata().getValue().replace('/', '-') + ".xml";
        dataAccessLayer.saveDocument(zeleniSertifikat, folderId, documentId, ZeleniSertifikat.class);
        return zeleniSertifikat;
    }

    public String convertToXml(ZeleniSertifikat zeleniSertifikat){
        return mapper.convertToXml(zeleniSertifikat,  ZeleniSertifikat.class);
    }
    
    public ZeleniSertifikat convertToObject(String xmlString){
        return (ZeleniSertifikat) mapper.convertToObject(xmlString, "ZeleniSertifikat", ZeleniSertifikat.class);
    }
}
