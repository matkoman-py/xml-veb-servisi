package com.example.VaccinationApplication.services;

import com.example.VaccinationApplication.dao.InteresovanjeDAO;
import com.example.VaccinationApplication.mappers.MultiwayMapper;
import com.example.VaccinationApplication.model.documents.Interesovanje;
import org.springframework.stereotype.Service;

@Service
public class InteresovanjeService {

    private final InteresovanjeDAO interesovanjeDAO;
    private final MultiwayMapper mapper;

    public InteresovanjeService(InteresovanjeDAO interesovanjeDAO, MultiwayMapper mapper) {
        this.interesovanjeDAO = interesovanjeDAO;
        this.mapper = mapper;
    }

    public String getXml(String id){
        return interesovanjeDAO.getInteresovanje(id).get();
    }

    public Interesovanje saveXml(String interesovanjeXmlString){
        Interesovanje interesovanje = mapper.convertToObject(interesovanjeXmlString, "Interesovanje",
                Interesovanje.class);
        interesovanjeDAO.saveInteresovanje(interesovanje);
        return interesovanje;
    }

    public String convertToXml(Interesovanje interesovanje){
        return mapper.convertToXml(interesovanje,  Interesovanje.class);
    }
}
