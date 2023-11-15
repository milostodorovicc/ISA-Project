package com.project.isa.entity;
import jakarta.persistence.*;
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
    private Date datumivreme;
    @Column
    private Long trajanjeuh;
}
