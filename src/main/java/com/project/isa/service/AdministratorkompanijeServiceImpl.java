package com.project.isa.service;

import com.project.isa.entity.*;
import com.project.isa.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdministratorkompanijeServiceImpl implements AdministratorkompanijeService{


    private final KompanijaRepository kompanijaRepository;
    private final AdministratorkompanijeRepository administratorkompanijeRepository;
    private final AdministratorsistemaRepository administratorsistemaRepository;
    private final ZalbaRepository zalbaRepository;
    private final TerminRepository terminRepository;
    private final RegistrovanikorisnikRepository registrovanikorisnikRepository;
    private final RezervacijaRepository rezervacijaRepository;
    private final OpremaRepository opremaRepository;

    public AdministratorkompanijeServiceImpl(KompanijaRepository kompanijaRepository, AdministratorkompanijeRepository administratorkompanijeRepository, AdministratorsistemaRepository administratorsistemaRepository, ZalbaRepository zalbaRepository, TerminRepository terminRepository,RegistrovanikorisnikRepository registrovanikorisnikRepository,RezervacijaRepository rezervacijaRepository,OpremaRepository opremaRepository) {
        this.kompanijaRepository = kompanijaRepository;
        this.administratorkompanijeRepository = administratorkompanijeRepository;
        this.administratorsistemaRepository = administratorsistemaRepository;
        this.zalbaRepository = zalbaRepository;
        this.terminRepository = terminRepository;
        this.registrovanikorisnikRepository = registrovanikorisnikRepository;
        this.rezervacijaRepository = rezervacijaRepository;
        this.opremaRepository = opremaRepository;
    }


    @Override
    public RezervacijaDTO findrezervacija(String id,String idopreme) {
        Long idrezervacije = Long.parseLong(id);
        Rezervacija rezervacija1 = rezervacijaRepository.pronadjipoid(idrezervacije);
        List<Termin> termini = terminRepository.findAll();
        Termin termin2 = new Termin();
        RezervacijaDTO rez1 = new RezervacijaDTO();
        for (Termin termin : termini) {
            if (termin.getRezervacija().getId() == idrezervacije) {
                termin2.setStartTime(termin.getStartTime());
                termin2.setEndTime(termin.getEndTime());
                termin2.setId(termin.getId());

            }
        }

//        List<Long> idopreme2 = new ArrayList<>();
//        for (String id1 : idopreme) {
//            Long idopreme3 = Long.parseLong(id1);
//            idopreme2.add(idopreme3);
//        }
        Long idopreme1 = Long.parseLong(idopreme);

        rez1.setPocetaktermina(termin2.getStartTime());
        rez1.setKrajtermina(termin2.getEndTime());
        rez1.setIdkorisnika(rezervacija1.getRegkorisnik().getId());
        rez1.setImekorisnika(rezervacija1.getRegkorisnik().getIme());
        rez1.setPrezimekorisnika(rezervacija1.getRegkorisnik().getPrezime());
        rez1.setIdopreme(idopreme1);
        rez1.setIdtermina(termin2.getId());

        return rez1;


    }






    @Override
    public String obrisiopremu(Long idopreme) {
//        List<Oprema> svaoprema = opremaRepository.findAll();
//        List<Oprema> svaoprema1 = new ArrayList<>();
//        for(Oprema oprema: svaoprema){
//            for(Long idopreme1: idopreme){
//                if(oprema.getId() == idopreme1){
//                    oprema.setKolicina(oprema.getKolicina()-1);
//                    opremaRepository.save(oprema);
//
//                }
//            }
//
//        }
        Oprema oprema5 = opremaRepository.pronadjipoid(idopreme);
        opremaRepository.save(oprema5);



        return "Uspesno ste obrisali opremu!";
    }




    @Override
    public RezervacijaDTO findrezervacija1(Long opremaid,Long korisnikid,Long terminid) {
        RezervacijaDTO rezervacija4 = new RezervacijaDTO();
        Registrovanikorisnik regkor = registrovanikorisnikRepository.pronadjipoid(korisnikid);
        Termin termin = terminRepository.pronadjipoid(terminid);
        rezervacija4.setPocetaktermina(termin.getStartTime());
        rezervacija4.setKrajtermina(termin.getEndTime());
        rezervacija4.setImekorisnika(regkor.getIme());
        rezervacija4.setPrezimekorisnika(regkor.getPrezime());
        rezervacija4.setIdopreme(opremaid);

        return rezervacija4;

    }


}
