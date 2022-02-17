package com.example.VaccinationApplication.extractor;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.example.VaccinationApplication.config.RdfDatabaseConfig;
import com.example.VaccinationApplication.util.SparqlUtil;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.update.UpdateExecutionFactory;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateProcessor;
import org.apache.jena.update.UpdateRequest;
import org.springframework.stereotype.Component;


@Component
public class MetadataExtractor {

	private final TransformerFactory transformerFactory = TransformerFactory.newInstance();

	//private static final String XSLT_FILE = "OfficialsApplication/data/xsl/grddl.xsl";
	
	//private static final String RDF_FILE_PATH = "OfficialsApplication/gen/grddl_metadata.rdf";
	
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
		System.out.println(String.join("/", rdfConfig.getEndpoint(), rdfConfig.getDataset(), rdfConfig.getUpdate()) + " DSADSADDSAD");
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

	public List<String> filterFromRdf(String path, String condition) {
		List<String> retval = new ArrayList<>();

		String queryEndpoint = String.join("/", rdfConfig.getEndpoint().trim(), rdfConfig.getDataset().trim(), rdfConfig.getQuery().trim());
		String sparqlQuery = SparqlUtil.selectData(rdfConfig.getEndpoint().trim() + path, condition);
		QueryExecution query = QueryExecutionFactory.sparqlService(queryEndpoint, sparqlQuery);
		ResultSet results = query.execSelect();
		String varName;
		RDFNode varValue;
		while (results.hasNext()) {
			int index = 0;
			QuerySolution querySolution = results.next();
			Iterator<String> variableBindings = querySolution.varNames();
			while (variableBindings.hasNext()) {
				varName = variableBindings.next();
				varValue = querySolution.get(varName);
				if(index == 0)
					retval.add(varValue.toString());
				index += 1;
			}
		}
		query.close();

		return retval;
	}
}
