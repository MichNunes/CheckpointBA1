package com.dh.clinicaOdonto.model;

public class Endereco {

    private int id;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private int cep;
    private int idUsuario;

//    Construtor para informação que já existe no BD
    public Endereco(int id, String rua, int numero, String bairro, String cidade, String estado, int cep, int idUsuario) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.idUsuario = idUsuario;
    }

//    Construtor para informação que não existe no BD
    public Endereco(String rua, int numero, String bairro, String cidade, String estado, int cep, int idUsuario) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
