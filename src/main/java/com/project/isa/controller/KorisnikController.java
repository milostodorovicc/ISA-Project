package com.project.isa.controller;

import com.project.isa.entity.Kompanija;
import com.project.isa.entity.KompanijaDTO;
import com.project.isa.entity.Oprema;
import com.project.isa.entity.OpremaDTO;
import com.project.isa.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    public ResponseEntity<List<OpremaDTO>> svaoprema() throws Exception {

        List<OpremaDTO> svaoprema1 = new ArrayList<>();
        List<Oprema> svaoprema = this.korisnikService.svaoprema();
        for(Oprema oprema: svaoprema){
            OpremaDTO oprema1 = new OpremaDTO(oprema.getId(),oprema.getNaziv(),oprema.getTip(),oprema.getOpis(),oprema.getOcena());
            svaoprema1.add(oprema1);
        }

        return new ResponseEntity<>(svaoprema1, HttpStatus.OK);

    }

    @GetMapping(value = "/kompanija", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KompanijaDTO>> oprema(@RequestParam(value = "opremaid") Long idopreme) throws Exception {
        List<KompanijaDTO> kompanije1 = new ArrayList<>();


        List<Kompanija> kompanijesatomopremom = this.korisnikService.kompanijesaidopremom(idopreme);
           for(Kompanija kompanija: kompanijesatomopremom){
               KompanijaDTO komp1 = new KompanijaDTO(kompanija.getNaziv(),kompanija.getAdresa(),kompanija.getOpis(),kompanija.getProsecnaocena());
               kompanije1.add(komp1);
           }

        return new ResponseEntity<>(kompanije1, HttpStatus.OK);

    }



    @GetMapping(value = "/opremaponazivu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OpremaDTO>> svaoprema(@RequestParam(value = "oprema") String oprema) throws Exception {

        List<OpremaDTO> svaoprema1 = new ArrayList<>();
        List<Oprema> svaoprema = this.korisnikService.svaopremaponazivu(oprema);
        for(Oprema oprema2: svaoprema){
            OpremaDTO oprema1 = new OpremaDTO(oprema2.getId(),oprema2.getNaziv(),oprema2.getTip(),oprema2.getOpis(),oprema2.getOcena());
            svaoprema1.add(oprema1);
        }

        return new ResponseEntity<>(svaoprema1, HttpStatus.OK);

    }

    @GetMapping(value = "/opremapotipu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OpremaDTO>> svaopremapotipu(@RequestParam(value = "tipopreme") String tipopreme) throws Exception {

        List<OpremaDTO> svaoprema1 = new ArrayList<>();
        List<Oprema> svaoprema = this.korisnikService.svaopremapotipu(tipopreme);
        for(Oprema oprema2: svaoprema){
            OpremaDTO oprema1 = new OpremaDTO(oprema2.getId(),oprema2.getNaziv(),oprema2.getTip(),oprema2.getOpis(),oprema2.getOcena());
            svaoprema1.add(oprema1);
        }

        return new ResponseEntity<>(svaoprema1, HttpStatus.OK);

    }


    @GetMapping(value = "/opremapominoceni", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OpremaDTO>> svaopremapominoceni(@RequestParam(value = "ocenaopreme") Long minocena) throws Exception {

        List<OpremaDTO> svaoprema1 = new ArrayList<>();
        List<Oprema> svaoprema = this.korisnikService.svaopremapominoceni(minocena);
        for(Oprema oprema2: svaoprema){
            OpremaDTO oprema1 = new OpremaDTO(oprema2.getId(),oprema2.getNaziv(),oprema2.getTip(),oprema2.getOpis(),oprema2.getOcena());
            svaoprema1.add(oprema1);
        }

        return new ResponseEntity<>(svaoprema1, HttpStatus.OK);

    }





    @GetMapping(value = "/kombinovanapretraga", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OpremaDTO>> kombinovanapretraga(@RequestParam(value = "nazivopreme") String nazivopreme,@RequestParam(value = "filtpotipu") String filtpotipu, @RequestParam(value = "filtpooceni") String filtpooceni) throws Exception {

        List<OpremaDTO> svaoprema1 = new ArrayList<>();
        List<Oprema> svaoprema = this.korisnikService.kombinovanapretraga(nazivopreme, filtpotipu, filtpooceni);
        for(Oprema oprema2: svaoprema){
            OpremaDTO oprema1 = new OpremaDTO(oprema2.getId(),oprema2.getNaziv(),oprema2.getTip(),oprema2.getOpis(),oprema2.getOcena());
            svaoprema1.add(oprema1);
        }

        return new ResponseEntity<>(svaoprema1, HttpStatus.OK);

    }






}
