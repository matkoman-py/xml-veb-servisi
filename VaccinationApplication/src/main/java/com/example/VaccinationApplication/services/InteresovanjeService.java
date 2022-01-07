package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.InteresovanjeDAO;
import com.example.VaccinationApplication.mappers.InteresovanjeMapper;
import com.example.VaccinationApplication.model.documents.Interesovanje;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InteresovanjeService {

    private final InteresovanjeDAO interesovanjeDAO;
    private final InteresovanjeMapper mapper;

    public String get(String id){
        return interesovanjeDAO.get(id).get();
    }

    public String save(String interesovanjeXmlString){
        Interesovanje interesovanje = mapper.convertToObject(interesovanjeXmlString);
        return interesovanjeDAO.save(interesovanje);
    }
}
