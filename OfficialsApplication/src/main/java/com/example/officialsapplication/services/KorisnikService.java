package com.example.officialsapplication.services;

import com.example.officialsapplication.dao.DataAccessLayer;
import com.example.officialsapplication.extractor.MetadataExtractor;
import com.example.officialsapplication.mappers.MultiwayMapper;
import com.example.officialsapplication.model.users.korisnik.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;

@Service
public class KorisnikService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/vaccination-system/korisnici";
    private final MetadataExtractor metadataExtractor;

    @Autowired
    public KorisnikService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper, MetadataExtractor metadataExtractor) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
        this.metadataExtractor = metadataExtractor;
    }

    public Korisnik saveXmlFromText(String xmlString){
        Korisnik korisnik = (Korisnik) mapper.convertToObject(xmlString, "Korisnik",
                Korisnik.class);
        String documentId = korisnik.getEmail() + ".xml";

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(korisnik.getSifra());
        korisnik.setSifra(encodedPassword);

        dataAccessLayer.saveDocument(korisnik, folderId, documentId, Korisnik.class);
        try {
        	System.out.println("USAOOOO");
            metadataExtractor.extractAndSave(xmlString,"/korisnici");
        } catch (FileNotFoundException | TransformerException e) {
            e.printStackTrace();
        }

        return korisnik;
    }

    public Korisnik getXmlAsObject(String documentId){
        String xmlString = dataAccessLayer.getDocument(folderId, documentId).get();

        return (Korisnik) mapper.convertToObject(xmlString, "Korisnik",
                Korisnik.class);
    }

}
