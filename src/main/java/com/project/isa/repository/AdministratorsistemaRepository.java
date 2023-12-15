package com.project.isa.repository;

import com.project.isa.entity.Administratorkompanije;
import com.project.isa.entity.Administratorsistema;
import com.project.isa.entity.Oprema;
import com.project.isa.entity.Registrovanikorisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdministratorsistemaRepository extends JpaRepository<Administratorsistema,Long> {

    Administratorsistema  findByEmailadresaAndLozinka(String emailadresa, String lozinka);
    Administratorsistema  findByEmailadresa(String emailadresa);

}
