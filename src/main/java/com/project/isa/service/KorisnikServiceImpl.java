package com.project.isa.service;

import com.project.isa.entity.Kompanija;
import com.project.isa.entity.Oprema;
import com.project.isa.repository.KompanijaRepository;
import com.project.isa.repository.OpremaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KorisnikServiceImpl implements KorisnikService{


    private final OpremaRepository opremaRepository;
    private final KompanijaRepository kompanijaRepository;

    public KorisnikServiceImpl(OpremaRepository opremaRepository, KompanijaRepository kompanijaRepository) {

        this.kompanijaRepository = kompanijaRepository;
        this.opremaRepository = opremaRepository;
    }

    @Override
    public List<Oprema> svaoprema() throws Exception{


        List<Oprema> svaoprema1 = this.opremaRepository.findAll();


        return svaoprema1;

    }


    @Override
    public Kompanija findOne(Long id) {
        Kompanija kompanija = this.kompanijaRepository.pronadjipoid(id);
        return kompanija;
    }

}
