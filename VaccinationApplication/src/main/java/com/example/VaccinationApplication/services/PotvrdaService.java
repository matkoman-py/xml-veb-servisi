package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.potvrda.Potvrda;
import com.example.VaccinationApplication.model.zeleni_sertifikat.ZeleniSertifikat;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;

@Service
public class PotvrdaService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/vaccination-system/potvrde";

    public PotvrdaService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
    }

    public String getXmlText(String documentId){
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }

    public Potvrda getXmlAsObject(String documentId){
        String xmlString = dataAccessLayer.getDocument(folderId, documentId).get();

        return (Potvrda) mapper.convertToObject(xmlString, "PotvrdaOVakcinaciji",
                Potvrda.class);
    }

    public Potvrda saveXmlFromText(String xmlString){
        Potvrda potvrda = (Potvrda) mapper.convertToObject(xmlString, "PotvrdaOVakcinaciji",
                Potvrda.class);
        String documentId = potvrda.getSifraPotvrde() + ".xml";
        dataAccessLayer.saveDocument(potvrda, folderId, documentId, Potvrda.class);
        return potvrda;
    }

    public Potvrda saveXmlFromObject(Potvrda potvrda){
        String documentId = potvrda.getSifraPotvrde() + ".xml";
        dataAccessLayer.saveDocument(potvrda, folderId, documentId, Potvrda.class);
        return potvrda;
    }

    public String convertToXml(Potvrda potvrda){
        return mapper.convertToXml(potvrda,  Potvrda.class);
    }

    public Potvrda convertToObject(String xmlString) throws FileNotFoundException, TransformerException {

        return (Potvrda) mapper.convertToObject(xmlString, "PotvrdaOVakcinaciji", Potvrda.class);
    }
}
