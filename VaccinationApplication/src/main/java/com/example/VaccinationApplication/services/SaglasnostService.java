package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.extractor.MetadataExtractor;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import com.example.VaccinationApplication.model.interesovanje.ListaInteresovanja;
import com.example.VaccinationApplication.model.saglasnost.ListaSaglasnosti;
import com.example.VaccinationApplication.model.saglasnost.Saglasnost;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;

@Service
public class SaglasnostService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/vaccination-system/saglasnosti";
    private final MetadataExtractor metadataExtractor;
    private final InteresovanjeService interesovanjeService;

    public SaglasnostService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper, MetadataExtractor metadataExtractor, InteresovanjeService interesovanjeService) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
        this.metadataExtractor = metadataExtractor;
        this.interesovanjeService = interesovanjeService;
        
    }

    public String getXmlAsText(String documentId){
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }

    public Saglasnost getXmlAsObject(String documentId) {
        String xmlString = dataAccessLayer.getDocument(folderId, documentId).get();
        return (Saglasnost) mapper.convertToObject(xmlString, "Saglasnost", Saglasnost.class);
    }

    public Saglasnost saveXmlFromText(String xmlString) throws FileNotFoundException, TransformerException {
        Saglasnost saglasnost = (Saglasnost) mapper.convertToObject(xmlString, "Saglasnost",
                Saglasnost.class);
        String documentId = saglasnost.getDrzavljanstvo().getJMBG() + ".xml";
        
        //SAGLASNOST === ZELENI SERTIFIKAT ----> (MORA KAD SE INITUJE SAGLASNOSTS DA SADRZI REFERENCU NA ODGOVARAJUCE INTERESOVANJE)
        //DODATI INTERESOVANJESERVICE KAO POLJE U OVAJ SERVICE
        //POZVATI METODU LINK IZ INTERESOVANJESERVICE

        String interesovanjeId = saglasnost.getHref().split("/")[4];
        interesovanjeService.link(documentId, interesovanjeId);
        
        try {
            metadataExtractor.extractAndSave(convertToXml(saglasnost),"/saglasnosti");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        
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
    
    public String convertToXml(ListaSaglasnosti saglasnost) {
        return mapper.convertToXml(saglasnost,  ListaSaglasnosti.class);
    }

    public Saglasnost convertToObject(String xmlString) {
        return (Saglasnost) mapper.convertToObject(xmlString, "Saglasnost", Saglasnost.class);
    }
    
	public String getAll() throws Exception {
	    	
	    	String xPath = "//Saglasnost";
	    	List<Saglasnost> saglasnosti = new ArrayList<Saglasnost>();
	        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/saglasnosti", xPath, "http://www.ftn.uns.ac.rs/Saglasnost");
	        for (String string : rezultat) {
				saglasnosti.add(convertToObject(string));
			}
	        ListaSaglasnosti ls = new ListaSaglasnosti();
	        ls.setSaglasnost(saglasnosti);
	        return convertToXml(ls);
	    }
	
	public String getAllForUser(String id) throws Exception {
		
		String xPath = "//Saglasnost[Drzavljanstvo/JMBG = '"+id+"' or Drzavljanstvo/Broj_pasosa_EBS = '"+id+"']";
    	List<Saglasnost> saglasnosti = new ArrayList<Saglasnost>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/saglasnosti", xPath, "http://www.ftn.uns.ac.rs/Saglasnost");
        for (String string : rezultat) {
			saglasnosti.add(convertToObject(string));
		}
        ListaSaglasnosti ls = new ListaSaglasnosti();
        ls.setSaglasnost(saglasnosti);
        return convertToXml(ls);
	}
	
	public String getAllForDate(String dateFrom, String dateTo) throws Exception {
		
		String xPath = "//Saglasnost[Podaci_o_pacijentu/number(translate(Datum,'-','')) >= "+dateFrom.replace("-", "")+" and Podaci_o_pacijentu/number(translate(Datum,'-','')) <="+dateTo.replace("-","")+ "]";
		List<Saglasnost> saglasnosti = new ArrayList<Saglasnost>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/saglasnosti", xPath, "http://www.ftn.uns.ac.rs/Saglasnost");
        for (String string : rezultat) {
			saglasnosti.add(convertToObject(string));
		}
        ListaSaglasnosti ls = new ListaSaglasnosti();
        ls.setSaglasnost(saglasnosti);
        return convertToXml(ls);
	}
}
