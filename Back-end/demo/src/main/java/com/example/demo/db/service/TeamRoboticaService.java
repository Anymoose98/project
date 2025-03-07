package com.example.demo.db.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.db.entity.TeamRobotica;
import com.example.demo.db.repo.TeamRoboticaRepo;

@Service
public class TeamRoboticaService {

    @Autowired
    private TeamRoboticaRepo teamRoboticaRepo;

    public List<TeamRobotica> findAll() {
        return teamRoboticaRepo.findAll();
    }

    public TeamRobotica getTeamById(Long id) {
        return teamRoboticaRepo.findById(id).orElse(null);
    }

    public TeamRobotica save(TeamRobotica teamRobotica) {
        return teamRoboticaRepo.save(teamRobotica);
    }

    public void deleteById(Long id) {
        teamRoboticaRepo.deleteById(id);
    }

    public List<TeamRobotica> getTeamsByNome(String nome) {
        return teamRoboticaRepo.findByNome(nome);
    }

    public List<TeamRobotica> getTeamsByMembri(int membri) {
        return teamRoboticaRepo.findByMembri(membri);
    }

    public List<TeamRobotica> getTeamsByPunteggioTeam(int punteggioTeam) {
        return teamRoboticaRepo.findByPunteggioTeam(punteggioTeam);
    }

    public List<TeamRobotica> getTeamsByTorneiVinti(int torneiVinti) {
        return teamRoboticaRepo.findByTorneiVinti(torneiVinti);
    }
}
