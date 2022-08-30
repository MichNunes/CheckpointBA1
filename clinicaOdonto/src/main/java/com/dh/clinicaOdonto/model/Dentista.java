package com.dh.clinicaOdonto.model;

public class Dentista {
    private Usuario usuario;
    private int matricula;

    public Dentista(Usuario usuario, int matricula) {
        this.usuario = usuario;
        this.matricula = matricula;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public int getMatricula() {
        return matricula;
    }
}
