package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.extractor.MetadataExtractor;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.zahtev_zeleni_sertifikat.Zahtev;
import java.io.FileNotFoundException;
import javax.xml.transform.TransformerException;
import org.springframework.stereotype.Service;

@Service
public class ZahtevService {
	
	private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/vaccination-system/zahtevi";
    private final MetadataExtractor metadataExtractor;

    public ZahtevService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper, MetadataExtractor metadataExtractor) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
        this.metadataExtractor = metadataExtractor;
    }

    public String getXmlAsText(String documentId)  throws FileNotFoundException, TransformerException {
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }

    public Zahtev getXmlAsObject(String documentId)  throws FileNotFoundException, TransformerException {
    	String xmlString = dataAccessLayer.getDocument(folderId, documentId).get();
    	
        return (Zahtev) mapper.convertToObject(xmlString, "ZahtevZelenogSertifikata",
        		Zahtev.class);
    }
    
    public Zahtev saveXmlFromText(String xmlString)  throws FileNotFoundException, TransformerException {
    	Zahtev zahtev = (Zahtev) mapper.convertToObject(xmlString, "ZahtevZelenogSertifikata",
    			Zahtev.class);
        String documentId = zahtev.getPodnosilacZahteva().getJedinstveniMaticniBrojGradjana().getValue() + ".xml";
        dataAccessLayer.saveDocument(zahtev, folderId, documentId, Zahtev.class);
        try {
            metadataExtractor.extractAndSave(xmlString,"/zahtevi");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return zahtev;
    }

    public Zahtev saveXmlFromObject(Zahtev zahtev)  throws FileNotFoundException, TransformerException {
        String documentId = zahtev.getPodnosilacZahteva().getJedinstveniMaticniBrojGradjana().getValue().replace('/', '-') + ".xml";
        
        dataAccessLayer.saveDocument(zahtev, folderId, documentId, Zahtev.class);
        return zahtev;
    }
    
    public String convertToXml(Zahtev zahtev)  throws FileNotFoundException, TransformerException {
        return mapper.convertToXml(zahtev,  Zahtev.class);
    }
    
    public Zahtev convertToObject(String xmlString) throws FileNotFoundException, TransformerException {
        return (Zahtev) mapper.convertToObject(xmlString, "ZahtevZelenogSertifikata", Zahtev.class);
    }
    
    
}
