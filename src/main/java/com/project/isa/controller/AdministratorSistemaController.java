package com.project.isa.controller;

import com.project.isa.entity.Administratorkompanije;
import com.project.isa.entity.AdministratorkompanijeDTO;
import com.project.isa.entity.Kompanija;
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
}
