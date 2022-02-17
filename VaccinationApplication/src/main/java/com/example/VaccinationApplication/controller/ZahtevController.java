package com.example.VaccinationApplication.controller;

import com.example.VaccinationApplication.model.potvrda.Potvrda;
import com.example.VaccinationApplication.model.zahtev_zeleni_sertifikat.Zahtev;
import com.example.VaccinationApplication.model.zeleni_sertifikat.ZeleniSertifikat;

import java.io.FileNotFoundException;

import javax.xml.transform.TransformerException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.VaccinationApplication.services.ZahtevService;

@RestController
@RequestMapping("/api/zahtevi")
public class ZahtevController {
	
	private final ZahtevService zahtevService;

    public ZahtevController(ZahtevService zahtevService) {
        this.zahtevService = zahtevService;
    }

    @GetMapping("getXmlText/{id}")
    public ResponseEntity<String> getXmlText(@PathVariable String id) throws FileNotFoundException, TransformerException {
        String retval = zahtevService.getXmlAsText(id);
        return ResponseEntity.ok(retval);
    }
    
    @PutMapping("requestDenied/{id}")
    public ResponseEntity<String> denyRequest(@PathVariable String id) throws FileNotFoundException, TransformerException {
        zahtevService.link(id, "no");
        return ResponseEntity.ok("Zahtev sa sifrom " + id + " uspesno odbijen");
    }

    @GetMapping("getXmlObject/{id}")
    public ResponseEntity<Zahtev> getXmlObject(@PathVariable String id) throws FileNotFoundException, TransformerException {
    	Zahtev retval = zahtevService.getXmlAsObject(id);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> sve() throws Exception {
    	String retval = zahtevService.getAll();
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/getAllWaiting", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> sveCekanje() throws Exception {
    	String retval = zahtevService.getAllWaiting();
        return ResponseEntity.ok(retval);
    }
    
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Zahtev> getZahtev(@PathVariable String id) throws Exception {
    	Zahtev retval = zahtevService.getZahtev(id);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/getForDate/{dateFrom}/{dateTo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> sveZaDatum(@PathVariable String dateFrom, @PathVariable String dateTo) throws Exception {
    	String retval = zahtevService.getAllForDate(dateFrom,dateTo);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/getNumberForDate/{dateFrom}/{dateTo}", method = RequestMethod.GET)
    public ResponseEntity<Integer> sveZaDatumBroj(@PathVariable String dateFrom, @PathVariable String dateTo) throws Exception {
    	int retval = zahtevService.getNumberOfRequests(dateFrom,dateTo);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/getForUser/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> sveZaUsera(@PathVariable String id) throws Exception {
    	String retval = zahtevService.getAllForUser(id);
        return ResponseEntity.ok(retval);
    }
    
    @PostMapping(value = "saveXmlText")
    public ResponseEntity<Zahtev> saveXmlText(@RequestBody String zahtevXml) throws FileNotFoundException, TransformerException {
    	System.out.println(zahtevXml);
    	Zahtev retval = zahtevService.saveXmlFromText(zahtevXml);
        return ResponseEntity.ok(retval);
    }
    
    @PostMapping("saveXmlObject")
    public ResponseEntity<Zahtev> saveXmlObject(@RequestBody Zahtev zahtev) throws FileNotFoundException, TransformerException {
    	Zahtev retval = zahtevService.saveXmlFromObject(zahtev);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("convertToXml")
    public ResponseEntity<String> saveObject(@RequestBody Zahtev zahtev) throws FileNotFoundException, TransformerException {
        String retval = zahtevService.convertToXml(zahtev);
        return ResponseEntity.ok(retval);
    }
    
    @PostMapping("convertToObject")
    public ResponseEntity<Zahtev> xmlToObject(@RequestBody String xmlString) throws FileNotFoundException, TransformerException {
        Zahtev retval = zahtevService.convertToObject(xmlString);
        return ResponseEntity.ok(retval);
    }
}
