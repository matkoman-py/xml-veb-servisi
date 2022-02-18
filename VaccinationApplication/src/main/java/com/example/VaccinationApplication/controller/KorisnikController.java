package com.example.VaccinationApplication.controller;

import com.example.VaccinationApplication.exceptions.KorisnikPostojiException;
import com.example.VaccinationApplication.exceptions.TerminNePostojiException;
import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import com.example.VaccinationApplication.model.users.korisnik.Korisnik;
import com.example.VaccinationApplication.services.KorisnikService;
import com.example.VaccinationApplication.services.PdfTransformerService;
import com.itextpdf.text.Document;

import jakarta.json.JsonStructure;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/korisnici")
public class KorisnikController {

    private final KorisnikService korisnikService;

    private final PdfTransformerService pdfTransformerService;
    
    public KorisnikController(KorisnikService korisnikService, PdfTransformerService pdfTransformerService) {
        this.korisnikService = korisnikService;
        this.pdfTransformerService = pdfTransformerService;
    }

    @ExceptionHandler(value = KorisnikPostojiException.class)
    public ResponseEntity handleInteresovanjeAlreadyExists(KorisnikPostojiException nullArticlesException) {
        return new ResponseEntity(nullArticlesException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("saveXmlText")
    public ResponseEntity<Korisnik> saveXml(@RequestBody String korisnikXml) throws Exception {
        Korisnik retval = korisnikService.saveXmlFromText(korisnikXml);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value="getUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<Korisnik> getUser(@PathVariable String id) throws Exception {
        Korisnik retval = korisnikService.getUser(id);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value="getUserData/{email}", method = RequestMethod.GET)
    public ResponseEntity<String> getUserData(@PathVariable String email) throws Exception {
        return ResponseEntity.ok(korisnikService.getDataForUser(email));
    }

    @RequestMapping(value="getPDF/{jmbg}/{docType}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getPDF(@PathVariable String jmbg, @PathVariable String docType) throws Exception {
        return ResponseEntity.ok(new InputStreamResource(korisnikService.getPDF(jmbg, docType)));
    }
    
    @RequestMapping(value="getHTML/{jmbg}/{docType}", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getHTML(@PathVariable String jmbg, @PathVariable String docType) throws Exception {
        return ResponseEntity.ok(new InputStreamResource(korisnikService.getHTML(jmbg, docType)));
    }
    
    @RequestMapping(value="getAllDocuments/{id}", method = RequestMethod.GET)
  public ResponseEntity<ArrayList<String>> getAllDocuments(@PathVariable String id) throws Exception {
      return ResponseEntity.ok(korisnikService.getAllDocuments(id));
  }
}
