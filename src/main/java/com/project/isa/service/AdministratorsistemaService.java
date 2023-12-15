package com.project.isa.service;

import com.project.isa.entity.Administratorkompanije;
import com.project.isa.entity.Administratorsistema;
import com.project.isa.entity.Kompanija;
import com.project.isa.entity.Registrovanikorisnik;

public interface AdministratorsistemaService {
    Kompanija create(Kompanija kompanija);
    Administratorkompanije createadminkompanije(Administratorkompanije adminkompanije);
    Administratorsistema createadminsistema(Administratorsistema adminsistema);
    Administratorsistema findadmin(Registrovanikorisnik regkorisnik);
    Administratorsistema findadminbyemail(String email);
    Administratorsistema saveadminsistema(Administratorsistema adminsistema);
}
