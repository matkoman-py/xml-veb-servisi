package com.example.officialsapplication.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
public class SaglasnostService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final PdfGeneratorService pdfGeneratorService;
    private final HtmlGeneratorService htmlGeneratorService;

    public SaglasnostService(PdfGeneratorService pdfGeneratorService, HtmlGeneratorService htmlGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
        this.htmlGeneratorService = htmlGeneratorService;
    }

    public ByteArrayInputStream getPdf(String id) throws Exception {
        ResponseEntity<String> res =
                restTemplate.getForEntity("http://localhost:8087/api/saglasnost/getXmlText/" + id, String.class);
        return pdfGeneratorService.generatePDF(res.getBody(), "data/xsl-fo/saglasnost_fo.xsl");
    }

    public ByteArrayInputStream getHtml(String id) throws IOException {
        ResponseEntity<String> res = restTemplate
                .getForEntity("http://localhost:8087/api/saglasnost/getXmlText/" + id, String.class);
        return htmlGeneratorService.generateHTML(res.getBody(), "data/xslt/saglasnost.xsl");
    }
}
