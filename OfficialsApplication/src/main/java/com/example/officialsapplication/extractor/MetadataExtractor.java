package com.example.officialsapplication.extractor;

import com.example.officialsapplication.config.RdfDatabaseConfig;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.stereotype.Component;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;


@Component
public class MetadataExtractor {

	private final TransformerFactory transformerFactory = TransformerFactory.newInstance();

//	private static final String XSLT_FILE = "OfficialsApplication/data/xsl/grddl.xsl";
	
	//private static final String RDF_FILE_PATH = "OfficialsApplication/gen/grddl_metadata.rdf";
	
	private static final String XSLT_FILE = "data/xsl/grddl.xsl";
//
	private static final String RDF_FILE_PATH = "gen/grddl_metadata.rdf";

	private final RdfDatabaseConfig rdfConfig;

	public MetadataExtractor(RdfDatabaseConfig rdfConfig) {
		this.rdfConfig = rdfConfig;
	}

	public void extractAndSave(String xmlFile, String path) throws FileNotFoundException, TransformerException{
		System.out.println("USAOOOOOO1");
		this.extractMetadata(new ByteArrayInputStream(xmlFile.getBytes()), new FileOutputStream(RDF_FILE_PATH));
		this.saveRdf(path);
	}

	private void saveRdf(String path){
		System.out.println("USAOOOOO2");
		Model model = ModelFactory.createDefaultModel();
		model.read(RDF_FILE_PATH);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		model.write(out, SparqlUtils.NTRIPLES);

		String sparqlUpdate = SparqlUtils.insertData(rdfConfig.getEndpoint() + path, out.toString());

		UpdateRequest update = UpdateFactory.create(sparqlUpdate);

		UpdateProcessor processor = UpdateExecutionFactory.createRemote(update,
				String.join("/", rdfConfig.getEndpoint(), rdfConfig.getDataset(), rdfConfig.getUpdate()));
		System.out.println(String.join("/", rdfConfig.getEndpoint(), rdfConfig.getDataset(), rdfConfig.getUpdate()));
		processor.execute();
		System.out.println("USAOOO3");
	}

	private void extractMetadata(InputStream in, OutputStream out) throws FileNotFoundException, TransformerException {
			
			
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
