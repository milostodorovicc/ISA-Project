package com.project.isa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class KompanijaDTO {




    private String naziv;

    private String adresa;

    private String opis;

    private float prosecnaocena;


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public float getProsecnaocena() {
        return prosecnaocena;
    }

    public void setProsecnaocena(float prosecnaocena) {
        this.prosecnaocena = prosecnaocena;
    }

    public KompanijaDTO(String naziv, String adresa, String opis, float prosecnaocena) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.opis = opis;
        this.prosecnaocena = prosecnaocena;
    }


    public KompanijaDTO() {
    }
}
