package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.db.entity.Torneo;
import com.example.demo.db.service.TorneoService;

@RestController
@CrossOrigin
@RequestMapping("/tournaments")
public class ControllerTorneo {

    @Autowired
    private TorneoService torneoService;
    public ControllerTorneo(TorneoService torneoService) {
        this.torneoService = torneoService;
    }

    @GetMapping
    public ResponseEntity<List<Torneo>> findAll() {
        List<Torneo>Tournaments = torneoService.findAll();
        return ResponseEntity.ok(Tournaments);
    }



}
