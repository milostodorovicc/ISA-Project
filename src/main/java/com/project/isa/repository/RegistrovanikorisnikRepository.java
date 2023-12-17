package com.project.isa.repository;

import com.project.isa.entity.Administratorsistema;
import com.project.isa.entity.Kompanija;
import com.project.isa.entity.Registrovanikorisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegistrovanikorisnikRepository extends JpaRepository<Registrovanikorisnik,Long> {
    Registrovanikorisnik findByEmailadresaAndLozinka(String emailadresa, String lozinka);
    @Query("select s from Registrovanikorisnik s where s.id = ?1")
    Registrovanikorisnik pronadjipoid(Long l);

}
