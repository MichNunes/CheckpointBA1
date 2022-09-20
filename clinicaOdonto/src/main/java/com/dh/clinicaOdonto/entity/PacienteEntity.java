package com.dh.clinicaOdonto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="paciente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PacienteEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="rg")
    private String rg;
    @Column(name="data_alta")
    private LocalDate dataAlta;

    public PacienteEntity() {
    }

    public PacienteEntity(Long id) {
        this.id = id;
    }

    public PacienteEntity(Long id, String rg) {
        this.id = id;
        this.rg = rg;
    }

    public PacienteEntity(Long id, String rg, LocalDate dataAlta) {
        this.id = id;
        this.rg = rg;
        this.dataAlta = dataAlta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

//    public Set<AgendaEntity> getAgenda() {
//        return agenda;
//    }
//
//    public void setAgenda(Set<AgendaEntity> agenda) {
//        this.agenda = agenda;
//    }
}
