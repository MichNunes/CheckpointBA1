package com.dh.clinicaOdonto.model;

public class Usuario {
    private Integer id;
    private String usuario;
    private String senha;
    private String nome;
    private String sobrenome;
    private Integer idTipoUsuario;

    public Usuario(Integer id, String usuario, String senha, String nome, String sobrenome, Integer idTipoUsuario) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idTipoUsuario = idTipoUsuario;
    }

    public Integer getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }
}
