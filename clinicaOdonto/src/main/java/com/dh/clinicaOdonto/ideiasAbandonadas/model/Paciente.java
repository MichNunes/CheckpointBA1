package com.dh.clinicaOdonto.ideiasAbandonadas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Paciente extends Usuario {

    private String rg;
    private LocalDate dataAlta;
    private List<Endereco> enderecos= new ArrayList<>();

    public Paciente(String usuario, String senha, String nome, String sobrenome, Integer idTipoUsuario, String rg, LocalDate dataAlta, List<Endereco> enderecos) {
        super(usuario, senha, nome, sobrenome, idTipoUsuario);
        this.rg = rg;
        this.dataAlta = dataAlta;
        this.enderecos = enderecos;
    }
}
