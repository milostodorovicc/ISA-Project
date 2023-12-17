package com.project.isa.repository;

import com.project.isa.entity.Termin;
import com.project.isa.entity.Zalba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TerminRepository extends JpaRepository<Termin,Long> {
    @Query("SELECT t FROM Termin t WHERE (t.startTime BETWEEN :start AND :end) OR (t.endTime BETWEEN :start AND :end)")
    List<Termin> terminiizmedjudatuma(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}

