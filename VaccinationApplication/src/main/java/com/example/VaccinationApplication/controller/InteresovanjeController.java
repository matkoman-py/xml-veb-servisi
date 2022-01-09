package com.example.VaccinationApplication.controller;

import com.example.VaccinationApplication.model.interesovanje.Interesovanje;
import com.example.VaccinationApplication.services.InteresovanjeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interesovanja")
public class InteresovanjeController {

    private final InteresovanjeService interesovanjeService;

    public InteresovanjeController(InteresovanjeService interesovanjeService) {
        this.interesovanjeService = interesovanjeService;
    }

    @GetMapping("getXml/{id}")
    public ResponseEntity<String> getXml(@PathVariable String id) {
        String retval = interesovanjeService.getXml(id);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("saveXml")
    public ResponseEntity<Interesovanje> saveXml(@RequestBody String interesovanjeXml) {
        Interesovanje retval = interesovanjeService.saveXml(interesovanjeXml);
        return ResponseEntity.ok(retval);
    }

    @PostMapping("convertToXml")
    public ResponseEntity<String> saveObject(@RequestBody Interesovanje interesovanje) {
        String retval = interesovanjeService.convertToXml(interesovanje);
        return ResponseEntity.ok(retval);
    }
}
