package com.example.demo.db.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.db.entity.Torneo;
import com.example.demo.db.repo.TorneoRepo;

@Service
public class TorneoService {

    @Autowired
    private TorneoRepo torneoRepo;

    public List<Torneo> findAll() {
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

    public List<Torneo> getTorneiByDataInizio(String dataInizio) {
        return torneoRepo.findByDataInizio(dataInizio);
    }

    public List<Torneo> getTorneiByDataFine(String dataFine) {
        return torneoRepo.findByDataFine(dataFine);
    }

    public List<Torneo> getTorneiByGeografica(String geografica) {
        return torneoRepo.findByGeografica(geografica);
    }


}
