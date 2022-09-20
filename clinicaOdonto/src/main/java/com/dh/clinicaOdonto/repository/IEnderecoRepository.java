package com.dh.clinicaOdonto.repository;

import com.dh.clinicaOdonto.controller.dto.EnderecoDTO;
import com.dh.clinicaOdonto.controller.dto.PacienteDTO;
import com.dh.clinicaOdonto.entity.EnderecoEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface IEnderecoRepository extends JpaRepository<EnderecoEntity, Long>{
    Optional<Set<EnderecoDTO>> findByPaciente(PacienteEntity paciente);
}
