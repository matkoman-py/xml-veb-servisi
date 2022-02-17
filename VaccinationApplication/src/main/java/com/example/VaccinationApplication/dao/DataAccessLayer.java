package com.example.VaccinationApplication.dao;

import org.springframework.stereotype.Component;
import org.xmldb.api.base.ResourceSet;

import java.util.List;
import java.util.Optional;

@Component
public class DataAccessLayer {
	
    private final DatabaseConnection dbConnection;

    public DataAccessLayer(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public String saveDocument(Object object, String folderId, String documentId, Class<?> classOfObject) {
        dbConnection.createOne(folderId, object, documentId, classOfObject);
        return documentId;
    }

    public String deleteDocument(Object object, String folderId, String documentId, Class<?> classOfObject) {
        dbConnection.deleteOne(folderId, object, documentId, classOfObject);
        return documentId;
    }

    public Optional<String> getDocument(String folderId, String documentId) {
        String resourceContent = dbConnection.getOne(folderId, documentId);
        if (resourceContent.equals(""))
            return Optional.empty();
        return Optional.of(resourceContent);
    }
    
    public List<String> izvrsiXPathIzraz(String folderId, String xpathExp, String namespace) throws Exception {
    	return dbConnection.izvrsiXPathIzraz(folderId, xpathExp, namespace);
    }

//    public Optional<String> getSearchQuery(String folderId, String documentId) {
//        String resourceContent = dbConnection.getOneSearchQuery(folderId, documentId);
//        if (resourceContent.equals(""))
//            return Optional.empty();
//        return Optional.of(resourceContent);
//    }
}

