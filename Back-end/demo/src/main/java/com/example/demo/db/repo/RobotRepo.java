package com.example.demo.db.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.db.entity.Robot;
import com.example.demo.db.entity.TeamRobotica;

@Repository
public interface RobotRepo extends JpaRepository<Robot, Long> {
    
    List<Robot> findByNome(String nome);
    
    List<Robot> findByModello(String modello);
    
    List<Robot> findByMateriale(String materiale);
    
    List<Robot> findByPeso(double peso);
    
    List<Robot> findByAltezza(double altezza);
    
    List<Robot> findBystileDiCombattimento(String stileDiCombattimento);
    
    List<Robot> findByVelocita(double velocita);
    
    List<Robot> findByPunteggioRobot(int punteggioRobot);
    
    List<Robot> findByTeamRobotica(TeamRobotica teamRobotica);

    List<Robot> findByTeamRobotica_Id(Long teamRoboticaId);
}