package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.entity.Robot;
import com.example.demo.db.entity.TeamRobotica;
import com.example.demo.db.service.TeamRoboticaService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
@RequestMapping("/teams")
public class ControllerTeamRobotica {
    @Autowired
    private TeamRoboticaService teamRoboticaService;
    public ControllerTeamRobotica(TeamRoboticaService teamRoboticaService) {
        this.teamRoboticaService = teamRoboticaService;
    }

    @GetMapping
    public ResponseEntity<List<TeamRobotica>> findAll() {
        List<TeamRobotica> Teams = teamRoboticaService.findAll();
        return ResponseEntity.ok(Teams);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TeamRobotica> findById(@PathVariable Long id) {
        TeamRobotica teamRobotica = teamRoboticaService.getTeamById(id);
        if (teamRobotica != null) {
            return ResponseEntity.ok(teamRobotica);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
}
