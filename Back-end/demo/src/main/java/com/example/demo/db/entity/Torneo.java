package com.example.demo.db.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
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
    private String dataInizio;

    private String dataFine;

    private String geografica;

    private String img;


    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Robot> robot;

    public Torneo() {
        this.nome = "";
        this.dataInizio = "";
        this.dataFine = "";
        this.geografica = "";
        this.img = "";
    }

    public Torneo(String nome, String dataInizio, String dataFine, String geografica, String img) {
        this.nome = nome;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.geografica = geografica;
        this.img = img;
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

    public String getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(String dataInizio) {
        this.dataInizio = dataInizio;
    }

    public String getDataFine() {
        return dataFine;
    }

    public void setDataFine(String dataFine) {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
