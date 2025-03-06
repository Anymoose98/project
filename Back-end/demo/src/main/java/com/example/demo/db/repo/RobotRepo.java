package com.example.demo.db.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.db.entity.Robot;

@Repository
public interface RobotRepo extends JpaRepository<Robot, Long> {
    
    List<Robot> findByNome(String nome);
    
    List<Robot> findByModello(String modello);
    
    List<Robot> findByMateriale(String materiale);
    
    List<Robot> findByPeso(String peso);
    
    List<Robot> findByAltezza(String altezza);
    
    List<Robot> findByArmi(String armi);
    
    List<Robot> findByVelocita(String velocita);
    
    List<Robot> findByPunteggioRobot(int punteggioRobot);
    
    List<Robot> findByTeamRoboticaId(Long teamRoboticaId);
}