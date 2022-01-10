package com.example.VaccinationApplication.extractor;

import java.io.*;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.example.VaccinationApplication.config.RdfDatabaseConfig;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.stereotype.Component;


@Component
public class MetadataExtractor {

	private final TransformerFactory transformerFactory = TransformerFactory.newInstance();

	private static final String XSLT_FILE = "VaccinationApplication/data/xsl/grddl.xsl";

	private static final String RDF_FILE_PATH = "VaccinationApplication/gen/grddl_metadata.rdf";

	private final RdfDatabaseConfig rdfConfig;

	public MetadataExtractor(RdfDatabaseConfig rdfConfig) {
		this.rdfConfig = rdfConfig;
	}

	public void extractAndSave(String xmlFile, String path) throws FileNotFoundException, TransformerException{
		this.extractMetadata(new ByteArrayInputStream(xmlFile.getBytes()), new FileOutputStream(RDF_FILE_PATH));
		this.saveRdf(path);
	}

	private void saveRdf(String path){
		Model model = ModelFactory.createDefaultModel();
		model.read(RDF_FILE_PATH);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		model.write(out, SparqlUtils.NTRIPLES);

		String sparqlUpdate = SparqlUtils.insertData(rdfConfig.getEndpoint() + path, out.toString());

		UpdateRequest update = UpdateFactory.create(sparqlUpdate);

		UpdateProcessor processor = UpdateExecutionFactory.createRemote(update,
				String.join("/", rdfConfig.getEndpoint(), rdfConfig.getDataset(), rdfConfig.getUpdate()));
		processor.execute();
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
