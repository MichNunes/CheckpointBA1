package com.dh.clinicaOdonto.repository;

import com.dh.clinicaOdonto.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
