package com.dh.clinicaOdonto.repository;

import com.dh.clinicaOdonto.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<PacienteEntity, Integer> {
}
