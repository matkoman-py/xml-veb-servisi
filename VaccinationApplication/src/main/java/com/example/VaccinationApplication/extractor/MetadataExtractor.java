package com.example.VaccinationApplication.extractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;

@Component
public class MetadataExtractor {

	private final TransformerFactory transformerFactory = TransformerFactory.newInstance();

	private static final String XSLT_FILE = "data/xsl/grddl.xsl";
	
	
	public void extractMetadata(InputStream in, OutputStream out) throws FileNotFoundException, TransformerException {
			
			// Create transformation source
			StreamSource transformSource = new StreamSource(new File(XSLT_FILE));
			
			// Initialize GRDDL transformer object
			Transformer grddlTransformer = transformerFactory.newTransformer(transformSource);
			
			// Set the indentation properties
			grddlTransformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2");
			grddlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			// Initialize transformation subject
			StreamSource source = new StreamSource(in);
	
			// Initialize result stream
			StreamResult result = new StreamResult(out);
			
			// Trigger the transformation
			grddlTransformer.transform(source, result);
			
		}
}
