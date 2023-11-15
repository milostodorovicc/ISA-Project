package com.project.isa.service;

import com.project.isa.entity.Administratorkompanije;
import com.project.isa.entity.Kompanija;

public interface AdministratorsistemaService {
    Kompanija create(Kompanija kompanija);
    Administratorkompanije createadminkompanije(Administratorkompanije adminkompanije);
}
