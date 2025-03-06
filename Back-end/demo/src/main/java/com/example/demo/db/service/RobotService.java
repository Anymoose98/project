package com.example.demo.db.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.db.entity.Robot;
import com.example.demo.db.repo.RobotRepo;

@Service
public class RobotService {

    @Autowired
    private RobotRepo robotRepo;

    public List<Robot> getAllRobots() {
        return robotRepo.findAll();
    }

    public Robot getRobotById(Long id) {
        return robotRepo.findById(id).orElse(null);
    }

    public Robot saveRobot(Robot robot) {
        return robotRepo.save(robot);
    }

    public void deleteRobot(Long id) {
        robotRepo.deleteById(id);
    }

    public List<Robot> getRobotsByNome(String nome) {
        return robotRepo.findByNome(nome);
    }

    public List<Robot> getRobotsByModello(String modello) {
        return robotRepo.findByModello(modello);
    }

    public List<Robot> getRobotsByMateriale(String materiale) {
        return robotRepo.findByMateriale(materiale);
    }

    public List<Robot> getRobotsByPeso(String peso) {
        return robotRepo.findByPeso(peso);
    }

    public List<Robot> getRobotsByAltezza(String altezza) {
        return robotRepo.findByAltezza(altezza);
    }

    public List<Robot> getRobotsByArmi(String armi) {
        return robotRepo.findByArmi(armi);
    }

    public List<Robot> getRobotsByVelocita(String velocita) {
        return robotRepo.findByVelocita(velocita);
    }

    public List<Robot> getRobotsByPunteggioRobot(int punteggioRobot) {
        return robotRepo.findByPunteggioRobot(punteggioRobot);
    }

    public List<Robot> getRobotsByTeamRoboticaId(Long teamRoboticaId) {
        return robotRepo.findByTeamRoboticaId(teamRoboticaId);
    }
}