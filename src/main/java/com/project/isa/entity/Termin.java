package com.project.isa.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String imeadministratora;
    @Column
    private String prezimeadministratora;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    @ManyToOne(fetch = FetchType.EAGER)
    private Registrovanikorisnik regkorisnik;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImeadministratora() {
        return imeadministratora;
    }

    public void setImeadministratora(String imeadministratora) {
        this.imeadministratora = imeadministratora;
    }

    public String getPrezimeadministratora() {
        return prezimeadministratora;
    }

    public void setPrezimeadministratora(String prezimeadministratora) {
        this.prezimeadministratora = prezimeadministratora;
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

    public Registrovanikorisnik getRegkorisnik() {
        return regkorisnik;
    }

    public void setRegkorisnik(Registrovanikorisnik regkorisnik) {
        this.regkorisnik = regkorisnik;
    }

    public Termin() {
    }

    public Termin(Long id, String imeadministratora, String prezimeadministratora, LocalDateTime startTime, LocalDateTime endTime, Registrovanikorisnik regkorisnik) {
        this.id = id;
        this.imeadministratora = imeadministratora;
        this.prezimeadministratora = prezimeadministratora;
        this.startTime = startTime;
        this.endTime = endTime;
        this.regkorisnik = regkorisnik;
    }
}
