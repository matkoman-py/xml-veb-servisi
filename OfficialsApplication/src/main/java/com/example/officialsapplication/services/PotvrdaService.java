package com.example.officialsapplication.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
public class PotvrdaService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final HtmlGeneratorService htmlGeneratorService;
    private final PdfGeneratorService pdfGeneratorService;

    public PotvrdaService(HtmlGeneratorService htmlGeneratorService, PdfGeneratorService pdfGeneratorService) {
        this.htmlGeneratorService = htmlGeneratorService;
        this.pdfGeneratorService = pdfGeneratorService;
    }


    public ByteArrayInputStream getPdf(String id) throws Exception {
        ResponseEntity<String> res =
                restTemplate.getForEntity("http://localhost:8087/api/potvrde/getXmlText/"+id, String.class);
        return pdfGeneratorService.generatePDF(res.getBody(), "OfficialsApplication/data/xsl-fo/potvrda_fo.xsl");
    }

    public ByteArrayInputStream getHtml(String id) throws IOException {
        ResponseEntity<String> res = restTemplate
                .getForEntity("http://localhost:8087/api/potvrde/getXmlText/" + id, String.class);
        return htmlGeneratorService.generateHTML(res.getBody(), "OfficialsApplication/data/xslt/potvrda.xsl");
    }
}
