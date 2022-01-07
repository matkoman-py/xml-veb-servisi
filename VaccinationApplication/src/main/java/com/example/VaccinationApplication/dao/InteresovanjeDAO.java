package com.example.VaccinationApplication.dao;

import com.example.VaccinationApplication.mappers.InteresovanjeMapper;
import com.example.VaccinationApplication.model.documents.Interesovanje;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InteresovanjeDAO {
	
	private final String collectionId = "/db/vaccination-system/interesovanja";
    private final DaoUtils daoUtils;
    private final InteresovanjeMapper mapper;
    
    public String save(Interesovanje interesovanje) {
        String documentId = interesovanje.getPodaciOPrimaocu().getJMBG()+ ".xml";
        daoUtils.createResource(collectionId, interesovanje, documentId, Interesovanje.class);
        return interesovanje.getPodaciOPrimaocu().getJMBG();
    }

    public Optional<String> get(String id) {
        String resourceContent = daoUtils.getResource(collectionId, id);
        if (resourceContent.equals(""))
            return Optional.empty();
        return Optional.of(resourceContent);
    }

}

