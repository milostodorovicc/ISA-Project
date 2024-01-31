package com.project.isa.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class TerminDTO {
    private String imekorisnikarez;
    private String prezimekorisnikarez;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Set<Oprema> oprema;
    private Long idkorisnika;

    public String getImekorisnikarez() {
        return imekorisnikarez;
    }

    public void setImekorisnikarez(String imekorisnikarez) {
        this.imekorisnikarez = imekorisnikarez;
    }

    public String getPrezimekorisnikarez() {
        return prezimekorisnikarez;
    }

    public void setPrezimekorisnikarez(String prezimekorisnikarez) {
        this.prezimekorisnikarez = prezimekorisnikarez;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }



    public TerminDTO() {
    }

    public TerminDTO(String imekorisnikarez, String prezimekorisnikarez, LocalDateTime startTime, LocalDateTime endTime) {
        this.imekorisnikarez = imekorisnikarez;
        this.prezimekorisnikarez = prezimekorisnikarez;
        this.startTime = startTime;
        this.endTime = endTime;
    }


//    public TerminDTO(String imekorisnikarez, String prezimekorisnikarez, LocalDateTime startTime, LocalDateTime endTime, Set<Oprema> oprema, Long idkorisnika) {
//        this.imekorisnikarez = imekorisnikarez;
//        this.prezimekorisnikarez = prezimekorisnikarez;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.oprema = oprema;
//        this.idkorisnika = idkorisnika;
//    }

    public Long getIdkorisnika() {
        return idkorisnika;
    }

    public void setIdkorisnika(Long idkorisnika) {
        this.idkorisnika = idkorisnika;
    }

    public Set<Oprema> getOprema() {
        return oprema;
    }

    public void setOprema(Set<Oprema> oprema) {
        this.oprema = oprema;
    }
}
