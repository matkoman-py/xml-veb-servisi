package com.example.officialsapplication.controller;

import com.example.officialsapplication.model.documents.IzvestajOImunizaciji;
import com.example.officialsapplication.services.IzvestajOImunizacijiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/izvestaji")
public class IzvestajOImunizacijiController {

    private final IzvestajOImunizacijiService izvestajService;

    public IzvestajOImunizacijiController(IzvestajOImunizacijiService izvestajService) {
        this.izvestajService = izvestajService;
    }

    @GetMapping("getXmlText/{id}")
    public ResponseEntity<String> getXmlText(@PathVariable String id) {
        String retval = izvestajService.getXmlAsText(id);
        return ResponseEntity.ok(retval);
    }

    @GetMapping("getXmlObject/{id}")
    public ResponseEntity<IzvestajOImunizaciji> getXmlObject(@PathVariable String id) {
        IzvestajOImunizaciji retval = izvestajService.getXmlAsObject(id);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("saveXmlText")
    public ResponseEntity<IzvestajOImunizaciji> saveXmlText(@RequestBody String izvestajXml) {
        IzvestajOImunizaciji retval = izvestajService.saveXmlFromText(izvestajXml);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("saveXmlObject")
    public ResponseEntity<IzvestajOImunizaciji> saveXmlObject(@RequestBody IzvestajOImunizaciji izvestaj) {
        IzvestajOImunizaciji retval = izvestajService.saveXmlFromObject(izvestaj);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("convertToXml")
    public ResponseEntity<String> objectToXml(@RequestBody IzvestajOImunizaciji izvestaj) {
        String retval = izvestajService.convertToXml(izvestaj);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("convertToObject")
    public ResponseEntity<IzvestajOImunizaciji> xmlToObject(@RequestBody String xmlString) {
        IzvestajOImunizaciji retval = izvestajService.convertToObject(xmlString);
        return ResponseEntity.ok(retval);
    }
}
