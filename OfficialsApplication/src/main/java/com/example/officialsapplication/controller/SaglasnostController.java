package com.example.officialsapplication.controller;

import com.example.officialsapplication.services.SaglasnostService;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/api/saglasnost")
public class SaglasnostController {

    private final SaglasnostService saglasnostService;

    public SaglasnostController(SaglasnostService saglasnostService) {
        this.saglasnostService = saglasnostService;
    }

    @RequestMapping(value = "/getPdf/{id}",method = RequestMethod.GET)
    public ResponseEntity<byte[]> getPdf(@PathVariable String id) throws Exception {
        ByteArrayInputStream stream = saglasnostService.getPdf(id);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "saglasnost.pdf";

        headers.add("Content-Disposition", "inline; filename=" + "saglasnost.pdf");

        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<>(IOUtils.toByteArray(stream), headers, HttpStatus.OK);
    }

    @GetMapping("getHtml/{id}")
    public ResponseEntity<byte[]> getHtml(@PathVariable String id) throws Exception {
        ByteArrayInputStream bi = saglasnostService.getHtml(id);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.parseMediaType("application/html"));
        String filename = "saglasnost.html";

        headers.add("Content-Disposition", "inline; filename=" + "saglasnost.html");

        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<byte[]>(IOUtils.toByteArray(bi), headers, HttpStatus.OK);
    }
}
