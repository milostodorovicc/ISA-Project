package com.project.isa.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
public class Kompanija {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String naziv;
    @Column
    private String adresa;
    @Column
    private String opis;
    @Column
    private float prosecnaocena;

    @OneToMany(mappedBy ="kompanija", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Administratorkompanije> adminkompanije =  new HashSet<>();

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Administratorkompanije> getAdminkompanije() {
        return adminkompanije;
    }

    public void setAdminkompanije(Set<Administratorkompanije> adminkompanije) {
        this.adminkompanije = adminkompanije;
    }

    @ManyToMany
    @JoinTable(name = "kompanijeoprema",
            joinColumns = @JoinColumn(name = "kompanija_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "oprema_id", referencedColumnName = "id"))
    private Set<Oprema> oprema = new HashSet<>();


    public Set<Oprema> getOprema() {
        return oprema;
    }

    public void setOprema(Set<Oprema> oprema) {
        this.oprema = oprema;
    }

    public Kompanija(Long id, String naziv, String adresa, String opis, float prosecnaocena, Set<Administratorkompanije> adminkompanije, Set<Oprema> oprema) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.opis = opis;
        this.prosecnaocena = prosecnaocena;
        this.adminkompanije = adminkompanije;
        this.oprema = oprema;
    }

    public Kompanija() {
    }
}
