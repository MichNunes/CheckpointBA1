package com.dh.clinicaOdonto.repository;

import com.dh.clinicaOdonto.entity.DentistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDentistaRepository extends JpaRepository<DentistaEntity, Long>{
}
