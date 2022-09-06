package com.dh.clinicaOdonto.entity;

import com.dh.clinicaOdonto.model.Usuario;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DentistaEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer idUsuario;
    private Integer matricula;

    public DentistaEntity(Integer id, Integer idUsuario, Integer matricula) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.matricula = matricula;
    }

    public DentistaEntity(Integer idUsuario, Integer matricula) {
        this.idUsuario = idUsuario;
        this.matricula = matricula;
    }

    public DentistaEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
}
