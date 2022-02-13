package com.example.VaccinationApplication.controller;

import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import com.example.VaccinationApplication.model.users.korisnik.Korisnik;
import com.example.VaccinationApplication.services.KorisnikService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/korisnici")
public class KorisnikController {

    private final KorisnikService korisnikService;

    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    @PostMapping("saveXmlText")
    public ResponseEntity<Korisnik> saveXml(@RequestBody String korisnikXml) {
        Korisnik retval = korisnikService.saveXmlFromText(korisnikXml);
        return ResponseEntity.ok(retval);
    }

}
