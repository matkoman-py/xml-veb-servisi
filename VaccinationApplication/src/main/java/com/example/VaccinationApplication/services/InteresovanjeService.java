package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.exceptions.InteresovanjeAlreadyExistsException;
import com.example.VaccinationApplication.extractor.MetadataExtractor;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.Termin;
import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import com.example.VaccinationApplication.model.interesovanje.ListaInteresovanja;
import com.example.VaccinationApplication.model.zahtev_zeleni_sertifikat.Zahtev;
import com.example.VaccinationApplication.model.zeleni_sertifikat.ListaZelenihSertifikata;
import com.example.VaccinationApplication.model.zeleni_sertifikat.ZeleniSertifikat;

import org.apache.jena.base.Sys;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.*;

@Service
public class InteresovanjeService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/vaccination-system/interesovanja";
    private final TerminService terminService;
    private final MailSenderService mailSenderService;
    private final MetadataExtractor metadataExtractor;

    public InteresovanjeService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper, MetadataExtractor metadataExtractor,
                                TerminService terminService, MailSenderService mailSenderService) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
        this.metadataExtractor = metadataExtractor;
        this.terminService = terminService;
        this.mailSenderService = mailSenderService;
    }

    public String getXmlText(String documentId) {
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }

    public Interesovanje getXmlAsObject(String documentId) {
        String xmlString = dataAccessLayer.getDocument(folderId, documentId).get();

        return (Interesovanje) mapper.convertToObject(xmlString, "Interesovanje",
                Interesovanje.class);
    }

    public Interesovanje saveXmlFromText(String xmlString) throws Exception {
        Interesovanje interesovanje = (Interesovanje) mapper.convertToObject(xmlString, "Interesovanje",
                Interesovanje.class);
        String documentId = interesovanje.getPodaciOPrimaocu().getJMBG().getValue() + ".xml";

        if(dataAccessLayer.getDocument(folderId, interesovanje.getPodaciOPrimaocu().getJMBG().getValue()).isPresent()){
            throw new InteresovanjeAlreadyExistsException("Ne mozete vise puta iskazivati interesovanje!");
        }

        Termin termin = new Termin();
        termin.setJmbg(interesovanje.getPodaciOPrimaocu().getJMBG().getValue());
        termin.setVakcina(interesovanje.getOdabirVakcine());

        if (!terminService.proveriBrojVakcina(termin.getVakcina())) {
            terminService.saveZaCekanje(termin);
            mailSenderService.posaljiDaJeNaCekanju(interesovanje.getPodaciOPrimaocu().getKontakt().getAdresaElektronskePoste());
        } else {
            Termin sacuvani = terminService.saveRezervisani(termin);
            mailSenderService.posaljiRezervisan(interesovanje.getPodaciOPrimaocu().getKontakt().getAdresaElektronskePoste(),
                    sacuvani, interesovanje);
            terminService.smanjiBrojVakcina(termin.getVakcina());
            terminService.smanjiBrojVakcina(termin.getVakcina());
        }

        dataAccessLayer.saveDocument(interesovanje, folderId, documentId, Interesovanje.class);

        try {
            metadataExtractor.extractAndSave(xmlString, "/interesovanja");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return interesovanje;
    }



    public Interesovanje saveXmlFromObject(Interesovanje interesovanje) {
        String documentId = interesovanje.getPodaciOPrimaocu().getJMBG().getValue() + ".xml";
        dataAccessLayer.saveDocument(interesovanje, folderId, documentId, Interesovanje.class);

        return interesovanje;
    }

    public String convertToXml(Interesovanje interesovanje) {
        return mapper.convertToXml(interesovanje, Interesovanje.class);
    }

    public String convertToXml(ListaInteresovanja interesovanje) {
        return mapper.convertToXml(interesovanje, ListaInteresovanja.class);
    }

    public Interesovanje convertToObject(String xmlString) throws FileNotFoundException, TransformerException {
        return (Interesovanje) mapper.convertToObject(xmlString, "Interesovanje", Interesovanje.class);
    }

    public void link(String saglasnostID, String interesovanjeId) throws FileNotFoundException, TransformerException {
        Interesovanje updatedInteresovanje = getXmlAsObject(interesovanjeId);

        if (updatedInteresovanje.getHref() == null) {
            updatedInteresovanje.setHref("");
        }

        if (!updatedInteresovanje.getHref().trim().equals("")) {
            return;
        }
        updatedInteresovanje.setRel("pred:answeredBy");
        updatedInteresovanje.setHref("http://www.ftn.uns.ac.rs/Saglasnost/" + saglasnostID);
        update(updatedInteresovanje, interesovanjeId + ".xml");
    }

    public void update(Interesovanje interesovanje, String documentId) throws FileNotFoundException, TransformerException {
        dataAccessLayer.saveDocument(interesovanje, folderId, documentId, Interesovanje.class);
        try {
            metadataExtractor.extractAndSave(convertToXml(interesovanje), "/interesovanja");
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

        String xPath = "//interesovanje[Podaci_o_primaocu/JMBG = '" + id + "']";
        List<Interesovanje> interesovanja = new ArrayList<Interesovanje>();
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/interesovanja", xPath, "http://www.ftn.uns.ac.rs/interesovanje");
        for (String string : rezultat) {
			    interesovanja.add(convertToObject(string));
          convertToXml(convertToObject(string));
		    }
        ListaInteresovanja li = new ListaInteresovanja();
        li.setIzvestaj(interesovanja);
        return convertToXml(li);
    }

public String getForUser(String id) throws Exception {
	
	String xPath = "//interesovanje[Podaci_o_primaocu/JMBG = '"+id+"']";
	List<Interesovanje> interesovanja = new ArrayList<Interesovanje>();
    List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/interesovanja", xPath, "http://www.ftn.uns.ac.rs/interesovanje");
    for (String string : rezultat) {
		return convertToXml(convertToObject(string));
	}
    ListaInteresovanja li = new ListaInteresovanja();
    li.setIzvestaj(interesovanja);
    return convertToXml(li);
}

public String getInteresovanje(String id) throws Exception {
	
	String xPath = "//interesovanje[Podaci_o_primaocu/JMBG = '"+id+"']";
	List<Interesovanje> interesovanja = new ArrayList<Interesovanje>();
    List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/interesovanja", xPath, "http://www.ftn.uns.ac.rs/interesovanje");
    for (String string : rezultat) {
    	interesovanja.add(convertToObject(string));
    }
    if(interesovanja.size() == 0) return "";
    return "Interesovanje";
}



	public int getNumberOfInterests(String dateFrom, String dateTo) throws Exception {
		String xPath = "//interesovanje[number(translate(Datum,'-','')) >= "+dateFrom.replace("-", "")+" and number(translate(Datum,'-','')) <="+dateTo.replace("-","")+ "]";
		System.out.println(xPath);
		List<Interesovanje> interesovanja = new ArrayList<Interesovanje>();
	    List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/interesovanja", xPath, "http://www.ftn.uns.ac.rs/interesovanje");
	    return rezultat.size();
	}
    public Interesovanje getOneForUser(String id) throws Exception {
        String xPath = "//interesovanje[Podaci_o_primaocu/JMBG = '" + id + "']";
        List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/interesovanja", xPath, "http://www.ftn.uns.ac.rs/interesovanje");
        return convertToObject(rezultat.get(0));
    }

    public String getAllForDate(String dateFrom, String dateTo) throws Exception {

        String xPath = "//interesovanje[number(translate(Datum,'-','')) >= " + dateFrom.replace("-", "") + " and number(translate(Datum,'-','')) <=" + dateTo.replace("-", "") + "]";
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

}
