package com.project.isa.service;

import com.project.isa.entity.OpremaDTO;
import com.project.isa.entity.RezervacijaDTO;
import com.project.isa.entity.TerminDTO;

import java.util.List;
import java.util.Set;

public interface AdministratorkompanijeService {
   RezervacijaDTO findrezervacija(String id, List<String> idopremesvi) throws Exception;
   List<OpremaDTO> obrisiopremu(String idopreme, Long idkorisnik);
   RezervacijaDTO findrezervacija1(String opremaid, Long korisnikid, Long terminid);
}
