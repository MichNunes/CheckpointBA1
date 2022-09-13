package com.dh.clinicaOdonto.ideiasAbandonadas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Endereco {

    private int id;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private int cep;
    private int idUsuario;

    public Endereco(String rua, int numero, String bairro, String cidade, String estado, int cep, int idUsuario)
    {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.idUsuario = idUsuario;
    }
}