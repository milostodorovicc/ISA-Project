package com.project.isa.repository;

import com.project.isa.entity.Administratorsistema;
import com.project.isa.entity.Registrovanikorisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrovanikorisnikRepository extends JpaRepository<Registrovanikorisnik,Long> {
    Registrovanikorisnik findByEmailadresaAndLozinka(String emailadresa, String lozinka);

}
