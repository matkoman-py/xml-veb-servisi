package com.example.officialsapplication.controller;

import com.example.officialsapplication.services.SearchService;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value = "/advanced-search", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> advancedSearch(@RequestParam(required = false) String ime,
                                                 @RequestParam(required = false) String prezime,
                                                 @RequestParam(required = false) String ustanova,
                                                 @RequestParam(required = false) String datum,
                                                 @RequestParam(required = false) boolean poklapanje) {
        return ResponseEntity.ok(searchService.advancedSearch(ime, prezime, ustanova, datum, poklapanje));
    }

    @RequestMapping(value = "/basic-search/{search}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> basicSearch(@PathVariable String search) {
        return ResponseEntity.ok(searchService.basicSearch(search));
    }

    @RequestMapping(value = "/getPdf/{id}",method = RequestMethod.GET)
    public ResponseEntity<byte[]> getPdf(@PathVariable String id) throws Exception {
        ByteArrayInputStream stream = searchService.getPdf(id);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "sertifikat.pdf";

//        headers.add("Content-Disposition", "inline; filename=" + "sertifikat.pdf");

        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<byte[]>(IOUtils.toByteArray(stream), headers, HttpStatus.OK);
    }
}
