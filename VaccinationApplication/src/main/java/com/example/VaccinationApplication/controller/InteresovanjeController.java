package com.example.VaccinationApplication.controller;

import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import com.example.VaccinationApplication.model.potvrda.Potvrda;
import com.example.VaccinationApplication.services.InteresovanjeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/interesovanja")
public class InteresovanjeController {

    private final InteresovanjeService interesovanjeService;

    public InteresovanjeController(InteresovanjeService interesovanjeService) {
        this.interesovanjeService = interesovanjeService;
    }

    @GetMapping("getXmlText/{id}")
    public ResponseEntity<String> getXml(@PathVariable String id) {
        String retval = interesovanjeService.getXmlText(id);
        return ResponseEntity.ok(retval);
    }

    @GetMapping("getXmlObject/{id}")
    public ResponseEntity<Interesovanje> getXmlObject(@PathVariable String id) {
        Interesovanje retval = interesovanjeService.getXmlAsObject(id);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("saveXmlText")
    public ResponseEntity<Interesovanje> saveXml(@RequestBody String interesovanjeXml) {
        Interesovanje retval = interesovanjeService.saveXmlFromText(interesovanjeXml);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("saveXmlObject")
    public ResponseEntity<Interesovanje> saveXmlObject(@RequestBody Interesovanje interesovanje) {
        Interesovanje retval = interesovanjeService.saveXmlFromObject(interesovanje);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("convertToXml")
    public ResponseEntity<String> saveObject(@RequestBody Interesovanje interesovanje) {
        String retval = interesovanjeService.convertToXml(interesovanje);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("convertToObject")
    public ResponseEntity<Interesovanje> xmlToObject(@RequestBody String xmlString) throws FileNotFoundException, TransformerException {
        Interesovanje retval = interesovanjeService.convertToObject(xmlString);
        return ResponseEntity.ok(retval);
    }
}
