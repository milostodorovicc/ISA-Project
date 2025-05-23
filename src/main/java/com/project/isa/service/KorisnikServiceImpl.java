package com.project.isa.service;

import com.project.isa.entity.*;
import com.project.isa.repository.*;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
            loginDTO2.setId(regkorisnik.getId());
            loginDTO2.setUloga(regkorisnik.getUloga());
            loginDTO2.setEmailadresa(regkorisnik.getEmailadresa());
            loginDTO2.setLozinka(regkorisnik.getLozinka());
        }
        Administratorsistema adminsistema = adminsistemaRepository.findByEmailadresaAndLozinka(email, lozinka);
        if(adminsistema!= null){
            loginDTO2.setId(adminsistema.getId());
            loginDTO2.setUloga(adminsistema.getUloga());
            loginDTO2.setEmailadresa(adminsistema.getEmailadresa());
            loginDTO2.setLozinka(adminsistema.getLozinka());
            loginDTO2.setLogcounter(adminsistema.getLogincounter());
        }
        Administratorkompanije adminkompanije = adminkompanijeRepository.findByEmailadresaAndLozinka(email, lozinka);
        if(adminkompanije!=null){
            loginDTO2.setId(adminkompanije.getId());
            loginDTO2.setUloga(adminkompanije.getUloga());
            loginDTO2.setEmailadresa(adminkompanije.getEmailadresa());
            loginDTO2.setLozinka(adminkompanije.getLozinka());
        }
        if(loginDTO2.getEmailadresa()==null & loginDTO2.getLozinka()==null){
            throw new Exception("Niste uneli tacno korisnicko ime ili lozinku!");
        }
        return loginDTO2;

    }





    @Override
    public String definisikategorije(String granica1, String granica2, String granica3, String granica4, String brojpoena) throws Exception{



        String[] stringsToSave = {granica1, granica2, granica3, granica4, brojpoena};

        // Specify the file path
        String filePath = "output.txt";

        // Create an instance of the repository
//        KategorijeRepository repository = new KategorijeRepository(filePath);

        // Save the strings using the repository
//        repository.saveStringsToFile(stringsToSave);


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String str : stringsToSave) {

                writer.write(str+";");

            }
            System.out.println("Stringovi sacuvani uspesno");
        } catch (IOException e) {
            System.err.println("Greska pri pisanju u datoteku!: " + e.getMessage());
        }



        return "Uspesno ste definisali kategorije!";

    }
}
