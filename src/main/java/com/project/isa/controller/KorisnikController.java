package com.project.isa.controller;

import com.project.isa.entity.Oprema;
import com.project.isa.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(value = "/api/korisnik")
public class KorisnikController {


    private final KorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    @GetMapping(value = "/svaoprema", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Oprema>> svaoprema() throws Exception {


        List<Oprema> svaoprema = this.korisnikService.svaoprema();


        return new ResponseEntity<>(svaoprema, HttpStatus.OK);

    }
}
