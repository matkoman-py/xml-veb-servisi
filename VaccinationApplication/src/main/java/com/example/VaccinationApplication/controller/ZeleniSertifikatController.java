package com.example.VaccinationApplication.controller;

import com.example.VaccinationApplication.model.interesovanje.ListaInteresovanja;
import com.example.VaccinationApplication.model.zeleni_sertifikat.ZeleniSertifikat;
import com.example.VaccinationApplication.services.ZeleniSertifikatService;

import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xmldb.api.base.ResourceSet;

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
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> sve() throws Exception {
    	String retval = zeleniSertifikatService.getAll();
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/getForUser/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> sveZaUsera(@PathVariable String id) throws Exception {
    	String retval = zeleniSertifikatService.getAllForUser(id);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/getNumberForDate/{dateFrom}/{dateTo}", method = RequestMethod.GET)
    public ResponseEntity<Integer> sveZaDatumBroj(@PathVariable String dateFrom, @PathVariable String dateTo) throws Exception {
    	int retval = zeleniSertifikatService.getNumberOfCertificates(dateFrom,dateTo);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/getForDate/{dateFrom}/{dateTo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> sveZaDatum(@PathVariable String dateFrom, @PathVariable String dateTo) throws Exception {
    	String retval = zeleniSertifikatService.getAllForDate(dateFrom,dateTo);
        return ResponseEntity.ok(retval);
    }

    //OVDEEEEEEEEEEEE
    @RequestMapping(value = "/saveXmlText", method = RequestMethod.POST)
    public ResponseEntity<ZeleniSertifikat> saveXmlText(@RequestBody String zeleniSertifikatXml) throws FileNotFoundException, TransformerException {
        ZeleniSertifikat retval = zeleniSertifikatService.saveXmlFromText(zeleniSertifikatXml);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/convertToXml", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> objectToXml(@RequestBody ZeleniSertifikat zeleniSertifikat) {
        String retval = zeleniSertifikatService.convertToXml(zeleniSertifikat);
        return ResponseEntity.ok(retval);
    }

    @RequestMapping(value = "/search/{search}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> searchSertifikatContaining(@PathVariable String search) throws Exception {
        return ResponseEntity.ok(zeleniSertifikatService.searchSertifikatContaining(search));
    }

    @RequestMapping(value = "/advanced-search", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getSErtifikatAdvanced(@RequestParam(required = false) String ime,
                                                        @RequestParam(required = false) String prezime,
                                                        @RequestParam(required = false) String ustanova,
                                                        @RequestParam(required = false) String datum) {
        return ResponseEntity.ok(zeleniSertifikatService.getSertifikatAdvanced(ime, prezime, ustanova, datum));

    }
    
//    @RequestMapping(value = "/convertToObject", method = RequestMethod.POST, consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ZeleniSertifikat> xmlToObject(@RequestBody String xmlString) throws FileNotFoundException, TransformerException {
//        ZeleniSertifikat retval = zeleniSertifikatService.convertToObject(xmlString);
//        return ResponseEntity.ok(retval);
//    }
}
