package com.project.isa.controller;

import com.project.isa.entity.*;
import com.project.isa.service.AdministratorsistemaService;
import com.project.isa.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping(value = "/api/adminsistema")
public class AdministratorSistemaController {

    private final AdministratorsistemaService adminSistemaService;
    private final KorisnikService korisnikService;


    @Autowired
    public AdministratorSistemaController(AdministratorsistemaService adminSistemaService, KorisnikService korisnikService) {
        this.adminSistemaService = adminSistemaService;
        this.korisnikService = korisnikService;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, value = "/kompanija")
    public ResponseEntity<Kompanija> createKompanija(@RequestBody Kompanija kompanija) throws Exception {

        Kompanija novakompanija = adminSistemaService.create(kompanija);


        return new ResponseEntity<>(novakompanija, HttpStatus.CREATED);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, value = "/adminkompanija")
    public ResponseEntity<AdministratorkompanijeDTO> createAdministratorkompanije(@RequestBody Administratorkompanije adminkompanije, @RequestParam(value = "idkompanije") Long idkompanije) throws Exception {

        Kompanija kompanija = korisnikService.findOne(idkompanije);
        adminkompanije.setKompanija(kompanija);


        Administratorkompanije noviadminkompanije = adminSistemaService.createadminkompanije(adminkompanije);
        AdministratorkompanijeDTO noviadminkompanije1 = new AdministratorkompanijeDTO(noviadminkompanije.getEmailadresa(), noviadminkompanije.getLozinka(),noviadminkompanije.getIme(), noviadminkompanije.getPrezime(), noviadminkompanije.getGrad(), noviadminkompanije.getDrzava(), noviadminkompanije.getBrojtelefona(), noviadminkompanije.getZanimanje(), noviadminkompanije.getInfoopred());

        return new ResponseEntity<>(noviadminkompanije1, HttpStatus.CREATED);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, value = "/adminsistema1")
    public ResponseEntity<AdministratorsistemaDTO> createAdministratorsistema(@RequestBody Administratorsistema adminsistema) throws Exception {


        adminsistema.setLogincounter(0);
        Administratorsistema noviadminsistema = adminSistemaService.createadminsistema(adminsistema);
        AdministratorsistemaDTO noviadminsistema1 = new AdministratorsistemaDTO(noviadminsistema.getEmailadresa(), noviadminsistema.getLozinka(),noviadminsistema.getIme(), noviadminsistema.getPrezime(), noviadminsistema.getGrad(), noviadminsistema.getDrzava(), noviadminsistema.getBrojtelefona(), noviadminsistema.getZanimanje(), noviadminsistema.getInfoopred());

        return new ResponseEntity<>(noviadminsistema1, HttpStatus.CREATED);
    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE, value = "/promenalozinke")
    public ResponseEntity<AdministratorsistemaDTO> promenalozinkeadminasistema(String email, String lozinka, String potvrdalozinka) throws Exception {

        AdministratorsistemaDTO noviadmin1 = new AdministratorsistemaDTO();
        if (!lozinka.equals(potvrdalozinka)){
            throw new Exception("Niste uneli jednake lozinke!");

        }

        else{

            Administratorsistema noviadminsistema = adminSistemaService.findadminbyemail(email);
            noviadminsistema.setLozinka(lozinka);
            noviadminsistema.setLogincounter(1);
            Administratorsistema noviadminsistema1 = adminSistemaService.saveadminsistema(noviadminsistema);
            noviadmin1.setDrzava(noviadminsistema1.getDrzava());
            noviadmin1.setBrojtelefona(noviadminsistema1.getBrojtelefona());
            noviadmin1.setEmailadresa(noviadminsistema1.getEmailadresa());
            noviadmin1.setGrad(noviadminsistema1.getGrad());
            noviadmin1.setIme(noviadminsistema1.getIme());
            noviadmin1.setInfoopred(noviadminsistema1.getInfoopred());
            noviadmin1.setPrezime(noviadminsistema1.getPrezime());
            noviadmin1.setZanimanje(noviadminsistema1.getZanimanje());
            noviadmin1.setLozinka(noviadminsistema1.getLozinka());

        }



        return new ResponseEntity<>(noviadmin1, HttpStatus.CREATED);
    }


    @GetMapping(value = "/{zalbe}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<ZalbaDTO>> svezalbe() throws Exception {

        Set<ZalbaDTO> svezalbe = adminSistemaService.findzalbe();


        return new ResponseEntity<>(svezalbe, HttpStatus.OK);
    }


    @GetMapping(value = "/svitermini", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> svitermini(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime start,
                                                      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime end) throws Exception {

        List<TerminDTO> svitermini12 = new ArrayList<>();
        List<Termin> svitermini1 = this.adminSistemaService.sviterminiizmedjudatuma(start,end);
        for(Termin termin2: svitermini1){
            TerminDTO termin23 = new TerminDTO(termin2.getRegkorisnik().getIme(),termin2.getRegkorisnik().getPrezime(),termin2.getStartTime(),termin2.getEndTime());
            svitermini12.add(termin23);
        }

        return new ResponseEntity<>(svitermini12, HttpStatus.OK);

    }

}
