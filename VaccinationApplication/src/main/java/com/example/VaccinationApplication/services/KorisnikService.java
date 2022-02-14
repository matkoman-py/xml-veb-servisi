package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.extractor.MetadataExtractor;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import com.example.VaccinationApplication.model.users.korisnik.Korisnik;
import com.example.VaccinationApplication.model.zahtev_zeleni_sertifikat.ListaZahtevaZelenogSertifikata;
import com.example.VaccinationApplication.model.zahtev_zeleni_sertifikat.Zahtev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

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
    
    public Korisnik getUser(String id) throws Exception {
    	String xPath = "//korisnik[jmbg = '"+id+"']";
    	System.out.println(xPath);
    	List<Zahtev> zahtevi = new ArrayList<Zahtev>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/korisnici", xPath, "http://www.ftn.uns.ac.rs/korisnik");
        mapper.convertToObject(rezultat.get(0), "Korisnik", Korisnik.class);
        return  (Korisnik) mapper.convertToObject(rezultat.get(0), "Korisnik", Korisnik.class);
    }

}
