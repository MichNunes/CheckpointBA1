package com.dh.clinicaOdonto.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="paciente")
public class PacienteEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_paciente")
    private Long id;
    @Column(name="rg")
    private String rg;
    @Column(name="data_alta")
    private LocalDate dataAlta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_usuario", referencedColumnName="id_usuario")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "paciente")
    private Set<AgendaEntity> agenda = new HashSet<>();

//    public PacienteEntity(Integer id, String rg, LocalDate dataAlta) {
//        this.id = id;
//        this.rg = rg;
//        this.dataAlta = dataAlta;
//    }
//
//    public PacienteEntity(String rg, LocalDate dataAlta) {
//        this.rg = rg;
//        this.dataAlta = dataAlta;
//    }

    public PacienteEntity() {
    }

    public long getId() {
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
}
