package com.example.demo.db.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.db.entity.TeamRobotica;

@Repository
public interface TeamRoboticaRepo extends JpaRepository<TeamRobotica, Long> {
    
    List<TeamRobotica> findByNome(String nome);
    
    List<TeamRobotica> findByMembri(int membri);
    
    List<TeamRobotica> findByPunteggioTeam(int punteggioTeam);
    
    List<TeamRobotica> findByTorneiVinti(int torneiVinti);

    
}
