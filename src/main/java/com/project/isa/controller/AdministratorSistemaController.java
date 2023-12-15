package com.project.isa.controller;

import com.project.isa.entity.*;
import com.project.isa.service.AdministratorsistemaService;
import com.project.isa.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
}
