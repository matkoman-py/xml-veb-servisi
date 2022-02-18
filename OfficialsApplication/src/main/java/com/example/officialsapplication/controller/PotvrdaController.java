package com.example.officialsapplication.controller;

import com.example.officialsapplication.dto.MetadataDTO;
import com.example.officialsapplication.services.PotvrdaService;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/potvrde")
public class PotvrdaController {

    private final PotvrdaService potvrdaService;

    public PotvrdaController(PotvrdaService potvrdaService) {
        this.potvrdaService = potvrdaService;
    }

    @RequestMapping(value = "/getPdf/{id}",method = RequestMethod.GET)
    public ResponseEntity<byte[]> getPdf(@PathVariable String id) throws Exception {
        ByteArrayInputStream stream = potvrdaService.getPdf(id);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "potvrda.pdf";

        headers.add("Content-Disposition", "inline; filename=" + "sertifikat.pdf");

        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<>(IOUtils.toByteArray(stream), headers, HttpStatus.OK);
    }

    @GetMapping("getHtml/{id}")
    public ResponseEntity<byte[]>getHtml(@PathVariable String id) throws Exception {
        ByteArrayInputStream bi = potvrdaService.getHtml(id);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.parseMediaType("application/html"));
        String filename = "potvrda.html";

        headers.add("Content-Disposition", "inline; filename=" + "potvrda.html");

        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<byte[]>(IOUtils.toByteArray(bi), headers, HttpStatus.OK);
    }

    @GetMapping("/getMetadataJson/{id}")
    public MetadataDTO getMetadataJson(@PathVariable String id) throws IOException {
        return potvrdaService.getMetadataJSON(id);
    }

    @RequestMapping(value = "/getMetadataRdf/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public String getMetadataRdf(@PathVariable String id) {
        return potvrdaService.getMetadataRDF(id);
    }

}
