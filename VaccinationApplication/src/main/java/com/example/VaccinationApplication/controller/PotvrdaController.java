package com.example.VaccinationApplication.controller;

import com.example.VaccinationApplication.model.potvrda.Potvrda;
import com.example.VaccinationApplication.model.zeleni_sertifikat.ZeleniSertifikat;
import com.example.VaccinationApplication.services.PotvrdaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api/potvrde")
public class PotvrdaController {

    private final PotvrdaService potvrdaService;

    public PotvrdaController(PotvrdaService potvrdaService) {
        this.potvrdaService = potvrdaService;
    }

    @GetMapping("getXmlText/{id}")
    public ResponseEntity<String> getXml(@PathVariable String id) {
        String retval = potvrdaService.getXmlText(id);
        return ResponseEntity.ok(retval);
    }

    @GetMapping("getXmlObject/{id}")
    public ResponseEntity<Potvrda> getXmlObject(@PathVariable String id) {
        Potvrda retval = potvrdaService.getXmlAsObject(id);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("saveXmlText")
    public ResponseEntity<Potvrda> saveXml(@RequestBody String potvrdaXml) {
        Potvrda retval = potvrdaService.saveXmlFromText(potvrdaXml);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("saveXmlObject")
    public ResponseEntity<Potvrda> saveXmlObject(@RequestBody Potvrda potvrda) {
        Potvrda retval = potvrdaService.saveXmlFromObject(potvrda);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("convertToXml")
    public ResponseEntity<String> objectToXml(@RequestBody Potvrda potvrda) {
        String retval = potvrdaService.convertToXml(potvrda);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("convertToObject")
    public ResponseEntity<Potvrda> xmlToObject(@RequestBody String xmlString) throws FileNotFoundException, TransformerException {
        Potvrda retval = potvrdaService.convertToObject(xmlString);
        return ResponseEntity.ok(retval);
    }
}
