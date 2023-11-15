package com.project.isa.repository;

import com.project.isa.entity.Kompanija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KompanijaRepository extends JpaRepository<Kompanija, Long> {

    @Query("select s from Kompanija s where s.id = ?1")
    Kompanija pronadjipoid(Long id);
}
