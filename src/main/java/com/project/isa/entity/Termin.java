package com.project.isa.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

//    @ManyToOne(fetch = FetchType.EAGER)
//    private Registrovanikorisnik regkorisnik;

    @ManyToOne(fetch = FetchType.EAGER)
    private Administratorkompanije administratorkompanije;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rezervacija_id", referencedColumnName = "id")
    private Rezervacija rezervacija;

//    @ManyToMany
//    @JoinTable(name = "terminioprema",
//            joinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "oprema_id", referencedColumnName = "id"))
//    private Set<Oprema> oprema1 = new HashSet<>();

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


    public Termin() {
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public Administratorkompanije getAdministratorkompanije() {
        return administratorkompanije;
    }

    public void setAdministratorkompanije(Administratorkompanije administratorkompanije) {
        this.administratorkompanije = administratorkompanije;
    }

//    public Termin(Long id, String imeadministratora, String prezimeadministratora, LocalDateTime startTime, LocalDateTime endTime, Registrovanikorisnik regkorisnik) {
//        this.id = id;
//        this.imeadministratora = imeadministratora;
//        this.prezimeadministratora = prezimeadministratora;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.regkorisnik = regkorisnik;
//    }


    public Termin(Long id, String imeadministratora, String prezimeadministratora, LocalDateTime startTime, LocalDateTime endTime, Registrovanikorisnik regkorisnik, Administratorkompanije administratorkompanije) {
        this.id = id;
        this.imeadministratora = imeadministratora;
        this.prezimeadministratora = prezimeadministratora;
        this.startTime = startTime;
        this.endTime = endTime;
        this.administratorkompanije = administratorkompanije;
    }


}
