package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.db.entity.Torneo;
import com.example.demo.db.service.TorneoService;

@RestController
@CrossOrigin
@RequestMapping("/tornei")
public class TorneoController {

    @Autowired
    private TorneoService torneoService;

    // Visualizza tutti i tornei
    @GetMapping
    public List<Torneo> getAllTornei() {
        return torneoService.findAll();
    }

    // Visualizza un singolo torneo per ID
    @GetMapping("/{id}")
    public ResponseEntity<Torneo> getTorneoById(@PathVariable Long id) {
        Torneo torneo = torneoService.getTorneoById(id);
        return torneo != null ? ResponseEntity.ok(torneo) : ResponseEntity.notFound().build();
    }

    // Crea un nuovo torneo
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Torneo> createTorneo(@RequestBody Torneo torneo) {
        Torneo savedTorneo = torneoService.saveTorneo(torneo);
        return ResponseEntity.ok(savedTorneo);
    }

    // Modifica un torneo esistente
    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Torneo> updateTorneo(@PathVariable Long id, @RequestBody Torneo torneoDetails) {
        Torneo existingTorneo = torneoService.getTorneoById(id);
        if (existingTorneo == null) {
            return ResponseEntity.notFound().build();
        }

        existingTorneo.setNome(torneoDetails.getNome());
        existingTorneo.setDataInizio(torneoDetails.getDataInizio());
        existingTorneo.setDataFine(torneoDetails.getDataFine());
        existingTorneo.setGeografica(torneoDetails.getGeografica());

        Torneo updatedTorneo = torneoService.saveTorneo(existingTorneo);
        return ResponseEntity.ok(updatedTorneo);
    }

    // Cancella un torneo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTorneo(@PathVariable Long id) {
        Torneo torneo = torneoService.getTorneoById(id);
        if (torneo == null) {
            return ResponseEntity.notFound().build();
        }
        torneoService.deleteTorneo(id);
        return ResponseEntity.noContent().build();
    }
}