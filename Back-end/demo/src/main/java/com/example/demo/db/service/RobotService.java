package com.example.demo.db.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.db.entity.Robot;
import com.example.demo.db.entity.TeamRobotica;
import com.example.demo.db.entity.Torneo;
import com.example.demo.db.repo.RobotRepo;
import com.example.demo.db.repo.TorneoRepo;
import com.example.demo.db.repo.TeamRoboticaRepo;

@Service
public class RobotService {

    private final RobotRepo robotRepo;
    private final TorneoRepo torneoRepo;
    private final TeamRoboticaRepo teamRoboticaRepo;

    @Autowired
    public RobotService(RobotRepo robotRepo, TorneoRepo torneoRepo, TeamRoboticaRepo teamRoboticaRepo) {
        this.robotRepo = robotRepo;
        this.torneoRepo = torneoRepo;
        this.teamRoboticaRepo = teamRoboticaRepo;
    }

    public List<Robot> findAll() {
        return robotRepo.findAll();
    }

    public Robot getRobotById(Long id) {
        return robotRepo.findById(id).orElse(null);
    }

    public Robot saveRobot(Robot robot) {
        if (robot.getTeamRoboticaId() != null) {
            TeamRobotica team = teamRoboticaRepo.findById(robot.getTeamRoboticaId()).orElse(null);
            robot.setTeamRobotica(team);
        }

        if (robot.getTorneiIds() != null && !robot.getTorneiIds().isEmpty()) {
            List<Torneo> tornei = torneoRepo.findAllById(robot.getTorneiIds());
            robot.setTornei(tornei);
        }

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

    public List<Robot> getRobotsByPeso(double peso) {
        return robotRepo.findByPeso(peso);
    }

    public List<Robot> getRobotsByAltezza(double altezza) {
        return robotRepo.findByAltezza(altezza);
    }

    public List<Robot> getRobotsBystileDiCombattimento(String stileDiCombattimento) {
        return robotRepo.findBystileDiCombattimento(stileDiCombattimento);
    }

    public List<Robot> getRobotsByVelocita(double velocita) {
        return robotRepo.findByVelocita(velocita);
    }

    public List<Robot> getRobotsByPunteggioRobot(int punteggioRobot) {
        return robotRepo.findByPunteggioRobot(punteggioRobot);
    }

    public List<Robot> getRobotsByTeamRoboticaId(Long teamRoboticaId) {
        return robotRepo.findByTeamRobotica_Id(teamRoboticaId); // Metodo corretto nel repository
    }
}