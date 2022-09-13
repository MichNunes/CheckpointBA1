package com.dh.clinicaOdonto.entity;

import com.dh.clinicaOdonto.entity.UsuarioEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tipo_usuario")
public class TipoUsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_tipo_usuario")
    private Integer id;

    @Column(name = "tipo_usuario")
    private String tipoUsuario;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "tipoUsuario")
    @JoinColumn(name="id_usuario")
    private Set<UsuarioEntity> usuarios = new HashSet<>();

//    public TipoUsuarioEntity(Integer id, String tipoUsuario) {
//        this.id = id;
//        this.tipoUsuario = tipoUsuario;
//    }
//
//    public TipoUsuarioEntity(String tipoUsuario) {
//        this.tipoUsuario = tipoUsuario;
//    }

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
