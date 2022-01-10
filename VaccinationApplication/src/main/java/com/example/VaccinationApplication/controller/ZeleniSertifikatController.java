package com.example.VaccinationApplication.controller;

import com.example.VaccinationApplication.model.zeleni_sertifikat.ZeleniSertifikat;
import com.example.VaccinationApplication.services.ZeleniSertifikatService;

import java.io.FileNotFoundException;

import javax.xml.transform.TransformerException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/zelenisertifikati")
public class ZeleniSertifikatController {

    private final ZeleniSertifikatService zeleniSertifikatService;

    public ZeleniSertifikatController(ZeleniSertifikatService zeleniSertifikatService) {
        this.zeleniSertifikatService = zeleniSertifikatService;
    }
    

    @GetMapping("getXmlText/{id}")
    public ResponseEntity<String> getXmlText(@PathVariable String id) {
        String retval = zeleniSertifikatService.getXmlAsText(id);
        return ResponseEntity.ok(retval);
    }
    
    @GetMapping("getXmlObject/{id}")
    public ResponseEntity<ZeleniSertifikat> getXmlObject(@PathVariable String id) {
        ZeleniSertifikat retval = zeleniSertifikatService.getXmlAsObject(id);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("saveXmlText")
    public ResponseEntity<ZeleniSertifikat> saveXmlText(@RequestBody String zeleniSertifikatXml) {
        ZeleniSertifikat retval = zeleniSertifikatService.saveXmlFromText(zeleniSertifikatXml);
        return ResponseEntity.ok(retval);
    }
    
    @PostMapping("saveXmlObject")
    public ResponseEntity<ZeleniSertifikat> saveXmlObject(@RequestBody ZeleniSertifikat zeleniSertifikat) {
        ZeleniSertifikat retval = zeleniSertifikatService.saveXmlFromObject(zeleniSertifikat);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("convertToXml")
    public ResponseEntity<String> objectToXml(@RequestBody ZeleniSertifikat zeleniSertifikat) {
        String retval = zeleniSertifikatService.convertToXml(zeleniSertifikat);
        return ResponseEntity.ok(retval);
    }
    
    @PostMapping("convertToObject")
    public ResponseEntity<ZeleniSertifikat> xmlToObject(@RequestBody String xmlString) throws FileNotFoundException, TransformerException {
        ZeleniSertifikat retval = zeleniSertifikatService.convertToObject(xmlString);
        return ResponseEntity.ok(retval);
    }
}
