package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.extractor.MetadataExtractor;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import com.example.VaccinationApplication.model.interesovanje.ListaInteresovanja;
import com.example.VaccinationApplication.model.potvrda.ListaPotvrda;
import com.example.VaccinationApplication.model.potvrda.Potvrda;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PotvrdaService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final MetadataExtractor metadataExtractor;
    private final String folderId = "/db/vaccination-system/potvrde";
    private final TerminService terminService;
    public PotvrdaService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper, MetadataExtractor metadataExtractor,
                          TerminService terminService) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
        this.metadataExtractor = metadataExtractor;
        this.terminService = terminService;
    }

    public String getXmlText(String documentId){
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }

    public Potvrda getXmlAsObject(String documentId){
        String xmlString = dataAccessLayer.getDocument(folderId, documentId).get();

        return (Potvrda) mapper.convertToObject(xmlString, "PotvrdaOVakcinaciji",
                Potvrda.class);
    }

    public Potvrda saveXmlFromText(String xmlString) throws Exception {

        Potvrda potvrda = (Potvrda) mapper.convertToObject(xmlString, "PotvrdaOVakcinaciji",
                Potvrda.class);
        String documentId = potvrda.getSifraPotvrde() + ".xml";

        dataAccessLayer.saveDocument(potvrda, folderId, documentId, Potvrda.class);
        try {
            metadataExtractor.extractAndSave(xmlString,"/potvrde");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

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
    
    public String convertToXml(ListaPotvrda potvrda){
        return mapper.convertToXml(potvrda,  ListaPotvrda.class);
    }

    public Potvrda convertToObject(String xmlString) throws FileNotFoundException, TransformerException {

        return (Potvrda) mapper.convertToObject(xmlString, "PotvrdaOVakcinaciji", Potvrda.class);
    }
    
    public String getAll() throws Exception {
    	
    	String xPath = "//Potvrda";
    	List<Potvrda> potvrde = new ArrayList<Potvrda>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/potvrde", xPath, "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji");
        for (String string : rezultat) {
			potvrde.add(convertToObject(string));
		}
        ListaPotvrda lp = new ListaPotvrda();
        lp.setPotvrda(potvrde);
        return convertToXml(lp);
    }
    
    public String getAllForDate(String dateFrom, String dateTo) throws Exception {
    	
    	String xPath = "//Potvrda[Vakcinacija_info/number(translate(Datum_izdavanja,'-','')) >= "+dateFrom.replace("-", "")+" and Vakcinacija_info/number(translate(Datum_izdavanja,'-','')) <="+dateTo.replace("-","")+ "]";
    	List<Potvrda> potvrde = new ArrayList<Potvrda>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/potvrde", xPath, "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji");
        for (String string : rezultat) {
			potvrde.add(convertToObject(string));
		}
        ListaPotvrda lp = new ListaPotvrda();
        lp.setPotvrda(potvrde);
        return convertToXml(lp);
    }
    
public List<Integer> getReportDataForDate(String dateFrom, String dateTo) throws Exception {
    	
    	String xPath = "//Potvrda[Vakcinacija_info/number(translate(Datum_izdavanja,'-','')) >= "+dateFrom.replace("-", "")+" and Vakcinacija_info/number(translate(Datum_izdavanja,'-','')) <="+dateTo.replace("-","")+ "]";
    	List<Potvrda> potvrde = new ArrayList<Potvrda>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/potvrde", xPath, "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji");
        int prvaDoza = 0;
        int drugaDoza = 0;
        int pfizer = 0;
        int sinopharm = 0;
        int sputnik = 0;
        int astrazenneca = 0;
        for (String string : rezultat) {
        	int numDoza = 0;
        	Potvrda potvrda = convertToObject(string);
        	System.out.println(potvrda.getVakcinacijaInfo().getNazivVakcine().getValue().length());
			if(potvrda.getVakcinacijaInfo().getPrvaDoza() != null) {
				prvaDoza++;
				numDoza++;
			}
			if(potvrda.getVakcinacijaInfo().getDrugaDoza() != null) {
				drugaDoza++;
				numDoza++;
			}
			
			
			if(potvrda.getVakcinacijaInfo().getNazivVakcine().getValue().equals("Pfizer-BioNTech")) {
				pfizer += numDoza;
			}
			else if(potvrda.getVakcinacijaInfo().getNazivVakcine().getValue().equals("SinoPharm")) {
				System.out.println("USAOOOO");
				sinopharm += numDoza;
			}
			else if(potvrda.getVakcinacijaInfo().getNazivVakcine().getValue().equals("Sputnik V")) {
				sputnik += numDoza;
			}
			else if(potvrda.getVakcinacijaInfo().getNazivVakcine().getValue().equals("AstraZenneca-Oxford")) {
				astrazenneca += numDoza;
			}	
		}
        List<Integer> data = Arrays.asList(prvaDoza,drugaDoza,pfizer,sinopharm,sputnik,astrazenneca);
        
        return data;
    }

    public String getAllForUser(String id) throws Exception {
	
    	String xPath = "//Potvrda[pacijent/Jmbg = '"+id+"']";
    	List<Potvrda> potvrde = new ArrayList<Potvrda>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/potvrde", xPath, "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji");
        for (String string : rezultat) {
			potvrde.add(convertToObject(string));
		}
        ListaPotvrda lp = new ListaPotvrda();
        lp.setPotvrda(potvrde);
        return convertToXml(lp);
    }
    
    public Potvrda getPotvrda(String id) throws Exception {
    	
    	String xPath = "//Potvrda[pacijent/Jmbg = '"+id+"']";
    	List<Potvrda> potvrde = new ArrayList<Potvrda>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/potvrde", xPath, "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji");
        for (String string : rezultat) {
			potvrde.add(convertToObject(string));
        }
        return potvrde.get(0);
    }
}
