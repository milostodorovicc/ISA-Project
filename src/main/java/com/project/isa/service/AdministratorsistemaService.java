package com.project.isa.service;

import com.project.isa.entity.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface AdministratorsistemaService {
    Kompanija create(Kompanija kompanija);
    Administratorkompanije createadminkompanije(Administratorkompanije adminkompanije);
    Administratorsistema createadminsistema(Administratorsistema adminsistema);
    Administratorsistema findadmin(Registrovanikorisnik regkorisnik);
    Administratorsistema findadminbyemail(String email);
    Administratorsistema saveadminsistema(Administratorsistema adminsistema);
    Set<ZalbaDTO> findzalbe();
    List<Termin> sviterminiizmedjudatuma(LocalDateTime start, LocalDateTime end);
    Registrovanikorisnik findOne(Long l);
}
