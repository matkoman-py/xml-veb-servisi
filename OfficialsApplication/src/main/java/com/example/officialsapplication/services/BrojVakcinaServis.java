package com.example.officialsapplication.services;

import com.example.officialsapplication.dao.DataAccessLayer;
import com.example.officialsapplication.extractor.MetadataExtractor;
import com.example.officialsapplication.mappers.MultiwayMapper;
import com.example.officialsapplication.model.users.BrojVakcina;
import com.example.officialsapplication.model.users.ListaBrojVakcina;
import com.example.officialsapplication.model.users.izvestaj.IzvestajOImunizaciji;
import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrojVakcinaServis {
    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/officials-system/broj-vakcina";
    private final MetadataExtractor metadataExtractor;

    public BrojVakcinaServis(DataAccessLayer dataAccessLayer, MultiwayMapper mapper,
                                       MetadataExtractor metadataExtractor) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
        this.metadataExtractor = metadataExtractor;
    }

    public BrojVakcina createAndUpdateBrojVakcina(String xmlString) {
        BrojVakcina brVak = (BrojVakcina) mapper.convertToObject(xmlString, "BrojVakcina",
                BrojVakcina.class);
        String documentId = brVak.getVakcina()+".xml";
        dataAccessLayer.saveDocument(brVak, folderId, documentId, BrojVakcina.class);

        return brVak;
    }

    public BrojVakcina smanjiBrojVakcina(String vakcina) {
        String xmlString = dataAccessLayer.getDocument(folderId, vakcina).get();
        BrojVakcina brVak = convertToObject(xmlString);
        brVak.setBroj(brVak.getBroj() - 1);
        String documentId = brVak.getVakcina()+".xml";
        dataAccessLayer.saveDocument(brVak, folderId, documentId, BrojVakcina.class);
        return brVak;
    }

    public Integer getBrojVakcina(String vakcina) {
        String xmlString = dataAccessLayer.getDocument(folderId, vakcina).get();
        BrojVakcina brVak = convertToObject(xmlString);
        return brVak.getBroj();
    }

    public BrojVakcina convertToObject(String xmlString) {
        return (BrojVakcina) mapper.convertToObject(xmlString, "BrojVakcina",
                BrojVakcina.class);
    }

    public String getAll() throws Exception {

        String xPath = "//BrojVakcina";
        List<BrojVakcina> lista = new ArrayList<BrojVakcina>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/officials-system/broj-vakcina", xPath, "http://www.ftn.uns.ac.rs/broj-vakcina");
        for (String string : rezultat) {
            lista.add(convertToObject(string));
        }
        ListaBrojVakcina li = new ListaBrojVakcina();
        li.setBrojVakcina(lista);
        return convertToXml(li);
    }

    public String convertToXml(ListaBrojVakcina lista) {
        return mapper.convertToXml(lista, ListaBrojVakcina.class);
    }
}
