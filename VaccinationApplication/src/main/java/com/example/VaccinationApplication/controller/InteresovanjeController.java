package com.example.VaccinationApplication.controller;

import com.example.VaccinationApplication.dao.InteresovanjeDAO;
import com.example.VaccinationApplication.model.documents.Interesovanje;
import com.example.VaccinationApplication.services.InteresovanjeService;
import lombok.RequiredArgsConstructor;
import org.apache.jena.base.Sys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/api/interesovanja")
@RequiredArgsConstructor
public class InteresovanjeController {

    private final InteresovanjeService interesovanjeService;

    @GetMapping("/{id}")
    public ResponseEntity<String> get(@PathVariable String id) {
        String retval = interesovanjeService.get("1010998800070");
        return ResponseEntity.ok(retval);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody String interesovanjeXml) {
        String retval = interesovanjeService.save(interesovanjeXml);
        return ResponseEntity.ok(retval);
    }
}
