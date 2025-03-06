package com.example.demo.db.repo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.db.entity.Torneo;

@Repository
public interface TorneoRepo extends JpaRepository<Torneo, Long> {
    
    List<Torneo> findByNome(String nome);
    
    List<Torneo> findByDataInizio(LocalDate dataInizio);
    
    List<Torneo> findByDataFine(LocalDate dataFine);
    
    List<Torneo> findByGeografica(String geografica);
}
