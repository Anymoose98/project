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
import com.example.demo.db.service.RobotService;

@RestController
@CrossOrigin
@RequestMapping("/robots")
public class ControllerRobot {

    @Autowired
    private RobotService robotService;
    public ControllerRobot(RobotService robotService) {
        this.robotService = robotService;
    }

    @GetMapping
    public ResponseEntity<List<Robot>> findAll() {
        List<Robot> Robots = robotService.findAll();
        return ResponseEntity.ok(Robots);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Robot> findById(@PathVariable Long id) {
        Robot robot = robotService.getRobotById(id);
        if (robot != null) {
            return ResponseEntity.ok(robot);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
