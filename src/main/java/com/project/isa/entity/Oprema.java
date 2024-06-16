package com.project.isa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
public class Oprema {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String tip;

    @Column
    private String opis;

    @Column
    private float ocena;

    @Column
    private int cena;

    @Column
    private Integer kolicina;

    @ManyToMany(mappedBy = "oprema")
    private Set<Kompanija> kompanije = new HashSet<>();

    @ManyToMany(mappedBy = "oprema1")
    private Set<Rezervacija> rezervacije = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getTip() {
        return tip;
    }

    public String getOpis() {
        return opis;
    }

    public float getOcena() {
        return ocena;
    }

    public Set<Kompanija> getKompanije() {
        return kompanije;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public void setKompanije(Set<Kompanija> kompanije) {
        this.kompanije = kompanije;
    }

    public Oprema() {
    }

    public Oprema(Long id, String naziv, String tip, String opis, float ocena, Set<Kompanija> kompanije) {
        this.id = id;
        this.naziv = naziv;
        this.tip = tip;
        this.opis = opis;
        this.ocena = ocena;
        this.kompanije = kompanije;
    }


    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}
