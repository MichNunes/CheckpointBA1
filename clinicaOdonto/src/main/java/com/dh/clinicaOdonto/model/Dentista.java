package com.dh.clinicaOdonto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Dentista extends Usuario{

    private int matricula;

    public Dentista(String usuario, String senha, String nome, String sobrenome, Integer idTipoUsuario, int matricula) {
        super(usuario, senha, nome, sobrenome, idTipoUsuario);
        this.matricula = matricula;
    }
}
