package com.example.officialsapplication.services;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import net.sf.saxon.TransformerFactoryImpl;

/**
 * 
 * Primer demonstrira koriscenje Apache FOP programskog API-a za 
 * renderovanje PDF-a primenom XSL-FO transformacije na XML dokumentu.
 *
 */

@Service
public class PdfGeneratorService {
	
	private FopFactory fopFactory;
	
	private TransformerFactory transformerFactory;

	public PdfGeneratorService() throws SAXException, IOException {
		
		// Initialize FOP factory object
		fopFactory = FopFactory.newInstance(new File("OfficialsApplication/src/fop.xconf"));
		
		// Setup the XSLT transformer factory
		transformerFactory = new TransformerFactoryImpl();
	}

	public ByteArrayInputStream  generatePDF(String xmlFile, String xslFilepath) throws Exception {

		
		// Point to the XSL-FO file
		File xslFile = new File(xslFilepath);

		// Create transformation source
		StreamSource transformSource = new StreamSource(xslFile);
		
		// Initialize the transformation subject
		StreamSource source = new StreamSource(new ByteArrayInputStream(xmlFile.getBytes()));

		// Initialize user agent needed for the transformation
		FOUserAgent userAgent = fopFactory.newFOUserAgent();
		
		// Create the output stream to store the results
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		// Initialize the XSL-FO transformer object
		Transformer xslFoTransformer = transformerFactory.newTransformer(transformSource);
		
		// Construct FOP instance with desired output format
		Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, outStream);

		// Resulting SAX events 
		Result res = new SAXResult(fop.getDefaultHandler());

		// Start XSLT transformation and FOP processing
		xslFoTransformer.transform(source, res);
		
		return new ByteArrayInputStream(outStream.toByteArray());

		
	}


}
