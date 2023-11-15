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
    @Enumerated(EnumType.STRING)
    private Uloga uloga;
}
