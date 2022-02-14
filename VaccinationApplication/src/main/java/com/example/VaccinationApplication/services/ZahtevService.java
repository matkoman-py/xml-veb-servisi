package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.extractor.MetadataExtractor;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.zahtev_zeleni_sertifikat.ListaZahtevaZelenogSertifikata;
import com.example.VaccinationApplication.model.zahtev_zeleni_sertifikat.Zahtev;
import com.example.VaccinationApplication.model.zeleni_sertifikat.ListaZelenihSertifikata;
import com.example.VaccinationApplication.model.zeleni_sertifikat.ZeleniSertifikat;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");  
		LocalDateTime now = LocalDateTime.now();  
		String dateTime = (String) dtf.format(now);  
        String documentId = zahtev.getPodnosilacZahteva().getJedinstveniMaticniBrojGradjana().getValue()+"-"+dateTime+ ".xml";
        
        if(zahtev.getAbout() == null) {
        	zahtev.setAbout("");
        }
        
        if(zahtev.getAbout().trim().equals("")) {
        	zahtev.setAbout("http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata/"+zahtev.getPodnosilacZahteva().getJedinstveniMaticniBrojGradjana().getValue()+"-"+dateTime);
        	xmlString = convertToXml(zahtev);
        }
        
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
    
    public String convertToXml(ListaZahtevaZelenogSertifikata zahtev)  throws FileNotFoundException, TransformerException {
        return mapper.convertToXml(zahtev,  ListaZahtevaZelenogSertifikata.class);
    }
    
    public Zahtev convertToObject(String xmlString) throws FileNotFoundException, TransformerException {
        return (Zahtev) mapper.convertToObject(xmlString, "ZahtevZelenogSertifikata", Zahtev.class);
    }
    
    public void link(String zeleniSertifikatId, String zahtevId) throws FileNotFoundException, TransformerException {
    	Zahtev updatedZahtev = getXmlAsObject(zahtevId);
    	
    	if(updatedZahtev.getHref() == null) {
    		updatedZahtev.setHref("");
    	}
    	

    	if(!updatedZahtev.getHref().trim().equals("")) {
    		return;
    	}
    	updatedZahtev.setRel("pred:answeredBy");
    	updatedZahtev.setHref("http://www.ftn.uns.ac.rs/zelenisertifikat/"+zeleniSertifikatId);
    	update(updatedZahtev, zahtevId +".xml");
    }
    
    public void update(Zahtev zahtev, String documentId) throws FileNotFoundException, TransformerException {
    	dataAccessLayer.saveDocument(zahtev, folderId, documentId, Zahtev.class);
    	try {
            metadataExtractor.extractAndSave(convertToXml(zahtev),"/zahtevi");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    
    public String getAll() throws Exception {
    	
    	String xPath = "//zahtev";
    	List<Zahtev> zahtevi = new ArrayList<Zahtev>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/zahtevi", xPath, "http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata");
        for (String string : rezultat) {
			zahtevi.add(convertToObject(string));
		}
        ListaZahtevaZelenogSertifikata lzzs = new ListaZahtevaZelenogSertifikata();
        lzzs.setZahtev(zahtevi);
        return convertToXml(lzzs);
    }
    
    public String getAllForUser(String id) throws Exception {
    	
    	String xPath = "//zahtev[Podnosilac_zahteva/Jedinstveni_maticni_broj_gradjana = '"+id+"']";
    	System.out.println(xPath);
    	List<Zahtev> zahtevi = new ArrayList<Zahtev>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/zahtevi", xPath, "http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata");
        for (String string : rezultat) {
			zahtevi.add(convertToObject(string));
		}
        ListaZahtevaZelenogSertifikata lzzs = new ListaZahtevaZelenogSertifikata();
        lzzs.setZahtev(zahtevi);
        return convertToXml(lzzs);
    }
    
    public String getAllForDate(String dateFrom, String dateTo) throws Exception {
    	
    	//		String xPath = "//Saglasnost[Podaci_o_pacijentu/number(translate(Datum,'-','')) >= "+dateFrom.replace("-", "")+" and Podaci_o_pacijentu/number(translate(Datum,'-','')) <="+dateTo.replace("-","")+ "]";
    	String xPath = "//zahtev[Informacije_o_zahtevu/number(translate(Datum_izdavanja,'-','')) >= "+dateFrom.replace("-", "")+" and Informacije_o_zahtevu/number(translate(Datum_izdavanja,'-','')) <= "+dateTo.replace("-","")+"]";
    	System.out.println(xPath);
    	List<Zahtev> zahtevi = new ArrayList<Zahtev>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/zahtevi", xPath, "http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata");
        for (String string : rezultat) {
			zahtevi.add(convertToObject(string));
		}
        ListaZahtevaZelenogSertifikata lzzs = new ListaZahtevaZelenogSertifikata();
        lzzs.setZahtev(zahtevi);
        return convertToXml(lzzs);
    }
    
    public int getNumberOfRequests(String dateFrom, String dateTo) throws Exception {
    	String xPath = "//zahtev[Informacije_o_zahtevu/number(translate(Datum_izdavanja,'-','')) >= "+dateFrom.replace("-", "")+" and Informacije_o_zahtevu/number(translate(Datum_izdavanja,'-','')) <= "+dateTo.replace("-","")+"]";
    	System.out.println(xPath);
    	List<Zahtev> zahtevi = new ArrayList<Zahtev>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/zahtevi", xPath, "http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata");
        return rezultat.size();
    }
    
    
}
