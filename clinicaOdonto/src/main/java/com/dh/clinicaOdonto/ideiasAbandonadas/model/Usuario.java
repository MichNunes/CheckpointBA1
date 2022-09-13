package com.dh.clinicaOdonto.ideiasAbandonadas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    private Integer id;
    private String usuario;
    private String senha;
    private String nome;
    private String sobrenome;
    private Integer idTipoUsuario;

    public Usuario(String usuario, String senha, String nome, String sobrenome, Integer idTipoUsuario) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idTipoUsuario = idTipoUsuario;
    }
}
