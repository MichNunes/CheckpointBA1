package com.dh.clinicaOdonto.controller.dto;

import com.dh.clinicaOdonto.entity.UsuarioEntity;

import javax.persistence.Column;

public class UsuarioDTO {

    private String usuario;
    private String senha;
    private String nome;
    private String sobrenome;
    private Boolean isAdm;

    public UsuarioDTO(){}

    public UsuarioDTO(String usuario, String senha, String nome, String sobrenome, Boolean isAdm) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.isAdm = isAdm;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Boolean getAdm() {
        return isAdm;
    }

    public void setAdm(Boolean adm) {
        isAdm = adm;
    }

    public UsuarioEntity toEntity(){
        return new UsuarioEntity(this.usuario,this.senha,this.nome,this.sobrenome,this.isAdm);
    }
}
