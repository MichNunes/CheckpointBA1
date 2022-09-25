package com.dh.clinicaOdonto.repository;

import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByUsuario(String usuario);
    Optional<UsuarioEntity> findByPaciente(PacienteEntity paciente);
    Optional<UsuarioEntity> findByDentista(DentistaEntity dentista);
}
