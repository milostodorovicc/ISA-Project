package com.project.isa.repository;

import com.project.isa.entity.Administratorkompanije;
import com.project.isa.entity.Kompanija;
import com.project.isa.entity.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RezervacijaRepository extends JpaRepository<Rezervacija,Long> {
    @Query("select s from Rezervacija s where s.id = ?1")
    Rezervacija pronadjipoid(Long id);
}
