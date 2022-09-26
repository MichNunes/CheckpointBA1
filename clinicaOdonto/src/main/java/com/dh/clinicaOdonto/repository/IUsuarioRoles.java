package com.dh.clinicaOdonto.repository;

import com.dh.clinicaOdonto.entity.UsuarioRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRoles extends JpaRepository<UsuarioRoles, Long> {
    UsuarioRoles findByNome(String nome);
}
