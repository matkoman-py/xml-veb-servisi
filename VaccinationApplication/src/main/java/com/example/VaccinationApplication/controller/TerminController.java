package com.example.VaccinationApplication.controller;

import com.example.VaccinationApplication.services.InteresovanjeService;
import com.example.VaccinationApplication.services.TerminService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/termini")
public class TerminController {

    private final TerminService terminService;

    public TerminController(TerminService terminService) {
        this.terminService = terminService;
    }

    @RequestMapping(value = "/upisiNaCekanju/{vakcina}", method = RequestMethod.GET)
    public ResponseEntity<String> upisiNaCekanju(@PathVariable String vakcina) throws Exception {
        String retval = terminService.upisiNaCekanju(vakcina);
        return ResponseEntity.ok(retval);
    }
}
