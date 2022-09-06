package com.dh.clinicaOdonto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class PacienteEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String rg;
    private LocalDate dataAlta;

    public PacienteEntity(Integer id, String rg, LocalDate dataAlta) {
        this.id = id;
        this.rg = rg;
        this.dataAlta = dataAlta;
    }

    public PacienteEntity(String rg, LocalDate dataAlta) {
        this.rg = rg;
        this.dataAlta = dataAlta;
    }

    public PacienteEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(LocalDate dataAlta) {
        this.dataAlta = dataAlta;
    }
}
