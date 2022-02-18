package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.DataAccessLayer;
import com.example.VaccinationApplication.extractor.MetadataExtractor;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import com.example.VaccinationApplication.model.users.korisnik.Korisnik;
import com.example.VaccinationApplication.model.zahtev_zeleni_sertifikat.ListaZahtevaZelenogSertifikata;
import com.example.VaccinationApplication.model.zahtev_zeleni_sertifikat.Zahtev;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class KorisnikService {

	private final InteresovanjeService interesovanjeService;
	private final PotvrdaService potvrdaService;
	private final SaglasnostService saglasnostService;
	private final ZahtevService zahtevService;
	private final ZeleniSertifikatService zeleniSertifikatService;
	private final PdfTransformerService pdfTransformerService;
	private final HtmlTransformerService htmlTransformerService;
	private final DataAccessLayer dataAccessLayer;
	private final MultiwayMapper mapper;
	private final String folderId = "/db/vaccination-system/korisnici";
	private final MetadataExtractor metadataExtractor;

	@Autowired
	public KorisnikService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper, MetadataExtractor metadataExtractor,
			InteresovanjeService interesovanjeService, PotvrdaService potvrdaService,
			SaglasnostService saglasnostService, ZahtevService zahtevService,
			ZeleniSertifikatService zeleniSertifikatService, PdfTransformerService pdfTransformerService,
			HtmlTransformerService htmlTransformerService) {
		this.interesovanjeService = interesovanjeService;
		this.potvrdaService = potvrdaService;
		this.saglasnostService = saglasnostService;
		this.zahtevService = zahtevService;
		this.zeleniSertifikatService = zeleniSertifikatService;
		this.dataAccessLayer = dataAccessLayer;
		this.mapper = mapper;
		this.metadataExtractor = metadataExtractor;
		this.pdfTransformerService = pdfTransformerService;
		this.htmlTransformerService = htmlTransformerService;
	}

	public Korisnik saveXmlFromText(String xmlString) {
		Korisnik korisnik = (Korisnik) mapper.convertToObject(xmlString, "Korisnik", Korisnik.class);
		String documentId = korisnik.getEmail() + ".xml";

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(korisnik.getSifra());
		korisnik.setSifra(encodedPassword);

		dataAccessLayer.saveDocument(korisnik, folderId, documentId, Korisnik.class);
		try {
			metadataExtractor.extractAndSave(xmlString, "/korisnici");
		} catch (FileNotFoundException | TransformerException e) {
			e.printStackTrace();
		}

		return korisnik;
	}

	public Korisnik getXmlAsObject(String documentId) {
		String xmlString = dataAccessLayer.getDocument(folderId, documentId).get();

		return (Korisnik) mapper.convertToObject(xmlString, "Korisnik", Korisnik.class);
	}

	public Korisnik getUser(String id) throws Exception {
		String xPath = "//korisnik[jmbg = '" + id + "']";
		System.out.println(xPath);
		List<Zahtev> zahtevi = new ArrayList<Zahtev>();
		List<String> rezultat = dataAccessLayer.izvrsiXPathIzraz("/db/vaccination-system/korisnici", xPath,
				"http://www.ftn.uns.ac.rs/korisnik");
		mapper.convertToObject(rezultat.get(0), "Korisnik", Korisnik.class);
		return (Korisnik) mapper.convertToObject(rezultat.get(0), "Korisnik", Korisnik.class);
	}

	public ArrayList<String> getAllDocuments(String id) throws Exception {
		ArrayList<String> results = new ArrayList<String>();
		
		if(interesovanjeService.getInteresovanje(id) != "") results.add(interesovanjeService.getInteresovanje(id));
		if(potvrdaService.getPotvrdaString(id) != "") results.add(potvrdaService.getPotvrdaString(id));
		if(saglasnostService.getSaglasnost(id) != "") results.add(saglasnostService.getSaglasnost(id));
		if(zahtevService.getZahtevString(id) != null) results.addAll(zahtevService.getZahtevString(id));
		if(zeleniSertifikatService.getZeleniSertifikat(id) != "") results.add(zeleniSertifikatService.getZeleniSertifikat(id));

		return results;
	}

	public InputStream getPDF(String jmbg, String docType) throws Exception {
		if(docType.equals("interesovanje")) return pdfTransformerService.transformToPDF(interesovanjeService.getForUser(jmbg), docType);
		else if(docType.equals("potvrda")) return pdfTransformerService.transformToPDF(potvrdaService.getForUser(jmbg), docType);
		else if(docType.equals("saglasnost")) return pdfTransformerService.transformToPDF(saglasnostService.getForUser(jmbg), docType);
		else if(docType.equals("zahtev")) return pdfTransformerService.transformToPDF(zahtevService.getForUser(jmbg), docType);
		else if(docType.equals("zeleni")) return pdfTransformerService.transformToPDF(zeleniSertifikatService.getForUser(jmbg), docType);
		
		return null;
	}

	public InputStream getHTML(String jmbg, String docType) throws Exception {
		if(docType.equals("interesovanje")) return htmlTransformerService.generateHTML(interesovanjeService.getForUser(jmbg), "data/xslt/interesovanje.xsl");
		else if(docType.equals("potvrda")) return htmlTransformerService.generateHTML(potvrdaService.getForUser(jmbg), "data/xslt/potvrda.xsl");
		else if(docType.equals("saglasnost")) return htmlTransformerService.generateHTML(saglasnostService.getForUser(jmbg), "data/xslt/saglasnost.xsl");
		else if(docType.startsWith("zahtev")) return htmlTransformerService.generateHTML(zahtevService.getForUser(jmbg), "data/xslt/zahtev.xsl");
		else if(docType.equals("zeleni")) return htmlTransformerService.generateHTML(zeleniSertifikatService.getForUser(jmbg), "data/xslt/zeleni.xsl");
		
		return null;
	}
}
