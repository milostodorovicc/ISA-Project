package com.project.isa.repository;

import com.project.isa.entity.Administratorkompanije;
import com.project.isa.entity.Administratorsistema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorkompanijeRepository extends JpaRepository<Administratorkompanije,Long> {

    Administratorkompanije findByEmailadresaAndLozinka(String emailadresa, String lozinka);
}
