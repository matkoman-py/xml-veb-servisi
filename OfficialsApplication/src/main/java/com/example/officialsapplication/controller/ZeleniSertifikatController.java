package com.example.officialsapplication.controller;

import com.example.officialsapplication.model.potvrda.Potvrda;
import com.example.officialsapplication.model.users.izvestaj.IzvestajOImunizaciji;
import com.example.officialsapplication.model.users.korisnik.Korisnik;
import com.example.officialsapplication.services.IzvestajOImunizacijiService;
import com.example.officialsapplication.services.ZeleniSertifikatService;
import com.google.zxing.WriterException;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/zelenisertifikati")
public class ZeleniSertifikatController {

    private final ZeleniSertifikatService zeleniSertifikatService;

    public ZeleniSertifikatController(ZeleniSertifikatService zeleniSertifikatService) {
        this.zeleniSertifikatService = zeleniSertifikatService;
    }

    
    @GetMapping("test/{id}")
    public Korisnik test(@PathVariable String id) throws DatatypeConfigurationException, IOException, DocumentException, MessagingException, WriterException {
    	RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<Korisnik> interesovanja
    	  = restTemplate.getForEntity("http://localhost:8087/api/korisnici/getUser/"+id, Korisnik.class);
    	
    	ResponseEntity<Potvrda> pot
  	  = restTemplate.getForEntity("http://localhost:8087/api/potvrde/"+id, Potvrda.class);
      	System.out.println("DASDASDAS " + pot.getBody().getVakcinacijaInfo().getNazivVakcine().getValue());
      	zeleniSertifikatService.zeleni(id);
    	return interesovanja.getBody();
    }
    
}
