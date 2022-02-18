package com.example.officialsapplication.services;

import com.example.officialsapplication.dto.MetadataDTO;
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
//    private final MetadataService metadataService;

    public PotvrdaService(HtmlGeneratorService htmlGeneratorService, PdfGeneratorService pdfGeneratorService) {
        this.htmlGeneratorService = htmlGeneratorService;
        this.pdfGeneratorService = pdfGeneratorService;
//        this.metadataService = metadataService;
    }


    public ByteArrayInputStream getPdf(String id) throws Exception {
        ResponseEntity<String> res =
                restTemplate.getForEntity("http://localhost:8087/api/potvrde/getXmlText/"+id, String.class);
        return pdfGeneratorService.generatePDF(res.getBody(), "data/xsl-fo/potvrda_fo.xsl");
    }

    public ByteArrayInputStream getHtml(String id) throws IOException {
        ResponseEntity<String> res = restTemplate
                .getForEntity("http://localhost:8087/api/potvrde/getXmlText/" + id, String.class);
        return htmlGeneratorService.generateHTML(res.getBody(), "data/xslt/potvrda.xsl");
    }

    public MetadataDTO getMetadataJSON(String id) throws IOException {
        return restTemplate.getForEntity("http://localhost:8087/api/potvrde/getMetadataJson/" + id, MetadataDTO.class).getBody();
    }

    public String getMetadataRDF(String id) {
        return restTemplate.getForEntity("http://localhost:8087/api/potvrde/getMetadataRdf/" + id, String.class).getBody();
    }
}
