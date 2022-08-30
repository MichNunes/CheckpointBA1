package com.dh.clinicaOdonto.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private Usuario usuario;
    private List<Endereco> endereco = new ArrayList<>();
    private String rg;
    private LocalDate dataAlta;

    public Paciente(Usuario usuario, List<Endereco> endereco, String rg) {
        this.usuario = usuario;
        this.endereco = endereco;
        this.rg = rg;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public String getRg() {
        return rg;
    }

    public LocalDate getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(LocalDate dataAlta) {
        this.dataAlta = dataAlta;
    }
}
