package com.project.isa.service;

import com.project.isa.entity.Kompanija;
import com.project.isa.entity.Oprema;

import java.util.List;

public interface KorisnikService {

    List<Oprema> svaoprema() throws Exception;
    Kompanija findOne(Long id);
}
