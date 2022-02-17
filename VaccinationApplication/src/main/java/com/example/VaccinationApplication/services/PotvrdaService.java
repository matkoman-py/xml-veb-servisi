package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.extractor.MetadataExtractor;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.potvrda.ListaPotvrda;
import com.example.VaccinationApplication.model.potvrda.Potvrda;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
    
    public String getForUser(String id) throws Exception {
    	
    	String xPath = "//Potvrda[pacijent/Jmbg = '"+id+"']";
    	List<Potvrda> potvrde = new ArrayList<Potvrda>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/potvrde", xPath, "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji");
        for (String string : rezultat) {
        	return convertToXml(convertToObject(string));
//			potvrde.add(convertToObject(string));
		}
        ListaPotvrda lp = new ListaPotvrda();
        lp.setPotvrda(potvrde);
        return convertToXml(lp);
    }
    
    public String getPotvrda(String id) throws Exception {
    	
    	String xPath = "//Potvrda[pacijent/Jmbg = '"+id+"']";
    	List<Potvrda> potvrde = new ArrayList<Potvrda>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/potvrde", xPath, "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji");
        for (String string : rezultat) {
			potvrde.add(convertToObject(string));
        }
        
        if(potvrde.size() == 0) return "";
        return "Potvrda";
    }

    public String searchPotvrdaContaining(String search) throws Exception {
        String searchQuery = String.format("xquery version \"3.1\";\n" +
                "\n" +
                "declare namespace pot=\"http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji\";\n" +
                "import module namespace functx=\"http://www.functx.com\";\n" +
                "\n" +
                "declare function local:search($keyword as xs:string)\n" +
                "{\n" +
                "    let $kolekcija := collection(\"/db/vaccination-system/potvrde\")\n" +
                "    let $rezultat :=\n" +
                "    (\n" +
                "        $kolekcija//pot:Potvrda[contains(., $keyword)]\n" +
                "    )\n" +
                "\n" +
                " return\n" +
                "    functx:distinct-nodes($rezultat)\n" +
                "};\n" +
                "\n" +
                "local:search(\"%s\")", search);
        List<String> found = dataAccessLayer.izvrsiXPathIzraz(folderId, searchQuery, "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji");
        List<Potvrda> rezultat = new ArrayList<>();

        for(String item : found) {
            rezultat.add(convertToObject(item));
        }

        ListaPotvrda lp = new ListaPotvrda();
        lp.setPotvrda(rezultat);
        return convertToXml(lp);
    }

    public String getPotvrdaAdvanced(String ime, String prezime, String ustanova, String datum) {
        String condition = "";
        String predicate;
        if(!ime.trim().equals("")) {
            condition += "?s <http://www.ftn.uns.ac.rs/predicate/ime_i_prezime> \"" + ime + " " + prezime + "\"^^<file:///C:/Users/marko/xml-veb-servisi/VaccinationApplication/gen/string> ;";
        }
//        if(!prezime.trim().equals("")) {
//            condition += "?s <http://www.ftn.uns.ac.rs/predicate/prezime_i_prezime> \"" + prezime + "\"^^<file:///C:/Users/marko/xml-veb-servisi/VaccinationApplication/gen/string> ;";
//        }
        if(!ustanova.trim().equals("")) {
            condition += "?s <http://www.ftn.uns.ac.rs/predicate/zdravstvena_ustanova> \"" + ustanova + "\"^^<file:///C:/Users/marko/xml-veb-servisi/VaccinationApplication/gen/string> .";
        }
        if(!datum.trim().equals("")) {
            condition += "?s <http://www.ftn.uns.ac.rs/predicate/datum> \"" + datum + "\"^^<file:///C:/Users/marko/xml-veb-servisi/VaccinationApplication/gen/date> ;";
        }
        if(condition.equals("")) {
            condition += "?s <http://www.ftn.uns.ac.rs/predicate/ime_i_prezime> ?o";
        }

        StringBuilder str = new StringBuilder();
        str.append("<listaPotvrda>");

        for(String s : metadataExtractor.filterFromRdf("/potvrde", condition)) {
            String id = s.split("/")[4];

            dataAccessLayer.getDocument(folderId, id);
//            str.append("<saglasnost>");
            str.append(dataAccessLayer.getDocument(folderId, id).get());
//            str.append("<id>").append(id).append("</id>");
//            str.append("</saglasnost>");
        }

        str.append(("</listaPotvrda>"));

        return str.toString();
    }
}
