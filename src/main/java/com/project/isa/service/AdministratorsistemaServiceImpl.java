package com.project.isa.service;

import com.project.isa.entity.*;
import com.project.isa.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdministratorsistemaServiceImpl implements AdministratorsistemaService {


    private final KompanijaRepository kompanijaRepository;
    private final AdministratorkompanijeRepository administratorkompanijeRepository;
    private final AdministratorsistemaRepository administratorsistemaRepository;
    private final ZalbaRepository zalbaRepository;
    private final TerminRepository terminRepository;
    private final RegistrovanikorisnikRepository registrovanikorisnikRepository;

    public AdministratorsistemaServiceImpl(KompanijaRepository kompanijaRepository, AdministratorkompanijeRepository administratorkompanijeRepository, AdministratorsistemaRepository administratorsistemaRepository, ZalbaRepository zalbaRepository, TerminRepository terminRepository,RegistrovanikorisnikRepository registrovanikorisnikRepository) {
        this.kompanijaRepository = kompanijaRepository;
        this.administratorkompanijeRepository = administratorkompanijeRepository;
        this.administratorsistemaRepository = administratorsistemaRepository;
        this.zalbaRepository = zalbaRepository;
        this.terminRepository = terminRepository;
        this.registrovanikorisnikRepository = registrovanikorisnikRepository;
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

    @Override
    public Set<ZalbaDTO> findzalbe() {
        Set<ZalbaDTO> zalbe1 = new HashSet<ZalbaDTO>();
        List<Zalba> svezalbe = zalbaRepository.findAll();
        for(Zalba zalba: svezalbe){
            ZalbaDTO zalba1 = new ZalbaDTO();
            zalba1.setEmailkorisnika(zalba.getRegkorisnik1().getEmailadresa());
            zalba1.setTekstzalbe(zalba.getTekstzalbe());
            zalba1.setIdsender(zalba.getRegkorisnik1().getId());
            zalbe1.add(zalba1);
        }
        return zalbe1;
    }

    public List<Termin> sviterminiizmedjudatuma(LocalDateTime start, LocalDateTime end){
        List<Termin> terminiizmedju = terminRepository.terminiizmedjudatuma(start,end);
        return terminiizmedju;
    }

    @Override
    public Registrovanikorisnik findOne(Long l) {
        Registrovanikorisnik sender = this.registrovanikorisnikRepository.pronadjipoid(l);
        return sender;
    }
}
