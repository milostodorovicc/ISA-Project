package com.project.isa.service;

import com.project.isa.entity.OpremaDTO;
import com.project.isa.entity.RezervacijaDTO;
import com.project.isa.entity.TerminDTO;

import java.util.List;
import java.util.Set;

public interface AdministratorkompanijeService {
   RezervacijaDTO findrezervacija(String id, String idopreme);
   String obrisiopremu(Long idopreme);
   RezervacijaDTO findrezervacija1(Long opremaid, Long korisnikid, Long terminid);
}
