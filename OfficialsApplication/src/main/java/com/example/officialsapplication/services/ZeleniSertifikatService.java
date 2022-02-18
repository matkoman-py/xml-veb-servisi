package com.example.officialsapplication.services;

import com.example.officialsapplication.dao.DataAccessLayer;
import com.example.officialsapplication.exceptions.EntityNotFoundException;
import com.example.officialsapplication.exceptions.RequestAlreadyAnsweredException;
import com.example.officialsapplication.extractor.MetadataExtractor;
import com.example.officialsapplication.mappers.MultiwayMapper;
import com.example.officialsapplication.model.potvrda.Potvrda;
import com.example.officialsapplication.model.users.korisnik.Korisnik;
import com.example.officialsapplication.model.zahtev_zeleni_sertifikat.ListaZahtevaZelenogSertifikata;
import com.example.officialsapplication.model.zahtev_zeleni_sertifikat.Zahtev;
import com.example.officialsapplication.model.zeleni_sertifikat.TBrojSertifikata;
import com.example.officialsapplication.model.zeleni_sertifikat.TImeIPrezime;
import com.example.officialsapplication.model.zeleni_sertifikat.TJmbg;
import com.example.officialsapplication.model.zeleni_sertifikat.TPacijent;
import com.example.officialsapplication.model.zeleni_sertifikat.TVakcinacija;
import com.example.officialsapplication.model.zeleni_sertifikat.ZeleniSertifikat;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import org.apache.commons.io.IOUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;

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
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Calendar;

import java.util.GregorianCalendar;


@Service
public class ZeleniSertifikatService {

    private final DataAccessLayer dataAccessLayer;
    private final MultiwayMapper mapper;
    private final MetadataExtractor metadataExtractor;
    private PdfGeneratorService pdfGeneratorService;
    private HtmlGeneratorService htmlGeneratorService;

    private RestTemplate restTemplate = new RestTemplate();
    private final MailSenderService mailSenderService;
    private static DocumentBuilderFactory documentFactory;
	
	private static TransformerFactory transformerFactory;
	
	public static final String INPUT_FILE = "data/xslt/zelenisertifikat.xml";
	
	public static final String XSL_FILE = "data/xslt/zelenisertifikat.xsl";
	
	public static final String HTML_FILE = "gen/itext/zelenisertifikat.html";
	
	public static final String OUTPUT_FILE = "gen/itext/zelenisertifikat.pdf";
	
	static {

		/* Inicijalizacija DOM fabrike */
		documentFactory = DocumentBuilderFactory.newInstance();
		documentFactory.setNamespaceAware(true);
		documentFactory.setIgnoringComments(true);
		documentFactory.setIgnoringElementContentWhitespace(false);
		
		/* Inicijalizacija Transformer fabrike */
		transformerFactory = TransformerFactory.newInstance();
		
	}

    public ZeleniSertifikatService(DataAccessLayer dataAccessLayer, MultiwayMapper mapper,
                                       MetadataExtractor metadataExtractor, MailSenderService mailSenderService, PdfGeneratorService pdfGeneratorService, HtmlGeneratorService htmlGeneratorService) {
        this.dataAccessLayer = dataAccessLayer;
        this.mapper = mapper;
        this.metadataExtractor = metadataExtractor;
        this.mailSenderService = mailSenderService;
        this.pdfGeneratorService = pdfGeneratorService;
        this.htmlGeneratorService = htmlGeneratorService;
    }

    
    
   

    

    

    
    
	public void generatePDF(String filePath) throws IOException, DocumentException {
	        
	    	// Step 1
	    	//Document document = new Document();
	        
	    	// Step 2
	        //PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
	        
	       
	        // Step 3
	        //document.open();
	        
	       
	        
	        // Step 4
	        
	        //XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(HTML_FILE));
	        
	        HtmlConverter.convertToPdf(new File(HTML_FILE), new File(OUTPUT_FILE));
	        
	        // Step 5
	       // document.close();
	        
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


	public ByteArrayInputStream getPdfRequest(String xmlName) throws Exception {
		ResponseEntity<String> res =
		restTemplate.getForEntity("http://localhost:8087/api/zahtevi/getXmlText/"+xmlName, String.class);
    	return pdfGeneratorService.generatePDF(res.getBody(), "data/xsl-fo/zahtev_fo.xsl");
    }
	
	public void odbijZeleni(String id, String razlog) throws Exception {
		ResponseEntity<Korisnik> pacijent;
		try {
			pacijent
		  	  = restTemplate.getForEntity("http://localhost:8087/api/korisnici/getUser/"+id.split("-")[0], Korisnik.class);
			

		} catch (Exception e) {
			throw new EntityNotFoundException("Korisnik sa JMBG " + id.split("-")[0] + " Nije pronadjen");
		}
		ResponseEntity<Zahtev> zahtev;
	  	try {
	  		zahtev
	  		= restTemplate.getForEntity("http://localhost:8087/api/zahtevi/"+id, Zahtev.class);
	  	} catch (Exception e) {
			throw new EntityNotFoundException("Zahtev sa sifrom " + id + " ne postoji");
		}
	  		
	  		if(!zahtev.getBody().getAccepted().equals("waiting")) {
	  			throw new RequestAlreadyAnsweredException("Zahtev sa sifrom " + id + " je vec dobio odgovor");
	  		}
	  	mailSenderService.odbijenZeleni(pacijent.getBody(), razlog);
		ResponseEntity<String> res = restTemplate.exchange("http://localhost:8087/api/zahtevi/requestDenied/"+id, HttpMethod.PUT, null, String.class);
	}
	
	public String getZahtevi() {
		ResponseEntity<String> zahtevi 
	  		= restTemplate.getForEntity("http://localhost:8087/api/zahtevi/getAllWaiting", String.class);
		return zahtevi.getBody();
	}
	
	public String prihvatiZeleni(String id) throws Exception {
		GregorianCalendar dn = new GregorianCalendar();
		ResponseEntity<Korisnik> pacijent;
		try {
			pacijent
		  	  = restTemplate.getForEntity("http://localhost:8087/api/korisnici/getUser/"+id.split("-")[0], Korisnik.class);
		} catch (Exception e) {
			throw new EntityNotFoundException("Korisnik sa JMBG " + id.split("-")[0] + " Nije pronadjen");
		}
		
  	
  	ResponseEntity<Potvrda> potvrda;
  	try {
  		potvrda
  		= restTemplate.getForEntity("http://localhost:8087/api/potvrde/"+id.split("-")[0], Potvrda.class);	
  		} catch (Exception e) {
		throw new EntityNotFoundException("Potvrda za korisnika sa JMBG " + id.split("-")[0] + " Nije pronadjena, samim tim sertifikat ne moze da se generise");
	}
  	
  	ResponseEntity<Zahtev> zahtev;
  	try {
  		zahtev
  		= restTemplate.getForEntity("http://localhost:8087/api/zahtevi/"+id, Zahtev.class);
  	} catch (Exception e) {
		throw new EntityNotFoundException("Zahtev sa sifrom " + id + " ne postoji");
	}
  		
  		if(!zahtev.getBody().getAccepted().equals("waiting")) {
  			throw new RequestAlreadyAnsweredException("Zahtev sa sifrom " + id + " je vec dobio odgovor");
  		}
  		
  	
  		Korisnik pacijentData = pacijent.getBody();
  		Potvrda potvrdaData = potvrda.getBody();
  	
  		ZeleniSertifikat zs = new ZeleniSertifikat();
  		zs.setBrojSertifikata(new TBrojSertifikata());
  		zs.getBrojSertifikata().setValue(java.util.UUID.randomUUID().toString());
  		zs.getBrojSertifikata().setProperty("pred:broj_sertifikata");
  		zs.getBrojSertifikata().setDatatype("xs:string");
  		zs.setDatumIzdavanja(new com.example.officialsapplication.model.zeleni_sertifikat.TDatumIzdavanja());
  		zs.getDatumIzdavanja().setValue(DatatypeFactory.newInstance().newXMLGregorianCalendar(dn.get(Calendar.YEAR), dn.get(Calendar.MONTH)+1, dn.get(Calendar.DAY_OF_MONTH), dn.get(Calendar.HOUR_OF_DAY), dn.get(Calendar.MINUTE), dn.get(Calendar.SECOND), DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED));
  		zs.getDatumIzdavanja().setDatatype("xs:dateTime");
  		zs.getDatumIzdavanja().setProperty("pred:datum");
  		zs.setPodaciOPacijentu(new TPacijent());
  		zs.getPodaciOPacijentu().setBrojPasosa(pacijentData.getBrojPasosa());
  		zs.getPodaciOPacijentu().setDatumRodjenja(pacijentData.getDatumRodjenja());
  		zs.getPodaciOPacijentu().setImePrezime(new TImeIPrezime());
  		zs.getPodaciOPacijentu().getImePrezime().setValue(pacijentData.getIme() + " " + pacijentData.getPrezime());
  		zs.getPodaciOPacijentu().getImePrezime().setProperty("pred:ime_i_prezime");
  		zs.getPodaciOPacijentu().getImePrezime().setDatatype("xs:string");
  		zs.getPodaciOPacijentu().setJmbg(new TJmbg());
  		zs.getPodaciOPacijentu().getJmbg().setValue(pacijentData.getJmbg());
  		zs.getPodaciOPacijentu().getJmbg().setProperty("pred:jmbg");
  		zs.getPodaciOPacijentu().getJmbg().setDatatype("xs:string");
  		zs.getPodaciOPacijentu().setPol("Musko"); ///CEEKKKKKKKKKKK
  		zs.setAbout("http://www.ftn.uns.ac.rs/zelenisertifikat/"+zs.getBrojSertifikata().getValue());
  		zs.setHref("http://www.ftn.uns.ac.rs/zahtev_zelenog_sertifikata/"+id);
  		//List<TVakcinacija> vakcinaInfo = new ArrayList<TVakcinacija>();
  		TVakcinacija prvaDoza = new TVakcinacija();
  		TVakcinacija drugaDoza = new TVakcinacija();
  		if(potvrdaData.getVakcinacijaInfo().getPrvaDoza() != null) {
  			prvaDoza.setDoza(BigInteger.valueOf(1));
  			prvaDoza.setDatum(potvrdaData.getVakcinacijaInfo().getPrvaDoza().getDatumVakcine());
  			prvaDoza.setProizvodjacSerija(potvrdaData.getVakcinacijaInfo().getPrvaDoza().getSerijaVakcine());
  			prvaDoza.setZdravstvenaUstanova(potvrdaData.getVakcinacijaInfo().getZdravstvenaUstanova().getValue());
  			prvaDoza.setTip(potvrdaData.getVakcinacijaInfo().getNazivVakcine().getValue());
  		}
  		if(potvrdaData.getVakcinacijaInfo().getDrugaDoza() != null) {
  			drugaDoza.setDoza(BigInteger.valueOf(2));
  			drugaDoza.setDatum(potvrdaData.getVakcinacijaInfo().getDrugaDoza().getDatumVakcine());
  			drugaDoza.setProizvodjacSerija(potvrdaData.getVakcinacijaInfo().getDrugaDoza().getSerijaVakcine());
  			drugaDoza.setZdravstvenaUstanova(potvrdaData.getVakcinacijaInfo().getZdravstvenaUstanova().getValue());
  			drugaDoza.setTip(potvrdaData.getVakcinacijaInfo().getNazivVakcine().getValue());
  		}

  		zs.getPodaciOVakcinaciji().add(prvaDoza);
  		zs.getPodaciOVakcinaciji().add(drugaDoza);

  		
  		QRCodeWriter qrCodeWriter = new QRCodeWriter();
  		BitMatrix bitMatrix = qrCodeWriter.encode("http://www.ftn.uns.ac.rs/zelenisertifikat/"+zs.getBrojSertifikata().getValue(), BarcodeFormat.QR_CODE, 100, 100);    
  		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  		MatrixToImageWriter.writeToStream(bitMatrix,"png", outputStream);

  		String base64 = new String(Base64.getEncoder().encode(outputStream.toByteArray()), "UTF-8");
  		zs.setQrKod("data:image/png;base64, "+base64);
  		zs.setRel("pred:answerTo");

  		String res = convertToXml(zs);
  		ByteArrayInputStream is = pdfGeneratorService.generatePDF(convertToXml(zs), "data/xsl-fo/zeleni_fo.xsl");
  		ByteArrayInputStream is1 =  htmlGeneratorService.generateHTML(convertToXml(zs), "data/xslt/zelenisertifikat.xsl");
		mailSenderService.odobrenZeleni2(pacijentData, IOUtils.toByteArray(is), IOUtils.toByteArray(is1));

		ResponseEntity<ZeleniSertifikat> response = restTemplate.postForEntity("http://localhost:8087/api/zelenisertifikati/saveXmlText", convertToXml(zs), ZeleniSertifikat.class);
		return convertToXml(response.getBody());
		
  		
	}

    public ByteArrayInputStream getPdf(String id) throws Exception {
		ResponseEntity<String> res =
				restTemplate.getForEntity("http://localhost:8087/api/zelenisertifikati/getXmlText/" + id, String.class);
		return pdfGeneratorService.generatePDF(res.getBody(), "OfficialsApplication/data/xsl-fo/zeleni_fo.xsl");
	}

	public ByteArrayInputStream getHtml(String id) throws IOException {
		ResponseEntity<String> res = restTemplate
				.getForEntity("http://localhost:8087/api/zelenisertifikati/getXmlText/" + id, String.class);
		return htmlGeneratorService.generateHTML(res.getBody(), "OfficialsApplication/data/xslt/zelenisertifikat.xsl");
	}
}
