package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.extractor.MetadataExtractor;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import com.example.VaccinationApplication.model.interesovanje.ListaInteresovanja;
import com.example.VaccinationApplication.model.zahtev_zeleni_sertifikat.Zahtev;
import com.example.VaccinationApplication.model.zeleni_sertifikat.ListaZelenihSertifikata;
import com.example.VaccinationApplication.model.zeleni_sertifikat.ZeleniSertifikat;

import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class InteresovanjeService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/vaccination-system/interesovanja";
    private final MetadataExtractor metadataExtractor;

    public InteresovanjeService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper, MetadataExtractor metadataExtractor) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
        this.metadataExtractor = metadataExtractor;

    }

    public String getXmlText(String documentId){
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }

    public Interesovanje getXmlAsObject(String documentId){
        String xmlString = dataAccessLayer.getDocument(folderId, documentId).get();

        return (Interesovanje) mapper.convertToObject(xmlString, "Interesovanje",
                Interesovanje.class);
    }

    public Interesovanje saveXmlFromText(String xmlString){
        Interesovanje interesovanje = (Interesovanje) mapper.convertToObject(xmlString, "Interesovanje",
                Interesovanje.class);
        String documentId = interesovanje.getPodaciOPrimaocu().getJMBG().getValue() + ".xml";
      
        dataAccessLayer.saveDocument(interesovanje, folderId, documentId, Interesovanje.class);
        try {
            metadataExtractor.extractAndSave(xmlString,"/interesovanja");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return interesovanje;
    }

    public Interesovanje saveXmlFromObject(Interesovanje interesovanje){
        String documentId = interesovanje.getPodaciOPrimaocu().getJMBG().getValue() + ".xml";
        dataAccessLayer.saveDocument(interesovanje, folderId, documentId, Interesovanje.class);
        
        return interesovanje;
    }

    public String convertToXml(Interesovanje interesovanje){
        return mapper.convertToXml(interesovanje,  Interesovanje.class);
    }
    
    public String convertToXml(ListaInteresovanja interesovanje){
        return mapper.convertToXml(interesovanje,  ListaInteresovanja.class);
    }

    public Interesovanje convertToObject(String xmlString) throws FileNotFoundException, TransformerException {
        return (Interesovanje) mapper.convertToObject(xmlString, "Interesovanje", Interesovanje.class);
    }
    
    public void link(String saglasnostID, String interesovanjeId) throws FileNotFoundException, TransformerException {
    	Interesovanje updatedInteresovanje = getXmlAsObject(interesovanjeId);
    	
    	if(updatedInteresovanje.getHref() == null) {
    		updatedInteresovanje.setHref("");
    	}
    	
    	if(!updatedInteresovanje.getHref().trim().equals("")) {
    		return;
    	}
    	updatedInteresovanje.setRel("pred:answeredBy");
    	updatedInteresovanje.setHref("http://www.ftn.uns.ac.rs/Saglasnost/"+saglasnostID);
    	update(updatedInteresovanje, interesovanjeId +".xml");
    }
    
    public void update(Interesovanje interesovanje, String documentId) throws FileNotFoundException, TransformerException {
    	dataAccessLayer.saveDocument(interesovanje, folderId, documentId, Interesovanje.class);
    	try {
            metadataExtractor.extractAndSave(convertToXml(interesovanje),"/interesovanja");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    
    public String getAll() throws Exception {
    	
    	String xPath = "//interesovanje";
    	List<Interesovanje> interesovanja = new ArrayList<Interesovanje>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/interesovanja", xPath, "http://www.ftn.uns.ac.rs/interesovanje");
        for (String string : rezultat) {
			interesovanja.add(convertToObject(string));
		}
        ListaInteresovanja li = new ListaInteresovanja();
        li.setIzvestaj(interesovanja);
        return convertToXml(li);
    }
    
public String getAllForUser(String id) throws Exception {
    	
    	String xPath = "//interesovanje[Podaci_o_primaocu/JMBG = '"+id+"']";
    	List<Interesovanje> interesovanja = new ArrayList<Interesovanje>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/interesovanja", xPath, "http://www.ftn.uns.ac.rs/interesovanje");
        for (String string : rezultat) {
			interesovanja.add(convertToObject(string));
		}
        ListaInteresovanja li = new ListaInteresovanja();
        li.setIzvestaj(interesovanja);
        return convertToXml(li);
    }

public String getAllForDate(String dateFrom, String dateTo) throws Exception {
	
	String xPath = "//interesovanje[number(translate(Datum,'-','')) >= "+dateFrom.replace("-", "")+" and number(translate(Datum,'-','')) <="+dateTo.replace("-","")+ "]";
	System.out.println(xPath);
	List<Interesovanje> interesovanja = new ArrayList<Interesovanje>();
    List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/interesovanja", xPath, "http://www.ftn.uns.ac.rs/interesovanje");
    for (String string : rezultat) {
		interesovanja.add(convertToObject(string));
	}
    ListaInteresovanja li = new ListaInteresovanja();
    li.setIzvestaj(interesovanja);
    return convertToXml(li);
}

	public int getNumberOfInterests(String dateFrom, String dateTo) throws Exception {
		String xPath = "//interesovanje[number(translate(Datum,'-','')) >= "+dateFrom.replace("-", "")+" and number(translate(Datum,'-','')) <="+dateTo.replace("-","")+ "]";
		System.out.println(xPath);
		List<Interesovanje> interesovanja = new ArrayList<Interesovanje>();
	    List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/interesovanja", xPath, "http://www.ftn.uns.ac.rs/interesovanje");
	    return rezultat.size();
	}
    
//    public void link(String zeleniSertifikatId, String zahtevId) throws FileNotFoundException, TransformerException {
//    	Zahtev updatedZahtev = getXmlAsObject(zahtevId);
//    	
//    	if(updatedZahtev.getHref() == null) {
//    		updatedZahtev.setHref("");
//    	}
//    	
//    	if(!updatedZahtev.getHref().isBlank()) {
//    		return;
//    	}
//    	updatedZahtev.setRel("pred:answeredBy");
//    	updatedZahtev.setHref("http://www.ftn.uns.ac.rs/zelenisertifikat/"+zeleniSertifikatId);
//    	update(updatedZahtev, zahtevId +".xml");
//    }
//    
//    public void update(Zahtev zahtev, String documentId) throws FileNotFoundException, TransformerException {
//    	dataAccessLayer.saveDocument(zahtev, folderId, documentId, Zahtev.class);
//    	try {
//            metadataExtractor.extractAndSave(convertToXml(zahtev),"/zahtevi");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (TransformerException e) {
//            e.printStackTrace();
//        }
//    }
}
