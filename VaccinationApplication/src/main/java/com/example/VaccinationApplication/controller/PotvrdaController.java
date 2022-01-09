package com.example.VaccinationApplication.controller;

import com.example.VaccinationApplication.model.potvrda.Potvrda;
import com.example.VaccinationApplication.services.PotvrdaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/potvrde")
public class PotvrdaController {

    private final PotvrdaService potvrdaService;

    public PotvrdaController(PotvrdaService potvrdaService) {
        this.potvrdaService = potvrdaService;
    }

    @GetMapping("getXml/{id}")
    public ResponseEntity<String> getXml(@PathVariable String id) {
        String retval = potvrdaService.getXml(id);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("saveXml")
    public ResponseEntity<Potvrda> saveXml(@RequestBody String potvrdaXml) {
        Potvrda retval = potvrdaService.saveXml(potvrdaXml);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("convertToXml")
    public ResponseEntity<String> saveObject(@RequestBody Potvrda potvrda) {
        String retval = potvrdaService.convertToXml(potvrda);
        return ResponseEntity.ok(retval);
    }
}
