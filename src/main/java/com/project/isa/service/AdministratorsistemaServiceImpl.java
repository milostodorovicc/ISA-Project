package com.project.isa.service;

import com.project.isa.entity.Administratorkompanije;
import com.project.isa.entity.Administratorsistema;
import com.project.isa.entity.Kompanija;
import com.project.isa.entity.Registrovanikorisnik;
import com.project.isa.repository.AdministratorkompanijeRepository;
import com.project.isa.repository.AdministratorsistemaRepository;
import com.project.isa.repository.KompanijaRepository;
import org.springframework.stereotype.Service;

@Service
public class AdministratorsistemaServiceImpl implements AdministratorsistemaService {


    private final KompanijaRepository kompanijaRepository;
    private final AdministratorkompanijeRepository administratorkompanijeRepository;
    private final AdministratorsistemaRepository administratorsistemaRepository;

    public AdministratorsistemaServiceImpl(KompanijaRepository kompanijaRepository, AdministratorkompanijeRepository administratorkompanijeRepository, AdministratorsistemaRepository administratorsistemaRepository) {
        this.kompanijaRepository = kompanijaRepository;
        this.administratorkompanijeRepository = administratorkompanijeRepository;
        this.administratorsistemaRepository = administratorsistemaRepository;
    }

    @Override
    public Kompanija create(Kompanija kompanija) {



        Kompanija novakompanija = this.kompanijaRepository.save(kompanija);
        return novakompanija;
    }
    @Override
    public Administratorkompanije createadminkompanije(Administratorkompanije adminkompanije) {



        Administratorkompanije noviadminkompanije = this.administratorkompanijeRepository.save(adminkompanije);
        return noviadminkompanije;
    }

    @Override
    public Administratorsistema createadminsistema(Administratorsistema adminsistema) {
        adminsistema.setLogincounter(0);


        Administratorsistema noviadminsistema = this.administratorsistemaRepository.save(adminsistema);
        return noviadminsistema;
    }
    @Override
    public Administratorsistema findadmin(Registrovanikorisnik regkorisnik) {
        Administratorsistema adminsistema = administratorsistemaRepository.findByEmailadresaAndLozinka(regkorisnik.getEmailadresa(),regkorisnik.getLozinka());
        return adminsistema;
    }


    @Override
    public Administratorsistema saveadminsistema(Administratorsistema adminsistema) {



        Administratorsistema noviadminsistema = this.administratorsistemaRepository.save(adminsistema);
        return noviadminsistema;
    }


    @Override
    public Administratorsistema findadminbyemail(String email) {
        Administratorsistema adminsistema = administratorsistemaRepository.findByEmailadresa(email);
        return adminsistema;
    }
}
