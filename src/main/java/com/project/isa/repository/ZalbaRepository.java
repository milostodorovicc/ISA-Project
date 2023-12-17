package com.project.isa.repository;

import com.project.isa.entity.Registrovanikorisnik;
import com.project.isa.entity.Zalba;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZalbaRepository extends JpaRepository<Zalba,Long> {

}
