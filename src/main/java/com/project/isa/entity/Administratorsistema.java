package com.project.isa.entity;

import jakarta.persistence.*;



@Entity
public class Administratorsistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String emailadresa;
    @Column
    private String lozinka;
    @Column
    private String ime;
    @Column
    private String prezime;
    @Column
    private String grad;
    @Column
    private String drzava;
    @Column
    private Long brojtelefona;
    @Column
    private String zanimanje;
    @Column
    private String infoopred;
    @Column
    private int logincounter;
    @Enumerated(EnumType.STRING)
    private Uloga uloga;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailadresa() {
        return emailadresa;
    }

    public void setEmailadresa(String emailadresa) {
        this.emailadresa = emailadresa;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public Long getBrojtelefona() {
        return brojtelefona;
    }

    public void setBrojtelefona(Long brojtelefona) {
        this.brojtelefona = brojtelefona;
    }

    public String getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }

    public String getInfoopred() {
        return infoopred;
    }

    public void setInfoopred(String infoopred) {
        this.infoopred = infoopred;
    }

    public int getLogincounter() {
        return logincounter;
    }

    public void setLogincounter(int logincounter) {
        this.logincounter = logincounter;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }


    public Administratorsistema(Long id, String emailadresa, String lozinka, String ime, String prezime, String grad, String drzava, Long brojtelefona, String zanimanje, String infoopred, int logincounter, Uloga uloga) {
        this.id = id;
        this.emailadresa = emailadresa;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.grad = grad;
        this.drzava = drzava;
        this.brojtelefona = brojtelefona;
        this.zanimanje = zanimanje;
        this.infoopred = infoopred;
        this.logincounter = logincounter;
        this.uloga = uloga;
    }

    public Administratorsistema() {
    }
}
