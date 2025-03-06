package com.example.demo.db.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String nome;

    @Column(length = 64)
    private LocalDate dataInizio;

    private LocalDate dataFine;

    private String geografica;

    @ManyToMany(mappedBy = "tornei")
    private List<Robot> robot;

    public Torneo() {
        this.nome = "";
        this.dataInizio = LocalDate.now();
        this.dataFine = LocalDate.now();
        this.geografica = "";
    }

    public Torneo(String nome, LocalDate dataInizio, LocalDate dataFine, String geografica) {
        this.nome = nome;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.geografica = geografica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public String getGeografica() {
        return geografica;
    }

    public void setGeografica(String geografica) {
        this.geografica = geografica;
    }

    public List<Robot> getRobot() {
        return robot;
    }

    public void setRobot(List<Robot> robot) {
        this.robot = robot;
    }

    @Override
    public String toString() {
        return "Torneo [id=" + id +
                ", nome=" + nome +
                ", dataInizio=" + dataInizio +
                ", dataFine=" + dataFine +
                ", geografica=" + geografica + "]";
    }
}
