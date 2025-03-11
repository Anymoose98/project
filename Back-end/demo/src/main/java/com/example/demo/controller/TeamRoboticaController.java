package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.db.entity.TeamRobotica;
import com.example.demo.db.service.TeamRoboticaService;

@RestController
@CrossOrigin
@RequestMapping("/teams")
public class TeamRoboticaController {

    @Autowired
    private TeamRoboticaService teamRoboticaService;

    // Visualizza tutti i team
    @GetMapping
    public List<TeamRobotica> getAllTeams() {
        return teamRoboticaService.findAll();
    }

    // Visualizza un singolo team per ID
    @GetMapping("/{id}")
    public ResponseEntity<TeamRobotica> getTeamById(@PathVariable Long id) {
        TeamRobotica team = teamRoboticaService.getTeamById(id);
        return team != null ? ResponseEntity.ok(team) : ResponseEntity.notFound().build();
    }

    // Crea un nuovo team
    @PostMapping(consumes = "application/json")
    public ResponseEntity<TeamRobotica> createTeam(@RequestBody TeamRobotica team) {
        TeamRobotica savedTeam = teamRoboticaService.save(team);
        return ResponseEntity.ok(savedTeam);
    }

    // Modifica un team esistente
    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<TeamRobotica> updateTeam(@PathVariable Long id, @RequestBody TeamRobotica teamDetails) {
        TeamRobotica existingTeam = teamRoboticaService.getTeamById(id);
        if (existingTeam == null) {
            return ResponseEntity.notFound().build();
        }

        existingTeam.setNome(teamDetails.getNome());
        existingTeam.setMembri(teamDetails.getMembri());
        existingTeam.setPunteggioTeam(teamDetails.getPunteggioTeam());
        existingTeam.setTorneiVinti(teamDetails.getTorneiVinti());

        TeamRobotica updatedTeam = teamRoboticaService.save(existingTeam);
        return ResponseEntity.ok(updatedTeam);
    }

    // Cancella un team
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        TeamRobotica team = teamRoboticaService.getTeamById(id);
        if (team == null) {
            return ResponseEntity.notFound().build();
        }
        teamRoboticaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}