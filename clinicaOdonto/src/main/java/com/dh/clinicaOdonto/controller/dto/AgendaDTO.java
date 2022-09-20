package com.dh.clinicaOdonto.controller.dto;

import com.dh.clinicaOdonto.entity.AgendaEntity;
import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class AgendaDTO {
    private Long idAgenda;
    private LocalDate dataConsulta;
    private Long dentista;
    private Long paciente;

    public AgendaDTO(LocalDate dataConsulta, Long dentista, Long paciente) {
        this.dataConsulta = dataConsulta;
        this.dentista = dentista;
        this.paciente = paciente;
    }

    public AgendaDTO(Long idAgenda, LocalDate dataConsulta, Long dentista, Long paciente) {
        this.idAgenda = idAgenda;
        this.dataConsulta = dataConsulta;
        this.dentista = dentista;
        this.paciente = paciente;
    }

    public Long getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Long idAgenda) {
        this.idAgenda = idAgenda;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Long getDentista() {
        return dentista;
    }

    public void setDentista(Long dentista) {
        this.dentista = dentista;
    }

    public Long getPaciente() {
        return paciente;
    }

    public void setPaciente(Long paciente) {
        this.paciente = paciente;
    }

    public AgendaEntity toEntity(){
        return new AgendaEntity(this.idAgenda, this.dataConsulta, new DentistaEntity(this.dentista), new PacienteEntity(this.paciente));
    }
}
