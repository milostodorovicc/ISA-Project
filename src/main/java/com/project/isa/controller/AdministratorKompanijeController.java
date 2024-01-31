package com.project.isa.controller;


import com.project.isa.entity.*;
import com.project.isa.service.AdministratorkompanijeService;
import com.project.isa.service.AdministratorsistemaService;
import com.project.isa.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/adminkompanije")
public class AdministratorKompanijeController {


    private final AdministratorkompanijeService adminKompanijeService;



    @Autowired
    public AdministratorKompanijeController(AdministratorkompanijeService adminKompanijeService) {
        this.adminKompanijeService = adminKompanijeService;

    }


//    @GetMapping(value = "/{termini}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Set<RezervacijaDTO>> svitermini(@RequestParam(value = "id") Long id) throws Exception {
//
//        Set<RezervacijaDTO> svitermini = adminKompanijeService.findtermini(id);
//
//
//        return new ResponseEntity<>(svitermini, HttpStatus.OK);
//    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, value = "/obrisiopremu")
    public ResponseEntity<String> obrisiopremu( @RequestParam(value = "opremaid") Long idopreme) throws Exception {

        String obrisanaoprema = adminKompanijeService.obrisiopremu(idopreme);


        return new ResponseEntity<>(obrisanaoprema, HttpStatus.CREATED);
    }





    @GetMapping(value = "/{rezervacija}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RezervacijaDTO> rezervacija(@RequestParam(value = "opremaid") Long opremaid,@RequestParam(value = "korisnikid") Long korisnikid,@RequestParam(value = "terminid") Long terminid) throws Exception {

        RezervacijaDTO rez2 = adminKompanijeService.findrezervacija1(opremaid,korisnikid,terminid);


        return new ResponseEntity<>(rez2, HttpStatus.OK);
    }
}
