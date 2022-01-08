package com.example.officialsapplication.dao;

import com.example.officialsapplication.config.DatabaseConfig;
import org.springframework.stereotype.Component;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.OutputKeys;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@Component
public class DatabaseConnection {

    private final DatabaseConfig databaseConfig;

    public DatabaseConnection(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
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
}