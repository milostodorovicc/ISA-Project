package com.project.isa.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "rezervacija")
    private Termin termin;

    @ManyToMany
    @JoinTable(name = "rezervacijeoprema",
            joinColumns = @JoinColumn(name = "rezervacija_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "oprema_id", referencedColumnName = "id"))
    private Set<Oprema> oprema1 = new HashSet<>();


    @ManyToOne(fetch = FetchType.EAGER)
    private Registrovanikorisnik regkorisnik;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public Set<Oprema> getOprema1() {
        return oprema1;
    }

    public void setOprema1(Set<Oprema> oprema1) {
        this.oprema1 = oprema1;
    }

    public Registrovanikorisnik getRegkorisnik() {
        return regkorisnik;
    }

    public void setRegkorisnik(Registrovanikorisnik regkorisnik) {
        this.regkorisnik = regkorisnik;
    }
}
