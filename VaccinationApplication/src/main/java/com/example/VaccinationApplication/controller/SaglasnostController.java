package com.example.VaccinationApplication.controller;

import com.example.VaccinationApplication.dto.MetadataDTO;
import com.example.VaccinationApplication.exceptions.InteresovanjeAlreadyExistsException;
import com.example.VaccinationApplication.exceptions.SaglasnostNijeIskazanaException;
import com.example.VaccinationApplication.exceptions.TerminNePostojiException;
import com.example.VaccinationApplication.model.saglasnost.Saglasnost;
import com.example.VaccinationApplication.services.SaglasnostService;

import java.io.FileNotFoundException;

import javax.xml.transform.TransformerException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/saglasnost")
public class SaglasnostController {

    private final SaglasnostService saglasnostService;

    public SaglasnostController(SaglasnostService saglasnostService) {
        this.saglasnostService = saglasnostService;
    }

    @ExceptionHandler(value = TerminNePostojiException.class)
    public ResponseEntity handleInteresovanjeAlreadyExists(TerminNePostojiException nullArticlesException) {
        return new ResponseEntity(nullArticlesException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = SaglasnostNijeIskazanaException.class)
    public ResponseEntity handleNemaSaglasnosti(SaglasnostNijeIskazanaException nullArticlesException) {
        return new ResponseEntity(nullArticlesException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("getXmlText/{id}")
    public ResponseEntity<String> getXmlText(@PathVariable String id) {
        String retval = saglasnostService.getXmlAsText(id);
        return ResponseEntity.ok(retval);
    }

    @GetMapping("getXmlObject/{id}")
    public ResponseEntity<Saglasnost> getXmlObject(@PathVariable String id) {
        Saglasnost retval = saglasnostService.getXmlAsObject(id);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> sve() throws Exception {
    	String retval = saglasnostService.getAll();
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/getForDate/{dateFrom}/{dateTo}", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> sveZaDatum(@PathVariable String dateFrom, @PathVariable String dateTo) throws Exception {
    	String retval = saglasnostService.getAllForDate(dateFrom,dateTo);
        return ResponseEntity.ok(retval);
    }
    
    @RequestMapping(value = "/getForUser/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> sveZaUsera(@PathVariable String id) throws Exception {
    	String retval = saglasnostService.getAllForUser(id);
        return ResponseEntity.ok(retval);
    }

    @RequestMapping(value = "/getZaEvidentiranje/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> saglasnostZaEvidentiranje(@PathVariable String id) throws Exception {
        String retval = saglasnostService.getSaglasnostZaEvidentiranje(id);
        return ResponseEntity.ok(retval);
    }

    @RequestMapping(value = "/search/{search}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> searchSaglasnostContaining(@PathVariable String search) throws Exception {
        return ResponseEntity.ok(saglasnostService.searchSaglasnostContaining(search));
    }

    @RequestMapping(value = "/advanced-search", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getSaglasnostAdvanced(@RequestParam(required = false) String ime,
                                                        @RequestParam(required = false) String prezime,
                                                        @RequestParam(required = false) String ustanova,
                                                        @RequestParam(required = false) String datum,
                                                        @RequestParam(required = false) boolean poklapanje) {
        return ResponseEntity.ok(saglasnostService.getSaglasnostAdvanced(ime, prezime, ustanova, datum, poklapanje));
    }

    @PostMapping("saveXmlText/{doza}")
    public ResponseEntity<Saglasnost> saveXmlText(@PathVariable String doza, @RequestBody String saglasnostXml) throws Exception {
        Saglasnost retval = saglasnostService.saveXmlFromText(saglasnostXml, doza);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("updateSaglasnost/{doza}")
    public ResponseEntity<Saglasnost> updateSaglasnost(@PathVariable String doza, @RequestBody String saglasnostXml) throws Exception {
        Saglasnost retval = saglasnostService.updateSaglasnost(doza,saglasnostXml);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("saveXmlObject")
    public ResponseEntity<Saglasnost> saveXmlObject(@RequestBody Saglasnost saglasnost) {
        Saglasnost retval = saglasnostService.saveXmlFromObject(saglasnost);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("convertToXml")
    public ResponseEntity<String> saveObject(@RequestBody Saglasnost saglasnost) {
        String retval = saglasnostService.convertToXml(saglasnost);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("convertToObject")
    public ResponseEntity<Saglasnost> xmlToObject(@RequestBody String xmlString) {
        Saglasnost retval = saglasnostService.convertToObject(xmlString);
        return ResponseEntity.ok(retval);
    }

    @GetMapping("/getMetadataJson/{id}")
    public MetadataDTO getMetadataJson(@PathVariable String id) {
        return saglasnostService.getMetadataJSON(id);
    }

    @RequestMapping(value = "/getMetadataRdf/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public String getMetadataRdf(@PathVariable String id) {
        return saglasnostService.getMetadataRDF(id);
    }

}
