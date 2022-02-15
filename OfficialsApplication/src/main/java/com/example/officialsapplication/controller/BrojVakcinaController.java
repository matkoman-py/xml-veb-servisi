package com.example.officialsapplication.controller;

import com.example.officialsapplication.model.users.BrojVakcina;
import com.example.officialsapplication.model.users.izvestaj.IzvestajOImunizaciji;
import com.example.officialsapplication.services.BrojVakcinaServis;
import com.example.officialsapplication.services.IzvestajOImunizacijiService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/broj-vakcina")
public class BrojVakcinaController {

    private final BrojVakcinaServis brojVakcinaServis;

    public BrojVakcinaController(BrojVakcinaServis brojVakcinaServis) {
        this.brojVakcinaServis = brojVakcinaServis;
    }

    @PostMapping("createAndUpdate")
    public ResponseEntity<BrojVakcina> createAndUpdate(@RequestBody String brojVakcina) {
        BrojVakcina retval = brojVakcinaServis.createAndUpdateBrojVakcina(brojVakcina);
        return ResponseEntity.ok(retval);
    }

    @PutMapping("smanjiBrojVakcina/{vakcina}")
    public ResponseEntity<BrojVakcina> smanjiBrojVakcina(@PathVariable String vakcina) {
        BrojVakcina retval = brojVakcinaServis.smanjiBrojVakcina(vakcina);
        return ResponseEntity.ok(retval);
    }

    @GetMapping(value = "getBrojVakcina/{vakcina}")
    public ResponseEntity<Integer> getBrojVakcina(@PathVariable String vakcina) {
        Integer retval = brojVakcinaServis.getBrojVakcina(vakcina);
        return ResponseEntity.ok(retval);
    }

    @GetMapping(value = "getAll", produces= MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getAll() throws Exception {
        String retval = brojVakcinaServis.getAll();
        return ResponseEntity.ok(retval);
    }
}
