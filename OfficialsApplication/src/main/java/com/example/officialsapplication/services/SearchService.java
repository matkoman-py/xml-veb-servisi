package com.example.officialsapplication.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.ByteArrayInputStream;

@Service
public class SearchService {

    private RestTemplate restTemplate = new RestTemplate();

    private final PdfGeneratorService pdfGeneratorService;

    public SearchService(PdfGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }


    public String advancedSearch(String ime, String prezime, String ustanova, String datum, boolean poklapanje) {

        String potvrdaUrl = getRequestPath("potvrde", ime, prezime, ustanova, datum, poklapanje);
        String saglasnostUrl = getRequestPath("saglasnost", ime, prezime, ustanova, datum, poklapanje);
        String sertifikatUrl = getRequestPath("zelenisertifikati", ime, prezime, ustanova, datum, poklapanje);

        StringBuilder str = new StringBuilder();
        str.append("<search>");
        str.append(restTemplate.getForEntity(potvrdaUrl, String.class).getBody());
        str.append(restTemplate.getForEntity(saglasnostUrl, String.class).getBody());
        str.append(restTemplate.getForEntity(sertifikatUrl, String.class).getBody());
        str.append("</search>");
        return str.toString();
    }

    public String getRequestPath(String controllerName, String ime, String prezime, String ustanova, String datum, boolean poklapanje) {
        String url = String.format("http://localhost:8087/api/%s/advanced-search/", controllerName);

        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("ime", ime)
                .queryParam("prezime", prezime)
                .queryParam("ustanova", ustanova)
                .queryParam("datum", datum)
                .queryParam("poklapanje", poklapanje).encode().toUriString();
    }

    public String basicSearch(String search) {
        StringBuilder str = new StringBuilder();

        str.append("<search>");

        str.append(restTemplate.getForEntity("http://localhost:8087/api/potvrde/search/" + search, String.class).getBody());
        str.append(restTemplate.getForEntity("http://localhost:8087/api/saglasnost/search/" + search, String.class).getBody());
        str.append(restTemplate.getForEntity("http://localhost:8087/api/zelenisertifikati/search/" + search, String.class).getBody());

        str.append("</search>");

        return str.toString();
    }

    public ByteArrayInputStream getPdf(String id) throws Exception {
        ResponseEntity<String> res =
                restTemplate.getForEntity("http://localhost:8087/api/zelenisertifikati/getXmlText/"+id, String.class);
        return pdfGeneratorService.generatePDF(res.getBody(), "data/xsl-fo/zeleni_fo.xsl");
    }
}
