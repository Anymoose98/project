package com.example.demo.db.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Robot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String nome;

    @Column(length = 64)
    private String modello;

    private String materiale;
    private double peso;
    private double altezza;
    private String stileDiCombattimento;
    private double velocita;
    private int punteggioRobot;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "team_robotica_id")
    private TeamRobotica teamRobotica;

    @ManyToMany
    private List<Torneo> tornei;

    // Campi aggiuntivi per gli ID (senza relazioni JPA dirette)
    @Transient
    private Long teamRoboticaId;

    @Transient
    private List<Long> torneiIds;

    public Robot() {}

    public Robot(String nome, String modello, String materiale, double peso, double altezza,
                 String stileDiCombattimento, double velocita, int punteggioRobot) {
        this.nome = nome;
        this.modello = modello;
        this.materiale = materiale;
        this.peso = peso;
        this.altezza = altezza;
        this.stileDiCombattimento = stileDiCombattimento;
        this.velocita = velocita;
        this.punteggioRobot = punteggioRobot;
    }

    // Getters e Setters per gli ID separati
    public Long getTeamRoboticaId() {
        return teamRoboticaId;
    }

    public void setTeamRoboticaId(Long teamRoboticaId) {
        this.teamRoboticaId = teamRoboticaId;
    }

    public List<Long> getTorneiIds() {
        return torneiIds;
    }

    public void setTorneiIds(List<Long> torneiIds) {
        this.torneiIds = torneiIds;
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

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public String getStileDiCombattimento() {
        return stileDiCombattimento;
    }

    public void setStileDiCombattimento(String stileDiCombattimento) {
        this.stileDiCombattimento = stileDiCombattimento;
    }

    public double getVelocita() {
        return velocita;
    }

    public void setVelocita(double velocita) {
        this.velocita = velocita;
    }

    public int getPunteggioRobot() {
        return punteggioRobot;
    }

    public void setPunteggioRobot(int punteggioRobot) {
        this.punteggioRobot = punteggioRobot;
    }

    public TeamRobotica getTeamRobotica() {
        return teamRobotica;
    }

    public void setTeamRobotica(TeamRobotica teamRobotica) {
        this.teamRobotica = teamRobotica;
    }

    public List<Torneo> getTornei() {
        return tornei;
    }

    public void setTornei(List<Torneo> tornei) {
        this.tornei = tornei;
    }

    @Override
    public String toString() {
        return "Robot [id=" + id +
                ", nome=" + nome +
                ", modello=" + modello +
                ", materiale=" + materiale +
                ", peso=" + peso +
                ", altezza=" + altezza +
                ", stileDiCombattimento=" + stileDiCombattimento +
                ", velocita=" + velocita +
                ", punteggioRobot=" + punteggioRobot +
                ", teamRobotica=" + teamRobotica +
                ", tornei=" + tornei + "]";
    }

}
