package com.example.demo.db.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TeamRobotica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int membri;
    private int punteggioTeam;
    private int torneiVinti;

    @OneToMany(mappedBy = "teamRobotica")
    @JsonBackReference
    private List<Robot> robot;

    public TeamRobotica() {
    }

    public TeamRobotica(String nome, int membri, int punteggioTeam, int torneiVinti) {
        this.nome = nome;
        this.membri = membri;
        this.punteggioTeam = punteggioTeam;
        this.torneiVinti = torneiVinti;
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

    public int getMembri() {
        return membri;
    }

    public void setMembri(int membri) {
        this.membri = membri;
    }

    public int getPunteggioTeam() {
        return punteggioTeam;
    }

    public void setPunteggioTeam(int punteggioTeam) {
        this.punteggioTeam = punteggioTeam;
    }

    public int getTorneiVinti() {
        return torneiVinti;
    }

    public void setTorneiVinti(int torneiVinti) {
        this.torneiVinti = torneiVinti;
    }

    public List<Robot> getRobot() {
        return robot;
    }

    public void setRobot(List<Robot> robot) {
        this.robot = robot;
    }

    @Override
    public String toString() {
        return "TeamRobotica [id=" + id + 
                ", nome=" + nome + 
                ", membri=" + membri + 
                ", punteggioTeam=" + punteggioTeam + 
                ", torneiVinti=" + torneiVinti + "]";
    }

    public void saveAll(List<TeamRobotica> asList) {
    }
}
