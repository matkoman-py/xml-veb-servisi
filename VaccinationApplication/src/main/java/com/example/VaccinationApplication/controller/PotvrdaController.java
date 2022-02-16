package com.example.VaccinationApplication.controller;

import com.example.VaccinationApplication.model.potvrda.Potvrda;
import com.example.VaccinationApplication.model.zeleni_sertifikat.ZeleniSertifikat;
import com.example.VaccinationApplication.services.PotvrdaService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.util.List;

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
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> sve() throws Exception {
    	String retval = potvrdaService.getAll();
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/getForDate/{dateFrom}/{dateTo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> sveZaDatum(@PathVariable String dateFrom, @PathVariable String dateTo) throws Exception {
    	String retval = potvrdaService.getAllForDate(dateFrom,dateTo);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/getForReportDate/{dateFrom}/{dateTo}", method = RequestMethod.GET)
    public ResponseEntity<List<Integer>> sveZaIzvDatum(@PathVariable String dateFrom, @PathVariable String dateTo) throws Exception {
    	List<Integer> retval = potvrdaService.getReportDataForDate(dateFrom,dateTo);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/getForUser/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> sveZaUsera(@PathVariable String id) throws Exception {
    	String retval = potvrdaService.getAllForUser(id);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Potvrda> getPotvrda(@PathVariable String id) throws Exception {
    	Potvrda retval = potvrdaService.getPotvrda(id);
        return ResponseEntity.ok(retval);
    }
    
    

    @GetMapping("getXmlObject/{id}")
    public ResponseEntity<Potvrda> getXmlObject(@PathVariable String id) {
        Potvrda retval = potvrdaService.getXmlAsObject(id);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("saveXmlText")
    public ResponseEntity<Potvrda> saveXml(@RequestBody String potvrdaXml) throws Exception {
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
