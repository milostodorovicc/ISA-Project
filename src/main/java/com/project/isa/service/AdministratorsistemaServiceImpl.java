package com.project.isa.service;

import com.project.isa.entity.Administratorkompanije;
import com.project.isa.entity.Kompanija;
import com.project.isa.repository.AdministratorkompanijeRepository;
import com.project.isa.repository.KompanijaRepository;
import org.springframework.stereotype.Service;

@Service
public class AdministratorsistemaServiceImpl implements AdministratorsistemaService {


    private final KompanijaRepository kompanijaRepository;
    private final AdministratorkompanijeRepository administratorkompanijeRepository;

    public AdministratorsistemaServiceImpl(KompanijaRepository kompanijaRepository, AdministratorkompanijeRepository administratorkompanijeRepository) {
        this.kompanijaRepository = kompanijaRepository;
        this.administratorkompanijeRepository = administratorkompanijeRepository;
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
}
