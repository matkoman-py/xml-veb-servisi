package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.dto.MetadataDTO;
import com.example.VaccinationApplication.extractor.MetadataExtractor;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import com.example.VaccinationApplication.model.interesovanje.ListaInteresovanja;
import com.example.VaccinationApplication.model.potvrda.ListaPotvrda;
import com.example.VaccinationApplication.model.potvrda.Potvrda;
import com.example.VaccinationApplication.model.zeleni_sertifikat.ListaZelenihSertifikata;
import com.example.VaccinationApplication.model.zeleni_sertifikat.ZeleniSertifikat;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.springframework.stereotype.Service;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XMLResource;

@Service
public class ZeleniSertifikatService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final MetadataExtractor metadataExtractor;
    private final String folderId = "/db/vaccination-system/zeleni-sertifikati";
    private final ZahtevService zahtevService;
    

    public ZeleniSertifikatService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper, MetadataExtractor metadataExtractor, ZahtevService zahtevService) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
        this.metadataExtractor = metadataExtractor;
        this.zahtevService = zahtevService;
    }

    public String getXmlAsText(String documentId){
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }
    
    public ZeleniSertifikat getXmlAsObject(String documentId){
    	String xmlString = dataAccessLayer.getDocument(folderId, documentId).get();
    	
        return (ZeleniSertifikat) mapper.convertToObject(xmlString, "ZeleniSertifikat",
        		ZeleniSertifikat.class);
    }

    public ZeleniSertifikat saveXmlFromText(String xmlString) throws FileNotFoundException, TransformerException{
        ZeleniSertifikat zeleniSertifikat = (ZeleniSertifikat) mapper.convertToObject(xmlString, "ZeleniSertifikat",
        		ZeleniSertifikat.class);
        String documentId = zeleniSertifikat.getBrojSertifikata().getValue() + ".xml";
        dataAccessLayer.saveDocument(zeleniSertifikat, folderId, documentId, ZeleniSertifikat.class);

        String zahtevId = zeleniSertifikat.getHref().split("/")[4];
        zahtevService.link(zahtevId, "yes");

        try {
            metadataExtractor.extractAndSave(xmlString,"/zeleni-sertifikat");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return zeleniSertifikat;
    }
    
    public ZeleniSertifikat saveXmlFromObject(ZeleniSertifikat zeleniSertifikat){
        String documentId = zeleniSertifikat.getBrojSertifikata().getValue().replace('/', '-') + ".xml";
        
        dataAccessLayer.saveDocument(zeleniSertifikat, folderId, documentId, ZeleniSertifikat.class);
        return zeleniSertifikat;
    }

    public String convertToXml(ZeleniSertifikat zeleniSertifikat){
        return mapper.convertToXml(zeleniSertifikat,  ZeleniSertifikat.class);
    }
    
    public String convertToXml(ListaZelenihSertifikata zeleniSertifikat){
        return mapper.convertToXml(zeleniSertifikat,  ListaZelenihSertifikata.class);
    }
    
    
    public ZeleniSertifikat convertToObject(String xmlString) throws FileNotFoundException, TransformerException{
    	
        return (ZeleniSertifikat) mapper.convertToObject(xmlString, "ZeleniSertifikat", ZeleniSertifikat.class);
    }
    
    
    public String getAll() throws Exception {
    	
    	String xPath = "//zeleni_sertifikat";
    	List<ZeleniSertifikat> zeleniSertifikati = new ArrayList<ZeleniSertifikat>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/zeleni-sertifikati", xPath, "http://www.ftn.uns.ac.rs/zelenisertifikat");
        for (String string : rezultat) {
			zeleniSertifikati.add(convertToObject(string));
		}
        ListaZelenihSertifikata lzs = new ListaZelenihSertifikata();
        lzs.setIzvestaj(zeleniSertifikati);
        return convertToXml(lzs);
    }
    
    public String getAllForDate(String dateFrom, String dateTo) throws Exception {
    	//String xPath = "//zahtev[Informacije_o_zahtevu/number(translate(Datum_izdavanja,'-','')) >= "+dateFrom.replace("-", "")+" and Informacije_o_zahtevu/number(translate(Datum_izdavanja,'-','')) <= "+dateTo.replace("-","")+"]";

    	String xPath = "//zeleni_sertifikat[number(translate(substring-before(datum_izdavanja,'T'),'-','')) >= "+dateFrom.replace("-","")+" and number(translate(substring-before(datum_izdavanja,'T'),'-','')) <= " + dateTo.replace("-", "")+"]";
    	List<ZeleniSertifikat> zeleniSertifikati = new ArrayList<ZeleniSertifikat>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/zeleni-sertifikati", xPath, "http://www.ftn.uns.ac.rs/zelenisertifikat");
        for (String string : rezultat) {
			zeleniSertifikati.add(convertToObject(string));
		}
        ListaZelenihSertifikata lzs = new ListaZelenihSertifikata();
        lzs.setIzvestaj(zeleniSertifikati);
        return convertToXml(lzs);
    }
    
    public int getNumberOfCertificates(String dateFrom, String dateTo) throws Exception {
    	//String xPath = "//zahtev[Informacije_o_zahtevu/number(translate(Datum_izdavanja,'-','')) >= "+dateFrom.replace("-", "")+" and Informacije_o_zahtevu/number(translate(Datum_izdavanja,'-','')) <= "+dateTo.replace("-","")+"]";

    	String xPath = "//zeleni_sertifikat[number(translate(substring-before(datum_izdavanja,'T'),'-','')) >= "+dateFrom.replace("-","")+" and number(translate(substring-before(datum_izdavanja,'T'),'-','')) <= " + dateTo.replace("-", "")+"]";
    	List<ZeleniSertifikat> zeleniSertifikati = new ArrayList<ZeleniSertifikat>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/zeleni-sertifikati", xPath, "http://www.ftn.uns.ac.rs/zelenisertifikat");
        return rezultat.size();
    }
    
	public String getAllForUser(String id) throws Exception {
	    	
		String xPath = "//zeleni_sertifikat[podaci_o_pacijentu/jmbg = '"+id+"']";
    	List<ZeleniSertifikat> zeleniSertifikati = new ArrayList<ZeleniSertifikat>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/zeleni-sertifikati", xPath, "http://www.ftn.uns.ac.rs/zelenisertifikat");
        for (String string : rezultat) {
			zeleniSertifikati.add(convertToObject(string));
		}
        ListaZelenihSertifikata lzs = new ListaZelenihSertifikata();
        lzs.setIzvestaj(zeleniSertifikati);
        return convertToXml(lzs);
	    }
	public String getForUser(String id) throws Exception {
    	
		String xPath = "//zeleni_sertifikat[podaci_o_pacijentu/jmbg = '"+id+"']";
    	List<ZeleniSertifikat> zeleniSertifikati = new ArrayList<ZeleniSertifikat>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/zeleni-sertifikati", xPath, "http://www.ftn.uns.ac.rs/zelenisertifikat");
        for (String string : rezultat) {
        	return convertToXml(convertToObject(string));
			//zeleniSertifikati.add(convertToObject(string));
		}
        ListaZelenihSertifikata lzs = new ListaZelenihSertifikata();
        lzs.setIzvestaj(zeleniSertifikati);
        return convertToXml(lzs);
	    }
	
	public String getZeleniSertifikat(String id) throws Exception {
		
		String xPath = "//zeleni_sertifikat[podaci_o_pacijentu/jmbg = '"+id+"']";
    	List<ZeleniSertifikat> zeleniSertifikati = new ArrayList<ZeleniSertifikat>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/zeleni-sertifikati", xPath, "http://www.ftn.uns.ac.rs/zelenisertifikat");
	    for (String string : rezultat) {
	    	zeleniSertifikati.add(convertToObject(string));
	    }
	    if(zeleniSertifikati.size() == 0) return "";
	    return "Zeleni sertifikat";
	}

    public String searchSertifikatContaining(String search) throws Exception {
        String searchQuery = String.format("xquery version \"3.1\";\n" +
                "\n" +
                "declare namespace zel=\"http://www.ftn.uns.ac.rs/zelenisertifikat\";\n" +
                "import module namespace functx=\"http://www.functx.com\";\n" +
                "\n" +
                "declare function local:search($keyword as xs:string)\n" +
                "{\n" +
                "    let $kolekcija := collection(\"/db/vaccination-system/zeleni-sertifikati\")\n" +
                "    let $rezultat :=\n" +
                "    (\n" +
                "        $kolekcija//zel:zeleni_sertifikat[contains(., $keyword)]\n" +
                "    )\n" +
                "\n" +
                " return\n" +
                "    functx:distinct-nodes($rezultat)\n" +
                "};\n" +
                "\n" +
                "local:search(\"%s\")", search);
        List<String> found = dataAccessLayer.izvrsiXPathIzraz(folderId, searchQuery, "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji");
        List<ZeleniSertifikat> rezultat = new ArrayList<>();

        StringBuilder str = new StringBuilder();
        str.append("<listaSertifikata>\n");

        for(String item : found) {
            str.append("<sertifikat>\n");
            ZeleniSertifikat sertifikat = convertToObject(item);

            str.append("<sifraSertifikata>");
            str.append(sertifikat.getBrojSertifikata().getValue());
            str.append("</sifraSertifikata>\n");

            str.append("<linkedDocNamespace>");
            str.append(sertifikat.getHref().split("/")[3]);
            str.append("</linkedDocNamespace>\n");

            str.append("<linkedDocName>");
            str.append(sertifikat.getHref().split("/")[4]);
            str.append("</linkedDocName>\n");
            str.append("</sertifikat>\n");
        }

        str.append("</listaSertifikata>\n");
        return str.toString();
    }

    public String getSertifikatAdvanced(String ime, String prezime, String ustanova, String datum, boolean poklapanje) throws FileNotFoundException, TransformerException {
        ArrayList<String> conditions = new ArrayList<>();

        if(!ime.trim().equals("")) {
            conditions.add("?s <http://www.ftn.uns.ac.rs/predicate/ime> \"" + ime + "\"^^<file:///C:/Users/marko/xml-veb-servisi/OfficialsApplication/gen/string> ;");
        }
        if(!prezime.trim().equals("")) {
            conditions.add("?s <http://www.ftn.uns.ac.rs/predicate/prezime> \"" + prezime + "\"^^<file:///C:/Users/marko/xml-veb-servisi/OfficialsApplication/gen/string> ;");
        }
//        if(!ustanova.trim().equals("")) {
//            condition += "?s <http://www.ftn.uns.ac.rs/predicate/zdravstvena_ustanova> \"" + ustanova + "\"^^<file:///C:/Users/marko/xml-veb-servisi/VaccinationApplication/gen/string> .";
//        }
        if(!datum.trim().equals("")) {
            conditions.add("?s <http://www.ftn.uns.ac.rs/predicate/datum> \"" + datum + "\"^^<file:///C:/Users/marko/xml-veb-servisi/OfficialsApplication/gen/date> ;");
        }
        if(conditions.isEmpty()) {
            conditions.add("?s <http://www.ftn.uns.ac.rs/predicate/ime> ?o");
        }

        HashSet<String> results = new HashSet<>();

        for(String condition : conditions) {
            HashSet<String> result = metadataExtractor.filterFromRdf("/zeleni-sertifikat", condition);
            if(poklapanje) {
                if(conditions.indexOf(condition) == 0) {
                    results.addAll(result);
                }
                else {
                    results.retainAll(result);
                }
            } else {
                results.addAll(result);
            }
        }

        StringBuilder str = new StringBuilder();
        str.append("<listaSertifikata>\n");

        for(String s : results) {
            String id = s.split("/")[4];

            dataAccessLayer.getDocument(folderId, id);
//            str.append(dataAccessLayer.getDocument(folderId, id).get());

            ZeleniSertifikat sertifikat = convertToObject(dataAccessLayer.getDocument(folderId, id).get());
            str.append("<sertifikat>\n");

            str.append("<sifraSertifikata>");
            str.append(sertifikat.getBrojSertifikata().getValue());
            str.append("</sifraSertifikata>\n");

            str.append("<linkedDocNamespace>");
            str.append(sertifikat.getHref().split("/")[3]);
            str.append("</linkedDocNamespace>\n");

            str.append("<linkedDocName>");
            str.append(sertifikat.getHref().split("/")[4]);
            str.append("</linkedDocName>\n");
            str.append("</sertifikat>\n");

        }

        str.append(("</listaSertifikata>\n"));

        return str.toString();
    }

    public MetadataDTO getMetadataJSON(String id) {
        return new MetadataDTO("<http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata/" + id + ">", metadataExtractor.getMetadata("/zeleni-sertifikat", "/zelenisertifikat", id));
    }

    public String getMetadataRDF(String id) {
        return metadataExtractor.getRdfMetadata("/zeleni-sertifikat", "/zelenisertifikat", id);
    }
}
