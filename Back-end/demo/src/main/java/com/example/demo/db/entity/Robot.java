package com.example.demo.db.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

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
    private String peso;
    private String altezza;
    private String armi;
    private String velocita;
    private int punteggioRobot;

    @ManyToOne
    @JoinColumn(name = "team_robotica_id")
    private TeamRobotica teamRobotica;

    @ManyToMany
    private List<Torneo> tornei;

    public Robot() {

        this.nome = "";
        this.modello = "";
        this.materiale = "";
        this.peso = "";
        this.altezza = "";
        this.armi = "";
        this.velocita = "";
        this.punteggioRobot = 0;
    }

    public Robot(String nome, String modello, String materiale, String peso, String altezza, String armi, String velocita, int punteggioRobot) {

        this.nome = nome;
        this.modello = modello;
        this.materiale = materiale;
        this.peso = peso;
        this.altezza = altezza;
        this.armi = armi;
        this.velocita = velocita;
        this.punteggioRobot = punteggioRobot;
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

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltezza() {
        return altezza;
    }

    public void setAltezza(String altezza) {
        this.altezza = altezza;
    }

    public String getArmi() {
        return armi;
    }

    public void setArmi(String armi) {
        this.armi = armi;
    }

    public String getVelocita() {
        return velocita;
    }

    public void setVelocita(String velocita) {
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
                ", armi=" + armi + 
                ", velocita=" + velocita + 
                ", punteggioRobot=" + punteggioRobot + 
                ", teamRobotica=" + teamRobotica + 
                ", tornei=" + tornei + "]";
    }

    
}
