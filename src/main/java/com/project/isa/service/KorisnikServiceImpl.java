package com.project.isa.service;

import com.project.isa.entity.*;
import com.project.isa.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class KorisnikServiceImpl implements KorisnikService{


    private final OpremaRepository opremaRepository;
    private final KompanijaRepository kompanijaRepository;
    private final RegistrovanikorisnikRepository regkorisnikRepository;
    private final AdministratorsistemaRepository adminsistemaRepository;
    private final AdministratorkompanijeRepository adminkompanijeRepository;


    public KorisnikServiceImpl(OpremaRepository opremaRepository, KompanijaRepository kompanijaRepository, RegistrovanikorisnikRepository regkorisnikRepository, AdministratorsistemaRepository adminsistemaRepository, AdministratorkompanijeRepository adminkompanijeRepository) {

        this.kompanijaRepository = kompanijaRepository;
        this.opremaRepository = opremaRepository;
        this.regkorisnikRepository = regkorisnikRepository;
        this.adminsistemaRepository = adminsistemaRepository;
        this.adminkompanijeRepository = adminkompanijeRepository;
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

    @Override
    public List<Kompanija> kompanijesaidopremom(Long id) {

        List<Kompanija> kompanijesatomopremom = new ArrayList<>();

        List<Kompanija> svekompanije = this.kompanijaRepository.findAll();
        for(Kompanija kompanija: svekompanije){
           Set<Oprema> opremaizkomp =  kompanija.getOprema();
            for(Oprema oprema: opremaizkomp) {
                if(oprema.getId()==id){
                    kompanijesatomopremom.add(kompanija);
                }

            }
            }
         return kompanijesatomopremom;
    }




    @Override
    public List<Oprema> svaopremaponazivu(String oprema) throws Exception{


        List<Oprema> svaoprema1 = this.opremaRepository.findByNaziv(oprema);


        return svaoprema1;

    }



    @Override
    public List<Oprema> svaopremapotipu(String tipopreme) throws Exception{


        List<Oprema> svaoprema1 = this.opremaRepository.findByTip(tipopreme);


        return svaoprema1;

    }

    @Override
    public List<Oprema> svaopremapominoceni(Long minocena) throws Exception{


        List<Oprema> svaoprema1 = this.opremaRepository.findByOcenaGreaterThanEqual(minocena);


        return svaoprema1;

    }

    @Override
    public List<Oprema> kombinovanapretraga(String nazivopreme, String filtpotipu, String filtpooceni) throws Exception{
        if(nazivopreme.isEmpty()&filtpotipu.isEmpty() || nazivopreme.isEmpty()&filtpooceni.isEmpty() || filtpotipu.isEmpty()&filtpooceni.isEmpty() || nazivopreme.isEmpty()&filtpotipu.isEmpty()&filtpooceni.isEmpty()){
            throw new Exception("Nije kombinovana pretraga");
        }
        List<Oprema> svaoprema1 = new ArrayList<>();
//        String ocena = filtpooceni.toString();
        if(nazivopreme.isEmpty()){
              Long filtpooceni1 = Long.parseLong(filtpooceni);
              svaoprema1 = opremaRepository.findByTipAndOcenaGreaterThanEqual(filtpotipu,filtpooceni1);

        }

        if(filtpotipu.isEmpty()){
             Long filtpooceni1 = Long.parseLong(filtpooceni);
             svaoprema1 = this.opremaRepository.findByNazivAndOcenaGreaterThanEqual(nazivopreme,filtpooceni1);
        }

        if(filtpooceni.isEmpty()){
             svaoprema1 = this.opremaRepository.findByNazivAndTip(nazivopreme,filtpotipu);
        }
        if(!nazivopreme.isEmpty() & !filtpotipu.isEmpty() & !filtpooceni.isEmpty()){
            Long filtpooceni1 = Long.parseLong(filtpooceni);
            svaoprema1 = this.opremaRepository.findByNazivAndTipAndOcenaGreaterThanEqual(nazivopreme,filtpotipu,filtpooceni1);
        }




        return svaoprema1;

    }




    @Override
    public LoginDTO proveri(String email, String lozinka) throws Exception{
        LoginDTO loginDTO2 = new LoginDTO();
        Registrovanikorisnik regkorisnik = regkorisnikRepository.findByEmailadresaAndLozinka(email, lozinka);
        if(regkorisnik!= null){
            loginDTO2.setEmailadresa(regkorisnik.getEmailadresa());
            loginDTO2.setLozinka(regkorisnik.getLozinka());
        }
        Administratorsistema adminsistema = adminsistemaRepository.findByEmailadresaAndLozinka(email, lozinka);
        if(adminsistema!= null){
            loginDTO2.setLozinka(adminsistema.getLozinka());
            loginDTO2.setLozinka(adminsistema.getLozinka());
        }
        Administratorkompanije adminkompanije = adminkompanijeRepository.findByEmailadresaAndLozinka(email, lozinka);
        if(adminkompanije!=null){
            loginDTO2.setEmailadresa(adminkompanije.getEmailadresa());
            loginDTO2.setLozinka(adminkompanije.getLozinka());
        }
        if(loginDTO2.getEmailadresa()==null & loginDTO2.getLozinka()==null){
            throw new Exception("Niste uneli tacno korisnicko ime ili lozinku!");
        }
        return loginDTO2;

    }
}
