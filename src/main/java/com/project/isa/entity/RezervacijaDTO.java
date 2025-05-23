package com.project.isa.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class RezervacijaDTO {

    private String imekorisnika;
    private String prezimekorisnika;
    private Long idkorisnika;
    private LocalDateTime pocetaktermina;
    private LocalDateTime krajtermina;
    private Long idadminakomp;
    private List<String> idopremesva;
    private List<String> naziviopremesvi;
    private Long idtermina;


    public String getImekorisnika() {
        return imekorisnika;
    }

    public void setImekorisnika(String imekorisnika) {
        this.imekorisnika = imekorisnika;
    }

    public String getPrezimekorisnika() {
        return prezimekorisnika;
    }

    public void setPrezimekorisnika(String prezimekorisnika) {
        this.prezimekorisnika = prezimekorisnika;
    }

    public LocalDateTime getPocetaktermina() {
        return pocetaktermina;
    }

    public void setPocetaktermina(LocalDateTime pocetaktermina) {
        this.pocetaktermina = pocetaktermina;
    }

    public LocalDateTime getKrajtermina() {
        return krajtermina;
    }

    public void setKrajtermina(LocalDateTime krajtermina) {
        this.krajtermina = krajtermina;
    }


    public Long getIdkorisnika() {
        return idkorisnika;
    }

    public void setIdkorisnika(Long idkorisnika) {
        this.idkorisnika = idkorisnika;
    }


    public Long getIdadminakomp() {
        return idadminakomp;
    }

    public void setIdadminakomp(Long idadminakomp) {
        this.idadminakomp = idadminakomp;
    }

//    public Long getIdopreme() {
//        return idopreme;
//    }
//
//    public void setIdopreme(Long idopreme) {
//        this.idopreme = idopreme;
//    }


    public RezervacijaDTO() {
    }


    public Long getIdtermina() {
        return idtermina;
    }

    public void setIdtermina(Long idtermina) {
        this.idtermina = idtermina;
    }

//    public List<Long> getIdterminasvi() {
//        return idterminasvi;
//    }
//
//    public void setIdterminasvi(List<Long> idterminasvi) {
//        this.idterminasvi = idterminasvi;
//    }


    public List<String> getIdopremesva() {
        return idopremesva;
    }

    public void setIdopremesva(List<String> idopremesva) {
        this.idopremesva = idopremesva;
    }

    public List<String> getNaziviopremesvi() {
        return naziviopremesvi;
    }

    public void setNaziviopremesvi(List<String> naziviopremesvi) {
        this.naziviopremesvi = naziviopremesvi;
    }
}
