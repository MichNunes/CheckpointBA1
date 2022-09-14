package com.dh.clinicaOdonto.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="agenda")
public class AgendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_agenda")
    private Long idAgenda;
    @Column(name="data_consulta")
    private LocalDate dataConsulta;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="fk_dentista")
    private DentistaEntity dentistaEntity;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="fk_paciente")
    private PacienteEntity pacienteEntity;

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

    public Long getId() {
        return idAgenda;
    }

    public void setId(Long id) {
        this.idAgenda = id;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
}
