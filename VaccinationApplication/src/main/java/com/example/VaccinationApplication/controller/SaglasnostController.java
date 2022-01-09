package com.example.VaccinationApplication.controller;

import com.example.VaccinationApplication.model.saglasnost.Saglasnost;
import com.example.VaccinationApplication.services.SaglasnostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/saglasnost")
public class SaglasnostController {

    private final SaglasnostService saglasnostService;

    public SaglasnostController(SaglasnostService saglasnostService) {
        this.saglasnostService = saglasnostService;
    }

    @GetMapping("getXmlText/{id}")
    public ResponseEntity<String> getXmlText(@PathVariable String id) {
        String retval = saglasnostService.getXmlAsText(id);
        return ResponseEntity.ok(retval);
    }

    @GetMapping("getXmlObject/{id}")
    public ResponseEntity<Saglasnost> getXmlObject(@PathVariable String id) {
        Saglasnost retval = saglasnostService.getXmlAsObject(id);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("saveXmlText")
    public ResponseEntity<Saglasnost> saveXmlText(@RequestBody String saglasnostXml) {
        Saglasnost retval = saglasnostService.saveXmlFromText(saglasnostXml);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("saveXmlObject")
    public ResponseEntity<Saglasnost> saveXmlObject(@RequestBody Saglasnost saglasnost) {
        Saglasnost retval = saglasnostService.saveXmlFromObject(saglasnost);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("convertToXml")
    public ResponseEntity<String> saveObject(@RequestBody Saglasnost saglasnost) {
        String retval = saglasnostService.convertToXml(saglasnost);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("convertToObject")
    public ResponseEntity<Saglasnost> xmlToObject(@RequestBody String xmlString) {
        Saglasnost retval = saglasnostService.convertToObject(xmlString);
        return ResponseEntity.ok(retval);
    }
}
