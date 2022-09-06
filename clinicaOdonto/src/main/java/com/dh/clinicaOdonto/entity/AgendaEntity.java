package com.dh.clinicaOdonto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class AgendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer idDentista;
    private Integer idPaciente;
    private LocalDate dataConsulta;

    public AgendaEntity(Integer id, Integer idDentista, Integer idPaciente, LocalDate dataConsulta) {
        this.id = id;
        this.idDentista = idDentista;
        this.idPaciente = idPaciente;
        this.dataConsulta = dataConsulta;
    }

    public AgendaEntity(Integer idDentista, Integer idPaciente, LocalDate dataConsulta) {
        this.idDentista = idDentista;
        this.idPaciente = idPaciente;
        this.dataConsulta = dataConsulta;
    }

    public AgendaEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(Integer idDentista) {
        this.idDentista = idDentista;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
}
