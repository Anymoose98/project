package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.db.entity.Robot;
import com.example.demo.db.service.RobotService;

@RestController
@CrossOrigin
@RequestMapping("/robots")
public class RobotController {

    @Autowired
    private RobotService robotService;

    // Visualizza tutti i robot
    @GetMapping
    public List<Robot> getAllRobots() {
        return robotService.findAll();
    }

    // Visualizza un singolo robot per ID
    @GetMapping("/{id}")
    public ResponseEntity<Robot> getRobotById(@PathVariable Long id) {
        Robot robot = robotService.getRobotById(id);
        return robot != null ? ResponseEntity.ok(robot) : ResponseEntity.notFound().build();
    }

    // Crea un nuovo robot
    @PostMapping(consumes = "application/json")
    public ResponseEntity<Robot> createRobot(@RequestBody Robot robot) {
        Robot savedRobot = robotService.saveRobot(robot);
        return ResponseEntity.ok(savedRobot);
    }

    // Modifica un robot esistente
    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Robot> updateRobot(@PathVariable Long id, @RequestBody Robot robotDetails) {
        Robot existingRobot = robotService.getRobotById(id);
        if (existingRobot == null) {
            return ResponseEntity.notFound().build();
        }

        existingRobot.setNome(robotDetails.getNome());
        existingRobot.setModello(robotDetails.getModello());
        existingRobot.setMateriale(robotDetails.getMateriale());
        existingRobot.setPeso(robotDetails.getPeso());
        existingRobot.setAltezza(robotDetails.getAltezza());
        existingRobot.setStileDiCombattimento(robotDetails.getStileDiCombattimento());
        existingRobot.setVelocita(robotDetails.getVelocita());
        existingRobot.setPunteggioRobot(robotDetails.getPunteggioRobot());
        existingRobot.setTeamRoboticaId(robotDetails.getTeamRoboticaId());
        existingRobot.setTorneiIds(robotDetails.getTorneiIds());

        Robot updatedRobot = robotService.saveRobot(existingRobot);
        return ResponseEntity.ok(updatedRobot);
    }

    // Cancella un robot
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRobot(@PathVariable Long id) {
        Robot robot = robotService.getRobotById(id);
        if (robot == null) {
            return ResponseEntity.notFound().build();
        }
        robotService.deleteRobot(id);
        return ResponseEntity.noContent().build();
    }
}