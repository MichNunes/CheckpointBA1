package com.dh.clinicaOdonto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoUsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String tipoUsuario;

    public TipoUsuarioEntity(Integer id, String tipoUsuario) {
        this.id = id;
        this.tipoUsuario = tipoUsuario;
    }

    public TipoUsuarioEntity(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public TipoUsuarioEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
