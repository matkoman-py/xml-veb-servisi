package com.example.VaccinationApplication.dao;

import com.example.VaccinationApplication.config.DatabaseConfig;
import org.springframework.stereotype.Component;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.xquery.XQSequence;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseConnection {

    private final DatabaseConfig databaseConfig;

    public DatabaseConnection(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }
    
    public List<String> izvrsiXPathIzraz(String folderId, String xpathExp, String namespace) throws Exception {
		
    	ResourceSet res = null;
        Collection col = null;
        String responseContent = "";
        List<String> resources = new ArrayList<String>();

        try {
            Class<?> cl = Class.forName(databaseConfig.getDbDriver());
            Database database = (Database) cl.newInstance();
            database.setProperty("create-database", "true");
            DatabaseManager.registerDatabase(database);
            col = DatabaseManager.getCollection(databaseConfig.getDbUrl() + folderId, databaseConfig.getUsername(), databaseConfig.getPassword());
            col.setProperty(OutputKeys.INDENT, "yes");

            XPathQueryService xpathService = (XPathQueryService) col.getService("XPathQueryService", "2.0");
            xpathService.setProperty("indent", "yes");

            xpathService.setNamespace("", namespace);
            res = xpathService.query(xpathExp);
            ResourceIterator i = res.getIterator();
            XMLResource resource = null;
            while (i.hasMoreResources()) {
            	resource = (XMLResource) i.nextResource();
                resources.add((String) resource.getContent());
            }
        } catch (Exception ignored) {
        } finally {
            if (col != null) {
                try {
                    col.close();
                } catch (XMLDBException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
    	return resources;
    	
    }

    public String getOne(String folderId, String documentId) {
        XMLResource res;
        Collection col = null;
        String responseContent = "";

        try {
            Class<?> cl = Class.forName(databaseConfig.getDbDriver());
            Database database = (Database) cl.newInstance();
            database.setProperty("create-database", "true");
            DatabaseManager.registerDatabase(database);
            col = DatabaseManager.getCollection(databaseConfig.getDbUrl() + folderId, databaseConfig.getUsername(), databaseConfig.getPassword());
            col.setProperty(OutputKeys.INDENT, "yes");

            res = (XMLResource) col.getResource(documentId + ".xml");
            if (res != null)
                responseContent = (String) res.getContent();
        } catch (Exception ignored) {
        } finally {
            if (col != null) {
                try {
                    col.close();
                } catch (XMLDBException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return responseContent;
    }

    public void createOne(String folderId, Object object, String documentId, Class<?> classOfObject) {
        try {
            Class<?> cl = Class.forName(databaseConfig.getDbDriver());
            Database database = (Database) cl.newInstance();
            database.setProperty("create-database", "true");
            DatabaseManager.registerDatabase(database);
            Collection col = getFolder(folderId, 0);
            col.setProperty(OutputKeys.INDENT, "yes");
            XMLResource res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);
            OutputStream os = new ByteArrayOutputStream();
            JAXBContext context = JAXBContext.newInstance(classOfObject);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, os);
            res.setContent(os);
            col.storeResource(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteOne(String folderId, Object object, String documentId, Class<?> classOfObject) {
        try {
            Class<?> cl = Class.forName(databaseConfig.getDbDriver());
            Database database = (Database) cl.newInstance();
            database.setProperty("create-database", "true");
            DatabaseManager.registerDatabase(database);
            Collection col = getFolder(folderId, 0);
            col.setProperty(OutputKeys.INDENT, "yes");
            XMLResource res = (XMLResource) col.createResource(documentId, XMLResource.RESOURCE_TYPE);
            OutputStream os = new ByteArrayOutputStream();
            JAXBContext context = JAXBContext.newInstance(classOfObject);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, os);
            res.setContent(os);
            col.removeResource(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Collection getFolder(String folderId, int pathSegmentOffset) throws XMLDBException {
        try {
            Class<?> cl = Class.forName(databaseConfig.getDbDriver());
            Database database = (Database) cl.newInstance();
            database.setProperty("create-database", "true");
            DatabaseManager.registerDatabase(database);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Collection col = DatabaseManager.getCollection(databaseConfig.getDbUrl() + folderId, databaseConfig.getUsername(), databaseConfig.getPassword());

        if (col == null) {

            if (folderId.startsWith("/"))
                folderId = folderId.substring(1);

            String[] pathSegments = folderId.split("/");

            if (pathSegments.length > 0) {
                StringBuilder path = new StringBuilder();

                for (int i = 0; i <= pathSegmentOffset; i++)
                    path.append("/").append(pathSegments[i]);

                Collection startCol = DatabaseManager.getCollection(databaseConfig.getDbUrl() + path, databaseConfig.getUsername(), databaseConfig.getPassword());

                if (startCol == null) {
                    String parentPath = path.substring(0, path.lastIndexOf("/"));
                    Collection parentCol = DatabaseManager.getCollection(databaseConfig.getDbUrl() + parentPath, databaseConfig.getUsername(), databaseConfig.getPassword());
                    CollectionManagementService mgt = (CollectionManagementService) parentCol.getService("CollectionManagementService", "1.0");
                    col = mgt.createCollection(pathSegments[pathSegmentOffset]);
                    col.close();
                    parentCol.close();
                } else startCol.close();
            }
            return getFolder(folderId, ++pathSegmentOffset);
        } else
            return col;
    }

//    public String getOneSearchQuery(String folderId, String documentId) {
//
//        XQSequence res;
//        Collection col = null;
//        String responseContent = "";
//
//        try {
//            Class<?> cl = Class.forName(databaseConfig.getDbDriver());
//            Database database = (Database) cl.newInstance();
//            database.setProperty("create-database", "true");
//            DatabaseManager.registerDatabase(database);
//            col = DatabaseManager.getCollection(databaseConfig.getDbUrl() + folderId, databaseConfig.getUsername(), databaseConfig.getPassword());
//            col.setProperty(OutputKeys.INDENT, "yes");
//
//            res = col.getResource(documentId + ".xd");
//            if (res != null)
//                responseContent = (String) res.getContent();
//        } catch (Exception ignored) {
//        } finally {
//            if (col != null) {
//                try {
//                    col.close();
//                } catch (XMLDBException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
//        return responseContent;
//    }
}