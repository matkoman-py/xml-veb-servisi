package com.example.VaccinationApplication.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.stereotype.Service;


@Service
public class PdfTransformerService {
	
	String fopConfPath = "data/xsl-fo/fop.xconf";
	
	public ByteArrayInputStream transformToPDF(String xml, String docType) throws Exception {
		String xslPath = "data/xsl-fo/" + docType + "_fo.xsl";

		FopFactory fopFactory = FopFactory.newInstance(new File(fopConfPath));
	
	     //Setup a buffer to obtain the content length
	     ByteArrayOutputStream out = new ByteArrayOutputStream();
	
	     Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);	
	     TransformerFactory factory = TransformerFactory.newInstance();
	     Transformer transformer = factory.newTransformer(new StreamSource(xslPath));
	     //Make sure the XSL transformation's result is piped through to FOP
	     Result res = new SAXResult(fop.getDefaultHandler());
	
	     //Setup input
	     Source src = new StreamSource(new ByteArrayInputStream(xml.getBytes()));
	     System.out.println(xml);
	     //Start the transformation and rendering process
	     transformer.transform(src, res);
	     return new ByteArrayInputStream(out.toByteArray());
		}
	}
