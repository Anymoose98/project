package com.example.demo.db.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.db.entity.Torneo;
import com.example.demo.db.repo.TorneoRepo;

@Service
public class TorneoService {

    @Autowired
    private TorneoRepo torneoRepo;

    public List<Torneo> getAllTornei() {
        return torneoRepo.findAll();
    }

    public Torneo getTorneoById(Long id) {
        return torneoRepo.findById(id).orElse(null);
    }

    public Torneo saveTorneo(Torneo torneo) {
        return torneoRepo.save(torneo);
    }

    public void deleteTorneo(Long id) {
        torneoRepo.deleteById(id);
    }

    public List<Torneo> getTorneiByNome(String nome) {
        return torneoRepo.findByNome(nome);
    }

    public List<Torneo> getTorneiByDataInizio(LocalDate dataInizio) {
        return torneoRepo.findByDataInizio(dataInizio);
    }

    public List<Torneo> getTorneiByDataFine(LocalDate dataFine) {
        return torneoRepo.findByDataFine(dataFine);
    }

    public List<Torneo> getTorneiByGeografica(String geografica) {
        return torneoRepo.findByGeografica(geografica);
    }
}
