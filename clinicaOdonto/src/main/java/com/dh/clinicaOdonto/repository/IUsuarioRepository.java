package com.dh.clinicaOdonto.repository;

import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.service.DentistaService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByUsuario(UsuarioEntity usuario);
    Optional<UsuarioEntity> findByPaciente(PacienteEntity paciente);
    Optional<UsuarioEntity> findByDentista(DentistaEntity dentista);
}
