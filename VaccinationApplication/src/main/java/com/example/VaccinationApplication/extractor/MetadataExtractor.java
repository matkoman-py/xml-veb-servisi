package com.example.VaccinationApplication.extractor;

import java.io.*;
import java.util.*;

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
	
	private static final String XSLT_FILE = "data/xsl/grddl.xsl";

	private static final String RDF_FILE_PATH = "gen/grddl_metadata.rdf";

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

	public HashSet<String> filterFromRdf(String path, String condition) {
		HashSet<String> retval = new HashSet<>();

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

	public HashMap<String, String> getMetadata(String path, String namespace, String id) {
		HashMap<String, String> retval = new HashMap<>();

		String queryEndpoint = String.join("/", rdfConfig.getEndpoint().trim(), rdfConfig.getDataset().trim(), rdfConfig.getQuery().trim());
		String sparqlQuery = SparqlUtil.selectData(rdfConfig.getEndpoint().trim() + path, "<http://www.ftn.uns.ac.rs" + namespace + "/" + id + "> ?p ?o");
		QueryExecution query = QueryExecutionFactory.sparqlService(queryEndpoint, sparqlQuery);
		ResultSet results = query.execSelect();
		String p;
		String o;
		RDFNode predicate;
		RDFNode object;
		while (results.hasNext()) {
			QuerySolution querySolution = results.next();
			Iterator<String> variableBindings = querySolution.varNames();

			p = variableBindings.next();
			predicate = querySolution.get(p);

			o = variableBindings.next();
			object = querySolution.get(o);

			int indexOfEnd = object.toString().indexOf("^");
			if(indexOfEnd != -1) {
				retval.put(predicate.toString(), object.toString().substring(0, indexOfEnd));
			} else {
				retval.put(predicate.toString(), object.toString());
			}
		}
		query.close();
		return retval;
	}

	public String getRdfMetadata(String path, String namespace, String id) {
		HashMap<String, String> map = getMetadata(path, namespace, id);
		StringBuilder builder =
				new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
						"<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n" +
						"         xmlns:pred=\"http://www.ftn.uns.ac.rs" + path + "/predicate/\">\n" +
						"\n" +
						"  <rdf:Description rdf:about=\"http://www.ftn.uns.ac.rs.org" + namespace + "/" + id + "\">\n");

		for (Map.Entry<String, String> entry : map.entrySet()) {
			String predicate = entry.getKey().split("http://www.ftn.uns.ac.rs/predicate/")[1];
			builder.append("\t\t<pred:").append(predicate).append(">").append(entry.getValue()).append("</pred:").append(predicate).append(">\n");
		}
		builder.append("  </rdf:Description>\n\n</rdf:RDF>");
		return builder.toString();
	}
}
