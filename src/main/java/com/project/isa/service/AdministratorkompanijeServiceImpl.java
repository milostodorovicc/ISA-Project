package com.project.isa.service;

import com.project.isa.entity.*;
import com.project.isa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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



    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;


    @Override
    public RezervacijaDTO findrezervacija(String id,List<String> idopremesvi) throws Exception{
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
        //List<Long> idopremesvi = rezervacija1.getOprema1();
        List<String> svaoprema = new ArrayList<>();

        for(String idopreme3:idopremesvi)
        {
            svaoprema.add(idopreme3);
        }
//        Long idopreme1 = Long.parseLong(idopreme);

        rez1.setPocetaktermina(termin2.getStartTime());
        rez1.setKrajtermina(termin2.getEndTime());
        rez1.setIdkorisnika(rezervacija1.getRegkorisnik().getId());
        rez1.setImekorisnika(rezervacija1.getRegkorisnik().getIme());
        rez1.setPrezimekorisnika(rezervacija1.getRegkorisnik().getPrezime());
        rez1.setIdopremesva(svaoprema);
        rez1.setIdtermina(termin2.getId());

        Registrovanikorisnik regkorisnik = this.registrovanikorisnikRepository.pronadjipoid(rezervacija1.getRegkorisnik().getId());

        if(rez1.getPocetaktermina().isBefore(LocalDateTime.now()))
        {
            regkorisnik.setBrojpenala(regkorisnik.getBrojpenala()+2);
            this.registrovanikorisnikRepository.save(regkorisnik);
            throw new Exception("Zakasnili ste na termin dodeljena su vam 2 penala!");
        }

        return rez1;


    }






    @Override
    public List<OpremaDTO> obrisiopremu(String idopreme, Long idkorisnik) {
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


        String[] parts = idopreme.split(",");
        int a = 0;
        List<OpremaDTO> svaopremaDTO = new ArrayList<OpremaDTO>();
        while (a<parts.length)
        {
            Long l = Long.parseLong(parts[a]);
            Oprema oprema2 = this.opremaRepository.pronadjipoid(l);
            oprema2.setKolicina(oprema2.getKolicina()-1);
            System.out.println(parts[a]);
            a++;
            Oprema oprema5 = opremaRepository.save(oprema2);
            OpremaDTO opremadto = new OpremaDTO();
            opremadto.setId(oprema5.getId());
            opremadto.setNaziv(oprema5.getNaziv());
            opremadto.setOcena(oprema5.getOcena());
            opremadto.setOpis(oprema5.getOpis());
            opremadto.setTip(oprema5.getTip());
            svaopremaDTO.add(opremadto);
        }
//        Oprema oprema5 = opremaRepository.pronadjipoid(idopreme);
//        oprema5.setKolicina(oprema5.getKolicina()-1);
        SimpleMailMessage message = new SimpleMailMessage();
        Registrovanikorisnik regkorisnik1 = this.registrovanikorisnikRepository.pronadjipoid(idkorisnik);

            message.setTo(regkorisnik1.getEmailadresa());
            message.setSubject("abc");
            message.setText("abc");
            message.setFrom(env.getProperty("spring.mail.username"));


            javaMailSender.send(message);

//        opremaRepository.save(oprema5);
//        OpremaDTO opremadto = new OpremaDTO();
//        opremadto.setId(oprema5.getId());
//        opremadto.setNaziv(oprema5.getNaziv());
//        opremadto.setOcena(oprema5.getOcena());
//        opremadto.setOpis(oprema5.getOpis());
//        opremadto.setTip(oprema5.getTip());


        return svaopremaDTO;
    }




    @Override
    public RezervacijaDTO findrezervacija1(String opremaid,Long korisnikid,Long terminid) {
        List<String> svaopremaid = new ArrayList<>();
        List<String> naziviopremesvi = new ArrayList<>();
        String[] parts = opremaid.split(",");
        int a = 0;
        while (a<parts.length)
        {
            Long l = Long.parseLong(parts[a]);
            Oprema oprema2 = this.opremaRepository.pronadjipoid(l);
            naziviopremesvi.add(oprema2.getNaziv());
            svaopremaid.add(parts[a]);
            System.out.println(parts[a]);
            a++;
        }





        RezervacijaDTO rezervacija4 = new RezervacijaDTO();
        Registrovanikorisnik regkor = registrovanikorisnikRepository.pronadjipoid(korisnikid);
        Termin termin = terminRepository.pronadjipoid(terminid);
        rezervacija4.setPocetaktermina(termin.getStartTime());
        rezervacija4.setKrajtermina(termin.getEndTime());
        rezervacija4.setImekorisnika(regkor.getIme());
        rezervacija4.setPrezimekorisnika(regkor.getPrezime());
        rezervacija4.setIdopremesva(svaopremaid);
        rezervacija4.setNaziviopremesvi(naziviopremesvi);

        return rezervacija4;

    }


}
