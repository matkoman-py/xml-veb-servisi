package com.example.officialsapplication.services;

import com.example.officialsapplication.services.MailSenderService;
import com.example.officialsapplication.dao.DataAccessLayer;
import com.example.officialsapplication.extractor.MetadataExtractor;
import com.example.officialsapplication.mappers.MultiwayMapper;
import com.example.officialsapplication.model.potvrda.Potvrda;
import com.example.officialsapplication.model.users.izvestaj.IzvestajOImunizaciji;
import com.example.officialsapplication.model.users.izvestaj.TBrojPodnetihInteresovanja;
import com.example.officialsapplication.model.users.izvestaj.TDatumDo;
import com.example.officialsapplication.model.users.izvestaj.TDatumIzdavanja;
import com.example.officialsapplication.model.users.izvestaj.TDatumOd;
import com.example.officialsapplication.model.users.izvestaj.TDozaInfo;
import com.example.officialsapplication.model.users.izvestaj.TPeriod;
import com.example.officialsapplication.model.users.izvestaj.TProizvodjaciInfo;
import com.example.officialsapplication.model.users.izvestaj.TZeleniSertifikat;
import com.example.officialsapplication.model.users.korisnik.Korisnik;
import com.example.officialsapplication.model.zeleni_sertifikat.TBrojSertifikata;
import com.example.officialsapplication.model.zeleni_sertifikat.TIme;
import com.example.officialsapplication.model.zeleni_sertifikat.TPrezime;
import com.example.officialsapplication.model.zeleni_sertifikat.TJmbg;
import com.example.officialsapplication.model.zeleni_sertifikat.TPacijent;
import com.example.officialsapplication.model.zeleni_sertifikat.TVakcinacija;
import com.example.officialsapplication.model.zeleni_sertifikat.ZeleniSertifikat;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@Service
public class IzvestajOImunizacijiService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final String folderId = "/db/officials-system/izvestaji";
    private final MetadataExtractor metadataExtractor;
    private RestTemplate restTemplate = new RestTemplate();
    private PdfGeneratorService pdfGeneratorService;
    private HtmlGeneratorService htmlGeneratorService;

    private final MailSenderService mailSenderService;
    private static DocumentBuilderFactory documentFactory;
	
	private static TransformerFactory transformerFactory;
	
	public static final String INPUT_FILE = "data/xslt/izvestaj.xml";
	
	public static final String XSL_FILE = "data/xslt/izvestaj.xsl";
	
	public static final String HTML_FILE = "gen/itext/izvestaj.html";
	
	public static final String OUTPUT_FILE = "gen/itext/izvestaj.pdf";
	
	static {

		/* Inicijalizacija DOM fabrike */
		documentFactory = DocumentBuilderFactory.newInstance();
		documentFactory.setNamespaceAware(true);
		documentFactory.setIgnoringComments(true);
		documentFactory.setIgnoringElementContentWhitespace(false);
		
		/* Inicijalizacija Transformer fabrike */
		transformerFactory = TransformerFactory.newInstance();
		
	}

    public IzvestajOImunizacijiService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper,
                                       MetadataExtractor metadataExtractor, MailSenderService mailSenderService, PdfGeneratorService pdfGeneratorService, HtmlGeneratorService htmlGeneratorService) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
        this.metadataExtractor = metadataExtractor;
        this.mailSenderService = mailSenderService;
        this.pdfGeneratorService = pdfGeneratorService;
        this.htmlGeneratorService = htmlGeneratorService;
    }

    public String getXmlAsText(String documentId) {
        return dataAccessLayer.getDocument(folderId, documentId).get();
    }

    public IzvestajOImunizaciji getXmlAsObject(String documentId) {
        String xmlString = dataAccessLayer.getDocument(folderId, documentId).get();

        return (IzvestajOImunizaciji) mapper.convertToObject(xmlString, "Izvestaj_o_imunizaciji",
                IzvestajOImunizaciji.class);
    }
    
    public String test(String dateFrom, String dateTo) throws DatatypeConfigurationException, IOException, DocumentException {
    	ResponseEntity<Integer> interesovanja
  	  = restTemplate.getForEntity("http://localhost:8087/api/interesovanja/getNumberForDate/"+dateFrom+"/"+dateTo, Integer.class);
    	
    	ResponseEntity<Integer> zahtevi
  	  = restTemplate.getForEntity("http://localhost:8087/api/zahtevi/getNumberForDate/"+dateFrom+"/"+dateTo, Integer.class);
    	
    	ResponseEntity<Integer> zelenisertifikati
    	  = restTemplate.getForEntity("http://localhost:8087/api/zelenisertifikati/getNumberForDate/"+dateFrom+"/"+dateTo, Integer.class);
      	
    	ResponseEntity<Integer[]> vakcine
    	  = restTemplate.getForEntity("http://localhost:8087/api/potvrde/getForReportDate/"+dateFrom+"/"+dateTo, Integer[].class);
    	
    	GregorianCalendar df = new GregorianCalendar(Integer.parseInt(dateFrom.split("-")[0]), Integer.parseInt(dateFrom.split("-")[1])-1, Integer.parseInt(dateFrom.split("-")[2]));
    	GregorianCalendar dt = new GregorianCalendar(Integer.parseInt(dateTo.split("-")[0]), Integer.parseInt(dateTo.split("-")[1])-1, Integer.parseInt(dateTo.split("-")[2]));
    	GregorianCalendar dn = new GregorianCalendar();
    	
    	IzvestajOImunizaciji izvestaj = new IzvestajOImunizaciji();
    	izvestaj.setBrojPodnetihInteresovanja(new TBrojPodnetihInteresovanja());
    	izvestaj.getBrojPodnetihInteresovanja().setValue(BigInteger.valueOf(interesovanja.getBody()));
    	izvestaj.setZeleniSertifikatInfo(new TZeleniSertifikat());
    	izvestaj.getZeleniSertifikatInfo().setBrojPrimljenihZahteva(BigInteger.valueOf(zahtevi.getBody()));
    	izvestaj.getZeleniSertifikatInfo().setBrojIzdatihSertifikata(BigInteger.valueOf(zelenisertifikati.getBody()));
    	izvestaj.setDozaInfo(new TDozaInfo());
    	izvestaj.getDozaInfo().setBrojDatihDoza(BigInteger.valueOf(vakcine.getBody()[0] + vakcine.getBody()[1]));
    	izvestaj.getDozaInfo().setBrojDatePrveDoze(BigInteger.valueOf(vakcine.getBody()[0]));
    	izvestaj.getDozaInfo().setBrojDateDrugeDoze(BigInteger.valueOf(vakcine.getBody()[1]));
    	izvestaj.setProizvodjaciInfo(new TProizvodjaciInfo());
    	izvestaj.getProizvodjaciInfo().setBrojDozaAstraZeneca(BigInteger.valueOf(vakcine.getBody()[5]));
    	izvestaj.getProizvodjaciInfo().setBrojDozaPfizerBioNTech(BigInteger.valueOf(vakcine.getBody()[2]));
    	izvestaj.getProizvodjaciInfo().setBrojDozaSinopharm(BigInteger.valueOf(vakcine.getBody()[3]));
    	izvestaj.getProizvodjaciInfo().setBrojDozaSputnikV(BigInteger.valueOf(vakcine.getBody()[4]));
    	izvestaj.setDatumIzdavanja(new TDatumIzdavanja());
    	izvestaj.getDatumIzdavanja().setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(dn.get(Calendar.YEAR), dn.get(Calendar.MONTH)+1, dn.get(Calendar.DAY_OF_MONTH), dn.get(Calendar.HOUR_OF_DAY), dn.get(Calendar.MINUTE), dn.get(Calendar.SECOND), DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED));

    	izvestaj.setPeriod(new TPeriod());
    	izvestaj.getPeriod().setDatumOd(new TDatumOd());
    	izvestaj.getPeriod().getDatumOd().setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(df.get(Calendar.YEAR), df.get(Calendar.MONTH)+1, df.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED));
    	izvestaj.getPeriod().setDatumDo(new TDatumDo());
    	izvestaj.getPeriod().getDatumDo().setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(dt.get(Calendar.YEAR), dt.get(Calendar.MONTH)+1, dt.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED));
    	izvestaj.setAbout("http://www.ftn.uns.ac.rs/Izvestaj_o_imunizaciji/"+izvestaj.getPeriod().getDatumOd().getValue().toString() +"-"+izvestaj.getPeriod().getDatumDo().getValue().toString());
    	saveXmlFromObject(izvestaj);
    	generateHTML(convertToXml(izvestaj), XSL_FILE);
		generatePDF(OUTPUT_FILE);
    	return convertToXml(izvestaj);
    }

    public IzvestajOImunizaciji saveXmlFromText(String xmlString) {
        IzvestajOImunizaciji izvestaj = (IzvestajOImunizaciji) mapper.convertToObject(xmlString, "Izvestaj_o_imunizaciji",
                IzvestajOImunizaciji.class);
        String documentId = izvestaj.getPeriod().getDatumOd().getValue().toString() +"-"+izvestaj.getPeriod().getDatumDo().getValue().toString()+".xml";
        dataAccessLayer.saveDocument(izvestaj, folderId, documentId, IzvestajOImunizaciji.class);

        try {
            metadataExtractor.extractAndSave(xmlString,"/izvestaji");
        } catch (FileNotFoundException | TransformerException e) {
            e.printStackTrace();
        }

        return izvestaj;
    }

    public IzvestajOImunizaciji saveXmlFromObject(IzvestajOImunizaciji izvestaj) {
        String documentId = izvestaj.getPeriod().getDatumOd().getValue().toString() +"-"+izvestaj.getPeriod().getDatumDo().getValue().toString()+".xml";
        dataAccessLayer.saveDocument(izvestaj, folderId, documentId, IzvestajOImunizaciji.class);
        return izvestaj;
    }
    
    public ByteArrayInputStream getPdf(String xmlName) throws Exception {
    	String xml = getXmlAsText(xmlName);
    	return pdfGeneratorService.generatePDF(xml, "data/xsl-fo/izvestaj_fo.xsl");
    }
    
    public ByteArrayInputStream getHtml(String xmlName) throws Exception {
    	String xml = getXmlAsText(xmlName);
    	return htmlGeneratorService.generateHTML(xml, "data/xslt/izvestaj.xsl");
    }

    public String convertToXml(IzvestajOImunizaciji izvestaj) {
        return mapper.convertToXml(izvestaj, IzvestajOImunizaciji.class);
    }

    public IzvestajOImunizaciji convertToObject(String xmlString) {
        return (IzvestajOImunizaciji) mapper.convertToObject(xmlString, "Izvestaj_o_imunizaciji",
                IzvestajOImunizaciji.class);
    }
    
	public void generatePDF(String filePath) throws IOException, DocumentException {
	        
	    	// Step 1
	    	Document document = new Document();
	        
	    	// Step 2
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
	        
	       
	        // Step 3
	        document.open();
	        
	       
	        
	        // Step 4
	        
	        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(HTML_FILE), Charset.forName("UTF-8"));

	        
	        // Step 5
	        document.close();
	        
	    }
	
	public org.w3c.dom.Document buildDocument(String xml) {

    	org.w3c.dom.Document document = null;
   
		try {
			
			DocumentBuilder builder = documentFactory.newDocumentBuilder();
			//document = builder.parse(new File(filePath)); 
			//OVO JE DODATO

			InputStream is = new ByteArrayInputStream(xml.getBytes());
			document = builder.parse(is);
			// DO OVDE
			
			
			if (document != null)
				System.out.println("[INFO] File parsed with no errors.");
			else
				System.out.println("[WARN] Document is null.");

		} catch (Exception e) {
			return null;
			
		} 

		return document;
	}
	
	public void generateHTML(String xmlPath, String xslPath) throws FileNotFoundException {
	    	
			try {
	
				// Initialize Transformer instance
				StreamSource transformSource = new StreamSource(new File(xslPath));
				Transformer transformer = transformerFactory.newTransformer(transformSource);
				transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				
				// Generate XHTML
				transformer.setOutputProperty(OutputKeys.METHOD, "xhtml");
	
				// Transform DOM to HTML
				DOMSource source = new DOMSource(buildDocument(xmlPath));
				StreamResult result = new StreamResult(new FileOutputStream(HTML_FILE));
				transformer.transform(source, result);
				
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerFactoryConfigurationError e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
	    
	    }
	
	
	public String convertToXml(ZeleniSertifikat zeleniSertifikat) {
        return mapper.convertToXml(zeleniSertifikat, ZeleniSertifikat.class);
    }


	
	public void zeleni(String id) throws DatatypeConfigurationException, IOException, DocumentException, MessagingException {
		GregorianCalendar dn = new GregorianCalendar();
		ResponseEntity<Korisnik> pacijent
  	  = restTemplate.getForEntity("http://localhost:8087/api/korisnici/getUser/"+id, Korisnik.class);
  	
  	ResponseEntity<Potvrda> potvrda
	  = restTemplate.getForEntity("http://localhost:8087/api/potvrde/"+id, Potvrda.class);
  	
  		Korisnik pacijentData = pacijent.getBody();
  		Potvrda potvrdaData = potvrda.getBody();
  	
  		ZeleniSertifikat zs = new ZeleniSertifikat();
  		zs.setBrojSertifikata(new TBrojSertifikata());
  		zs.getBrojSertifikata().setValue("202121-21");
  		zs.setDatumIzdavanja(new com.example.officialsapplication.model.zeleni_sertifikat.TDatumIzdavanja());
  		zs.getDatumIzdavanja().setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(dn.get(Calendar.YEAR), dn.get(Calendar.MONTH)+1, dn.get(Calendar.DAY_OF_MONTH), dn.get(Calendar.HOUR_OF_DAY), dn.get(Calendar.MINUTE), dn.get(Calendar.SECOND), DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED));
  		zs.setPodaciOPacijentu(new TPacijent());
  		zs.getPodaciOPacijentu().setBrojPasosa(pacijentData.getBrojPasosa());
  		zs.getPodaciOPacijentu().setDatumRodjenja(pacijentData.getDatumRodjenja());
		zs.getPodaciOPacijentu().setIme(new TIme());
		zs.getPodaciOPacijentu().setPrezime(new TPrezime());
		zs.getPodaciOPacijentu().getIme().setValue(pacijentData.getIme());
		zs.getPodaciOPacijentu().getPrezime().setValue(pacijentData.getPrezime());
  		zs.getPodaciOPacijentu().setJmbg(new TJmbg());
  		zs.getPodaciOPacijentu().getJmbg().setValue(pacijentData.getJmbg());
  		zs.getPodaciOPacijentu().setPol(pacijentData.getPol());
  		//List<TVakcinacija> vakcinaInfo = new ArrayList<TVakcinacija>();
  		TVakcinacija prvaDoza = new TVakcinacija();
  		TVakcinacija drugaDoza = new TVakcinacija();
  		if(potvrdaData.getVakcinacijaInfo().getPrvaDoza() != null) {
  			prvaDoza.setDatum(potvrdaData.getVakcinacijaInfo().getPrvaDoza().getDatumVakcine());
  			prvaDoza.setProizvodjacSerija(potvrdaData.getVakcinacijaInfo().getPrvaDoza().getSerijaVakcine());
  			prvaDoza.setZdravstvenaUstanova(potvrdaData.getVakcinacijaInfo().getZdravstvenaUstanova().getValue());
  			prvaDoza.setTip(potvrdaData.getVakcinacijaInfo().getNazivVakcine().getValue());
  		}
  		if(potvrdaData.getVakcinacijaInfo().getDrugaDoza() != null) {
  			drugaDoza.setDatum(potvrdaData.getVakcinacijaInfo().getDrugaDoza().getDatumVakcine());
  			drugaDoza.setProizvodjacSerija(potvrdaData.getVakcinacijaInfo().getDrugaDoza().getSerijaVakcine());
  			drugaDoza.setZdravstvenaUstanova(potvrdaData.getVakcinacijaInfo().getZdravstvenaUstanova().getValue());
  			drugaDoza.setTip(potvrdaData.getVakcinacijaInfo().getNazivVakcine().getValue());
  		}
  		System.out.println("DSADSASASDA " + potvrdaData.getVakcinacijaInfo().getNazivVakcine().getValue());
  		System.out.println("EIIII " + prvaDoza.getTip());
  		System.out.println("DSADSASASDA " + potvrdaData.getVakcinacijaInfo().getDrugaDoza().getSerijaVakcine());
  		zs.getPodaciOVakcinaciji().add(prvaDoza);
  		zs.getPodaciOVakcinaciji().add(drugaDoza);

  		zs.setQrKod("dSADSADKLDNLK");
  		String res = convertToXml(zs);
  		generateHTML(res, "data/xslt/zeleni.xsl");
		generatePDF("gen/itext/izvestaj.pdf");
		mailSenderService.odobrenZeleni(pacijentData);
  		
	}
    
}
