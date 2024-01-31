package com.project.isa.repository;

import com.project.isa.entity.Oprema;
import com.project.isa.entity.Termin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OpremaRepository extends JpaRepository<Oprema, Long> {
    List<Oprema> findByNaziv(String naziv);
    List<Oprema> findByTip(String tipopreme);
    List<Oprema> findByOcenaGreaterThanEqual(Long minocena);
    List<Oprema> findByTipAndOcenaGreaterThanEqual(String filtpotipu,Long filtpooceni);
    List<Oprema> findByNazivAndOcenaGreaterThanEqual(String nazivopreme,Long filtpooceni);
    List<Oprema> findByNazivAndTip(String nazivopreme,String filtpotipu);
    List<Oprema> findByNazivAndTipAndOcenaGreaterThanEqual(String nazivopreme,String filtpotipu,Long filtpooceni);
    @Query("select s from Oprema s where s.id = ?1")
    Oprema pronadjipoid(Long l);
}

