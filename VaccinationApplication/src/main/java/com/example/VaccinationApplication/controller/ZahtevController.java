package com.example.VaccinationApplication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.VaccinationApplication.model.documents.Zahtev;
import com.example.VaccinationApplication.services.ZahtevService;

@RestController
@RequestMapping("/api/zahtevi")
public class ZahtevController {
	
	private final ZahtevService zahtevService;

    public ZahtevController(ZahtevService zahtevService) {
        this.zahtevService = zahtevService;
    }

    @GetMapping("getXml/{id}")
    public ResponseEntity<String> getXml(@PathVariable String id) {
        String retval = zahtevService.getXml(id);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("saveXml")
    public ResponseEntity<Zahtev> saveXml(@RequestBody String zahtevXml) {
    	Zahtev retval = zahtevService.saveXml(zahtevXml);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("convertToXml")
    public ResponseEntity<String> saveObject(@RequestBody Zahtev zahtev) {
        String retval = zahtevService.convertToXml(zahtev);
        return ResponseEntity.ok(retval);
    }
}
