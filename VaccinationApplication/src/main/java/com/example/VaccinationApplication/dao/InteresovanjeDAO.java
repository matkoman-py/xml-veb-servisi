package com.example.VaccinationApplication.dao;

import com.example.VaccinationApplication.model.documents.Interesovanje;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InteresovanjeDAO {
	
	private final String folderId = "/db/vaccination-system/interesovanja";
    private final DatabaseConnection dbConnection;

    public InteresovanjeDAO(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public String saveInteresovanje(Interesovanje interesovanje) {
        String documentId = interesovanje.getPodaciOPrimaocu().getJMBG()+ ".xml";
        dbConnection.createOne(folderId, interesovanje, documentId, Interesovanje.class);
        return interesovanje.getPodaciOPrimaocu().getJMBG();
    }

    public Optional<String> getInteresovanje(String id) {
        String resourceContent = dbConnection.getOne(folderId, id);
        if (resourceContent.equals(""))
            return Optional.empty();
        return Optional.of(resourceContent);
    }

}

