package com.project.isa.entity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Registrovanikorisnik {

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
    private Integer brojpenala;
    @Column
    private String infoopred;
    @Column
    private Integer brojpoena;
    @Column
    private int budzet;
    @Enumerated(EnumType.STRING)
    private Uloga uloga;
    @Enumerated(EnumType.STRING)
    private Kategorija kategorija;
    @ManyToOne(fetch = FetchType.EAGER)
    private Kompanija kompanija;
    @OneToMany(mappedBy ="regkorisnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Rezervacija> rezervacije1 =  new HashSet<>();
    @OneToMany(mappedBy ="regkorisnik1", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Zalba> zalbe =  new HashSet<>();

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

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public Kompanija getKompanija() {
        return kompanija;
    }

    public void setKompanija(Kompanija kompanija) {
        this.kompanija = kompanija;
    }



    public Set<Zalba> getZalbe() {
        return zalbe;
    }

    public void setZalbe(Set<Zalba> zalbe) {
        this.zalbe = zalbe;
    }

    public Registrovanikorisnik(Long id, String emailadresa, String lozinka, String ime, String prezime, String grad, String drzava, Long brojtelefona, String zanimanje, String infoopred, Uloga uloga) {
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
        this.uloga = uloga;

    }

    public Registrovanikorisnik() {
    }

    public Integer getBrojpenala() {
        return brojpenala;
    }

    public void setBrojpenala(Integer brojpenala) {
        this.brojpenala = brojpenala;
    }


    public Integer getBrojpoena() {
        return brojpoena;
    }

    public void setBrojpoena(Integer brojpoena) {
        this.brojpoena = brojpoena;
    }


    public int getBudzet() {
        return budzet;
    }

    public void setBudzet(int budzet) {
        this.budzet = budzet;
    }


    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }
}
