package com.project.isa.entity;

import jakarta.persistence.Column;

public class OpremaDTO {


    private Long id;


    private String naziv;


    private String tip;


    private String opis;


    private float ocena;


    public OpremaDTO(Long id, String naziv, String tip, String opis, float ocena) {
        this.id = id;
        this.naziv = naziv;
        this.tip = tip;
        this.opis = opis;
        this.ocena = ocena;
    }

    public OpremaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }
}
