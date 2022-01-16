package com.example.VaccinationApplication.controller;

import com.example.VaccinationApplication.model.zeleni_sertifikat.ZeleniSertifikat;
import com.example.VaccinationApplication.services.ZeleniSertifikatService;

import java.io.FileNotFoundException;

import javax.xml.transform.TransformerException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/zelenisertifikati")
public class ZeleniSertifikatController {

    private final ZeleniSertifikatService zeleniSertifikatService;

    public ZeleniSertifikatController(ZeleniSertifikatService zeleniSertifikatService) {
        this.zeleniSertifikatService = zeleniSertifikatService;
    }
    

    @RequestMapping(value = "/getXmlText/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getXmlText(@PathVariable String id) {
        String retval = zeleniSertifikatService.getXmlAsText(id);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/getXmlObject/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZeleniSertifikat> getXmlObject(@PathVariable String id) {
        ZeleniSertifikat retval = zeleniSertifikatService.getXmlAsObject(id);
        return ResponseEntity.ok(retval);
    }

    @RequestMapping(value = "/saveXmlText", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZeleniSertifikat> saveXmlText(@RequestBody String zeleniSertifikatXml) throws FileNotFoundException, TransformerException {
        ZeleniSertifikat retval = zeleniSertifikatService.saveXmlFromText(zeleniSertifikatXml);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/convertToXml", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> objectToXml(@RequestBody ZeleniSertifikat zeleniSertifikat) {
        String retval = zeleniSertifikatService.convertToXml(zeleniSertifikat);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/convertToObject", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZeleniSertifikat> xmlToObject(@RequestBody String xmlString) throws FileNotFoundException, TransformerException {
        ZeleniSertifikat retval = zeleniSertifikatService.convertToObject(xmlString);
        return ResponseEntity.ok(retval);
    }
}
