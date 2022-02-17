package com.example.officialsapplication.controller;

import com.example.officialsapplication.exceptions.EntityNotFoundException;
import com.example.officialsapplication.exceptions.RequestAlreadyAnsweredException;
import com.example.officialsapplication.model.potvrda.Potvrda;
import com.example.officialsapplication.model.users.izvestaj.IzvestajOImunizaciji;
import com.example.officialsapplication.model.users.korisnik.Korisnik;
import com.example.officialsapplication.model.zeleni_sertifikat.ZeleniSertifikat;
import com.example.officialsapplication.services.IzvestajOImunizacijiService;
import com.example.officialsapplication.services.ZeleniSertifikatService;
import com.google.zxing.WriterException;
import com.itextpdf.text.DocumentException;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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
    
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(EntityNotFoundException entityNotFoundException) {
        return new ResponseEntity(entityNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(value = RequestAlreadyAnsweredException.class)
    public ResponseEntity handleRequestAlreadyAnsweredException(RequestAlreadyAnsweredException requestAlreadyAnsweredException) {
        return new ResponseEntity(requestAlreadyAnsweredException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    
    @RequestMapping(value = "/prihvatiZahtev/{zahtevId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> prihvati(@PathVariable String zahtevId) throws Exception {
    	
    	
      	String zeleniSertifikat = zeleniSertifikatService.prihvatiZeleni(zahtevId);
      	return ResponseEntity.ok(zeleniSertifikat);
    }
    
    @RequestMapping(value = "/odbijZahtev/{zahtevId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> odbij(@PathVariable String zahtevId, @RequestBody String razlog) throws Exception {
    	
    	
      	zeleniSertifikatService.odbijZeleni(zahtevId, razlog);
      	return ResponseEntity.ok("OK");
    }
    
    @GetMapping("pdf/{id}")
    public ResponseEntity<byte[]> test(@PathVariable String id) throws Exception {
    	ByteArrayInputStream bi = zeleniSertifikatService.getPdfRequest(id);
    		
    	HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "izvestaj.pdf";

        headers.add("Content-Disposition", "inline; filename=" + "example.pdf");

        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        
        return new ResponseEntity<byte[]>(IOUtils.toByteArray(bi), headers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getAllWaiting", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> sveCekanje() throws Exception {
    	String retval = zeleniSertifikatService.getZahtevi();
        return ResponseEntity.ok(retval);
    }
    
}
