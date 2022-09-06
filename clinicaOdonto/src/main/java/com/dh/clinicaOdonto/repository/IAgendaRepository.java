package com.dh.clinicaOdonto.repository;

import com.dh.clinicaOdonto.entity.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAgendaRepository extends JpaRepository<AgendaEntity, Integer> {
}
