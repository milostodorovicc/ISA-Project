package com.project.isa.entity;

import jakarta.persistence.*;
@Entity
public class Zalba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String tekstzalbe;
    @ManyToOne(fetch = FetchType.EAGER)
    private Registrovanikorisnik regkorisnik1;


    public Zalba(Long id, String tekstzalbe) {
        this.id = id;
        this.tekstzalbe = tekstzalbe;
    }

    public Zalba() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTekstzalbe() {
        return tekstzalbe;
    }

    public void setTekstzalbe(String tekstzalbe) {
        this.tekstzalbe = tekstzalbe;
    }

    public Registrovanikorisnik getRegkorisnik1() {
        return regkorisnik1;
    }

    public void setRegkorisnik1(Registrovanikorisnik regkorisnik1) {
        this.regkorisnik1 = regkorisnik1;
    }
}
