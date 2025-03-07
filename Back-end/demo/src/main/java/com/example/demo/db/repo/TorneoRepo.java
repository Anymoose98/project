package com.example.demo.db.repo;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.db.entity.Torneo;

@Repository
public interface TorneoRepo extends JpaRepository<Torneo, Long> {
    
    List<Torneo> findByNome(String nome);
    
    List<Torneo> findByDataInizio(String dataInizio);
    
    List<Torneo> findByDataFine(String dataFine);
    
    List<Torneo> findByGeografica(String geografica);
}
