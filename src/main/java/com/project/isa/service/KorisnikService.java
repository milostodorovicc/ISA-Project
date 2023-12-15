package com.project.isa.service;

import com.project.isa.entity.Kompanija;
import com.project.isa.entity.LoginDTO;
import com.project.isa.entity.Oprema;

import java.util.List;

public interface KorisnikService {

    List<Oprema> svaoprema() throws Exception;
    Kompanija findOne(Long id);
    List<Kompanija> kompanijesaidopremom(Long id);
    List<Oprema> svaopremaponazivu(String oprema) throws Exception;
    List<Oprema> svaopremapotipu(String tipopreme) throws Exception;
    List<Oprema> svaopremapominoceni(Long minocena) throws Exception;
    List<Oprema> kombinovanapretraga(String nazivopreme, String filtpotipu,String filtpooceni) throws Exception;
    LoginDTO proveri(String email, String lozinka) throws Exception;

}
