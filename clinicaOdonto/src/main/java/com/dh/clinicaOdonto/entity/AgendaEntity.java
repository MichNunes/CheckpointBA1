package com.dh.clinicaOdonto.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="agenda")
public class AgendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="data_consulta")
    private LocalDate dataConsulta;

    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="dentista")
    private DentistaEntity dentista;

    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="paciente")
    private PacienteEntity paciente;

//    public AgendaEntity(Integer id, Integer idDentista, Integer idPaciente, LocalDate dataConsulta) {
//        this.id = id;
//        this.idDentista = idDentista;
//        this.idPaciente = idPaciente;
//        this.dataConsulta = dataConsulta;
//    }
//
//    public AgendaEntity(LocalDate dataConsulta, DentistaEntity dentista, PacienteEntity paciente) {
//        this.dentista = dentista;
//        this.paciente = paciente;
//        this.dataConsulta = dataConsulta;
//    }

    public AgendaEntity() {
    }

    public AgendaEntity(Long id, LocalDate dataConsulta, DentistaEntity dentista, PacienteEntity paciente) {
        this.id = id;
        this.dataConsulta = dataConsulta;
        this.dentista = dentista;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public DentistaEntity getDentista() {
        return dentista;
    }

    public PacienteEntity getPaciente() {
        return paciente;
    }
}
