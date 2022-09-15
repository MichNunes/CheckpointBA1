package com.dh.clinicaOdonto.controller.dto;

import com.dh.clinicaOdonto.entity.EnderecoEntity;

public class EnderecoDTO {

    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
    private Integer cep;
    private Long idUsuario;

    public EnderecoDTO(String rua, Integer numero, String bairro, String cidade, String estado, Integer cep, Long idUsuario) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.idUsuario = idUsuario;
    }

    public EnderecoDTO() {
    }

    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getCep() {
        return cep;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public EnderecoEntity toEntity(){
        return new EnderecoEntity(this.rua,this.numero,this.bairro,this.cidade,this.estado,this.cep);
    }
}
