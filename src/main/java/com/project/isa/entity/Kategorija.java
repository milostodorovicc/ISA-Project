package com.project.isa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kategorija {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    int granica1;
    int granica2;
    int granica3;
    int granica4;

}
