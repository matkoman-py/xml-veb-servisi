package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.exceptions.SaglasnostNijeIskazanaException;
import com.example.VaccinationApplication.exceptions.TerminNePostojiException;
import com.example.VaccinationApplication.extractor.MetadataExtractor;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import com.example.VaccinationApplication.model.interesovanje.ListaInteresovanja;
import com.example.VaccinationApplication.model.potvrda.*;
import com.example.VaccinationApplication.model.saglasnost.ListaSaglasnosti;
import com.example.VaccinationApplication.model.saglasnost.Saglasnost;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.TransformerException;

import org.springframework.stereotype.Service;

import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.util.Optional;

@Service
public class SaglasnostService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/vaccination-system/saglasnosti";
    private final MetadataExtractor metadataExtractor;
    private final InteresovanjeService interesovanjeService;
    private final TerminService terminService;
    private final PotvrdaService potvrdaService;

    public SaglasnostService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper, MetadataExtractor metadataExtractor
            , InteresovanjeService interesovanjeService, TerminService terminService, PotvrdaService potvrdaService) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
        this.metadataExtractor = metadataExtractor;
        this.interesovanjeService = interesovanjeService;
        this.terminService = terminService;
        this.potvrdaService = potvrdaService;
    }

    public String getXmlAsText(String documentId) {
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }

    public Saglasnost getXmlAsObject(String documentId) {
        String xmlString = dataAccessLayer.getDocument(folderId, documentId).get();
        return (Saglasnost) mapper.convertToObject(xmlString, "Saglasnost", Saglasnost.class);
    }

    public Saglasnost saveXmlFromText(String xmlString) throws Exception {

        Saglasnost saglasnost = (Saglasnost) mapper.convertToObject(xmlString, "Saglasnost",
                Saglasnost.class);
        String doza = terminService.proveriTermin(saglasnost.getDrzavljanstvo().getJMBG());
        if (doza.equals("")) {
            throw new TerminNePostojiException("Ne mozete iskazati saglasnost bez prethodno dobijenog termina vakcinacije!");
        }
        String vakcina = terminService.proveriVakcinu(saglasnost.getDrzavljanstvo().getJMBG());
        if (!vakcina.equals(saglasnost.getPodaciOPacijentu().getIzjavaSaglasnosti().getNazivLeka())) {
            throw new TerminNePostojiException("Vakcina za koju ste izjavili saglasnost nije ista kao ona sa interesovanja!");
        }

        String documentId = saglasnost.getDrzavljanstvo().getJMBG() + doza + ".xml";

        String interesovanjeId = saglasnost.getHref().split("/")[4];
        interesovanjeService.link(documentId, interesovanjeId);

        try {
            metadataExtractor.extractAndSave(convertToXml(saglasnost), "/saglasnosti");
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
        return mapper.convertToXml(saglasnost, Saglasnost.class);
    }

    public String convertToXml(ListaSaglasnosti saglasnost) {
        return mapper.convertToXml(saglasnost, ListaSaglasnosti.class);
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

        String xPath = "//Saglasnost[Drzavljanstvo/JMBG = '" + id + "' or Drzavljanstvo/Broj_pasosa_EBS = '" + id + "']";
        List<Saglasnost> saglasnosti = new ArrayList<Saglasnost>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/saglasnosti", xPath, "http://www.ftn.uns.ac.rs/Saglasnost");
        for (String string : rezultat) {
            saglasnosti.add(convertToObject(string));
        }
        ListaSaglasnosti ls = new ListaSaglasnosti();
        ls.setSaglasnost(saglasnosti);
        return convertToXml(ls);
    }

    public String getForUser(String id) throws Exception {

        String xPath = "//Saglasnost[Drzavljanstvo/JMBG = '" + id + "' or Drzavljanstvo/Broj_pasosa_EBS = '" + id + "']";
        List<Saglasnost> saglasnosti = new ArrayList<Saglasnost>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/saglasnosti", xPath, "http://www.ftn.uns.ac.rs/Saglasnost");
        for (String string : rezultat) {
            return convertToXml(convertToObject(string));
            //saglasnosti.add(convertToObject(string));
        }
        ListaSaglasnosti ls = new ListaSaglasnosti();
        ls.setSaglasnost(saglasnosti);
        return convertToXml(ls);
    }

    public String getAllForDate(String dateFrom, String dateTo) throws Exception {

        String xPath = "//Saglasnost[Podaci_o_pacijentu/number(translate(Datum,'-','')) >= " + dateFrom.replace("-", "") + " and Podaci_o_pacijentu/number(translate(Datum,'-','')) <=" + dateTo.replace("-", "") + "]";
        List<Saglasnost> saglasnosti = new ArrayList<Saglasnost>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/saglasnosti", xPath, "http://www.ftn.uns.ac.rs/Saglasnost");
        for (String string : rezultat) {
            saglasnosti.add(convertToObject(string));
        }
        ListaSaglasnosti ls = new ListaSaglasnosti();
        ls.setSaglasnost(saglasnosti);
        return convertToXml(ls);
    }

    public String getSaglasnost(String id) throws Exception {

        String xPath = "//Saglasnost[Drzavljanstvo/JMBG = '" + id + "' or Drzavljanstvo/Broj_pasosa_EBS = '" + id + "']";
        List<Saglasnost> saglasnosti = new ArrayList<Saglasnost>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/saglasnosti", xPath, "http://www.ftn.uns.ac.rs/Saglasnost");
        for (String string : rezultat) {
            saglasnosti.add(convertToObject(string));
        }
        if (saglasnosti.size() == 0) return "";
        return "Saglasnost";
    }

    public String getSaglasnostZaEvidentiranje(String id) throws FileNotFoundException {
        Optional<String> saglasnost = dataAccessLayer.getDocument(folderId, id + "-prva-doza");
        if (!saglasnost.isPresent()) {
            throw new SaglasnostNijeIskazanaException("Pacijent nije iskazao saglasnost! Vakcinacija nije moguca!");
        }
        return saglasnost.get();
    }

    public String searchSaglasnostContaining(String search) throws Exception {
        String searchQuery = String.format("xquery version \"3.1\";\n" +
                "\n" +
                "declare namespace sag=\"http://www.ftn.uns.ac.rs/Saglasnost\";\n" +
                "import module namespace functx=\"http://www.functx.com\";\n" +
                "\n" +
                "declare function local:search($keyword as xs:string)\n" +
                "{\n" +
                "    let $kolekcija := collection(\"/db/vaccination-system/saglasnosti\")\n" +
                "    let $rezultat :=\n" +
                "    (\n" +
                "        $kolekcija//sag:Saglasnost[contains(., $keyword)]\n" +
                "    )\n" +
                "\n" +
                " return\n" +
                "    functx:distinct-nodes($rezultat)\n" +
                "};\n" +
                "\n" +
                "local:search(\"%s\")", search);

        List<String> found = dataAccessLayer.izvrsiXPathIzraz(folderId, searchQuery, "http://www.ftn.uns.ac.rs/potvrda_o_vakcinaciji");
        List<Saglasnost> rezultat = new ArrayList<>();

        for (String item : found) {
            rezultat.add(convertToObject(item));
        }

        ListaSaglasnosti ls = new ListaSaglasnosti();
        ls.setSaglasnost(rezultat);
        return convertToXml(ls);
    }

    public String getSaglasnostAdvanced(String ime, String prezime, String ustanova, String datum) {
        String condition = "";
        String predicate;
        if (!ime.trim().equals("")) {
            condition += "?s <http://www.ftn.uns.ac.rs/predicate/ime> \"" + ime + "\"^^<file:///C:/Users/marko/xml-veb-servisi/VaccinationApplication/gen/string> ;";
        }
        if (!prezime.trim().equals("")) {
            condition += "?s <http://www.ftn.uns.ac.rs/predicate/prezime> \"" + prezime + "\"^^<file:///C:/Users/marko/xml-veb-servisi/VaccinationApplication/gen/string> ;";
        }
        if (!ustanova.trim().equals("")) {
            condition += "?s <http://www.ftn.uns.ac.rs/predicate/zdravstvena_ustanova> \"" + ustanova + "\"^^<file:///C:/Users/marko/xml-veb-servisi/VaccinationApplication/gen/string> .";
        }
        if (!datum.trim().equals("")) {
            condition += "?s <http://www.ftn.uns.ac.rs/predicate/datum> \"" + datum + "\"^^<file:///C:/Users/marko/xml-veb-servisi/VaccinationApplication/gen/date> ;";
        }
        if (condition.equals("")) {
            condition += "?s <http://www.ftn.uns.ac.rs/predicate/ime> ?o";
        }

        StringBuilder str = new StringBuilder();
        str.append("<listaSaglasnosti>");

        for (String s : metadataExtractor.filterFromRdf("/saglasnosti", condition)) {
            String id = s.split("/")[4];

            dataAccessLayer.getDocument(folderId, id);
//            str.append("<saglasnost>");
            str.append(dataAccessLayer.getDocument(folderId, id).get());
//            str.append("<id>").append(id).append("</id>");
//            str.append("</saglasnost>");
        }

        str.append(("</listaSaglasnosti>"));

        return str.toString();
    }

    public Saglasnost updateSaglasnost(String doza, String xmlString) throws Exception {


        Saglasnost saglasnost = (Saglasnost) mapper.convertToObject(xmlString, "Saglasnost",
                Saglasnost.class);
        String documentId = saglasnost.getDrzavljanstvo().getJMBG() + "-" + doza + "-doza" + ".xml";

        if(doza.equals("druga")){
            Optional<String> provera = dataAccessLayer.getDocument(folderId, saglasnost.getDrzavljanstvo().getJMBG() + "-" + doza + "-doza");
            if(!provera.isPresent()){
                throw new SaglasnostNijeIskazanaException("Saglasnost za primanje druge vakcine nije iskazana!");
            }
        }

        Potvrda potvrda = new Potvrda();
        potvrda.setSifraPotvrde(saglasnost.getDrzavljanstvo().getJMBG());
        String imeIprezime= saglasnost.getPodaciOPacijentu().getIme().getValue() + " "+ saglasnost.getPodaciOPacijentu().getPrezime().getValue();
        TImeIPrezime tImeIPrezime =new TImeIPrezime();
        tImeIPrezime.setValue(imeIprezime);
        tImeIPrezime.setProperty("pred:ime_i_prezime");
        tImeIPrezime.setDatatype("xs:string");
        TPacijent tPacijent = new TPacijent();
        tPacijent.setImeIPrezime(tImeIPrezime);
        tPacijent.setDatumRodjenja(saglasnost.getPodaciOPacijentu().getDatumRodjenja());
        if(saglasnost.getPodaciOPacijentu().getPol().value().equals("muski")){
            tPacijent.setPol("Musko");
        }else{
            tPacijent.setPol("Zensko");
        }

        TJmbg tJmbg = new TJmbg();
        tJmbg.setProperty("pred:jmbg");
        tJmbg.setDatatype("xs:string");
        tJmbg.setValue(saglasnost.getDrzavljanstvo().getJMBG());
        tPacijent.setJmbg(tJmbg);
        potvrda.setPacijent(tPacijent);

        //qr kod?
        potvrda.setQrKod("qrcakod");

        XMLGregorianCalendar prvaDozaDatum;
        String prvaDozaSerija;
        if(doza.equals("prva")){
            prvaDozaDatum = saglasnost.getEvidencijaOVakcinaciji().getVakcinacija().getDatumVakcinacije();
            prvaDozaSerija = saglasnost.getEvidencijaOVakcinaciji().getVakcinacija().getLot();
            TVakcinacija tVakcinacija = new TVakcinacija();
            TNazivVakcine tNazivVakcine = new TNazivVakcine();
            tNazivVakcine.setValue(saglasnost.getEvidencijaOVakcinaciji().getVakcinacija().getNazivVakcine().getValue());
            tNazivVakcine.setProperty("pred:naziv_vakcine");
            tNazivVakcine.setDatatype("xs:string");
            tVakcinacija.setNazivVakcine(tNazivVakcine);
            TDatumIzdavanja tDatumIzdavanja = new TDatumIzdavanja();
            tDatumIzdavanja.setProperty("pred:datum");
            tDatumIzdavanja.setDatatype("xs:date");
            tDatumIzdavanja.setValue(saglasnost.getEvidencijaOVakcinaciji().getVakcinacija().getDatumVakcinacije());
            tVakcinacija.setDatumIzdavanja(tDatumIzdavanja);
            TZdravstvenaUstanova tZdravstvenaUstanova = new TZdravstvenaUstanova();
            tZdravstvenaUstanova.setProperty("pred:zdravstvena_ustanova");
            tZdravstvenaUstanova.setDatatype("xs:string");
            tZdravstvenaUstanova.setValue(saglasnost.getEvidencijaOVakcinaciji().getNazivUstanove().getValue());
            tVakcinacija.setZdravstvenaUstanova(tZdravstvenaUstanova);
            TDozaInfo prvaDoza = new TDozaInfo();
            prvaDoza.setDatumVakcine(prvaDozaDatum);
            prvaDoza.setSerijaVakcine(prvaDozaSerija);
            tVakcinacija.setPrvaDoza(prvaDoza);
            potvrda.setVakcinacijaInfo(tVakcinacija);
            potvrda.setAbout(saglasnost.getDrzavljanstvo().getJMBG());

            potvrdaService.saveXmlFromObject(potvrda);
            //posalji mejl za drugi termin
            terminService.posaljiMejlZaDrugiTermin(saglasnost.getDrzavljanstvo().getJMBG());
        }
        else{
            Potvrda staraPotvrda = potvrdaService.getPotvrda(saglasnost.getDrzavljanstvo().getJMBG());
            TDozaInfo drugaDoza = new TDozaInfo();
            drugaDoza.setDatumVakcine(saglasnost.getEvidencijaOVakcinaciji().getRevakcinacija().getDatumVakcinacije());
            drugaDoza.setSerijaVakcine(saglasnost.getEvidencijaOVakcinaciji().getRevakcinacija().getLot());
            staraPotvrda.getVakcinacijaInfo().setDrugaDoza(drugaDoza);
            potvrdaService.saveXmlFromObject(staraPotvrda);

        }


        String interesovanjeId = saglasnost.getHref().split("/")[4];
        interesovanjeService.link(documentId, interesovanjeId);

        try {
            metadataExtractor.extractAndSave(convertToXml(saglasnost), "/saglasnosti");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        dataAccessLayer.saveDocument(saglasnost, folderId, documentId, Saglasnost.class);
        return saglasnost;
    }
}
