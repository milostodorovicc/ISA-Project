package com.project.isa.entity;

public class AdministratorsistemaDTO {

    private String emailadresa;

    private String lozinka;

    private String ime;

    private String prezime;

    private String grad;

    private String drzava;

    private Long brojtelefona;

    private String zanimanje;

    private String infoopred;

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

    public AdministratorsistemaDTO(String emailadresa, String lozinka, String ime, String prezime, String grad, String drzava, Long brojtelefona, String zanimanje, String infoopred) {
        this.emailadresa = emailadresa;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.grad = grad;
        this.drzava = drzava;
        this.brojtelefona = brojtelefona;
        this.zanimanje = zanimanje;
        this.infoopred = infoopred;
    }

    public AdministratorsistemaDTO() {
    }
}
