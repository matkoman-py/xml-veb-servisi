package com.example.officialsapplication.controller;

import com.example.officialsapplication.model.potvrda.Potvrda;
import com.example.officialsapplication.model.users.izvestaj.IzvestajOImunizaciji;
import com.example.officialsapplication.model.users.korisnik.Korisnik;
import com.example.officialsapplication.services.IzvestajOImunizacijiService;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    
    @RequestMapping(value = "test/{dateFrom}/{dateTo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> test(@PathVariable String dateFrom,@PathVariable String dateTo) throws DatatypeConfigurationException, IOException, DocumentException {
    	String retval = izvestajService.test(dateFrom,dateTo);
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
    
    @GetMapping("test/{id}")
    public Korisnik test(@PathVariable String id) throws DatatypeConfigurationException, IOException, DocumentException, MessagingException {
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<Korisnik> interesovanja
    	  = restTemplate.getForEntity("http://localhost:8087/api/korisnici/getUser/"+id, Korisnik.class);
    	
    	ResponseEntity<Potvrda> pot
  	  = restTemplate.getForEntity("http://localhost:8087/api/potvrde/"+id, Potvrda.class);
      	System.out.println("DASDASDAS " + pot.getBody().getVakcinacijaInfo().getNazivVakcine().getValue());
      	izvestajService.zeleni(id);
    	return interesovanja.getBody();
    }
    
}
