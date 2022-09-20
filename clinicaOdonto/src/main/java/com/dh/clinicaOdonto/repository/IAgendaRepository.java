package com.dh.clinicaOdonto.repository;

import com.dh.clinicaOdonto.entity.AgendaEntity;
import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IAgendaRepository extends JpaRepository<AgendaEntity, Long> {
    Optional<List<AgendaEntity>> findByPaciente(PacienteEntity paciente);
    Optional<List<AgendaEntity>> findByDentista(DentistaEntity dentista);
}
