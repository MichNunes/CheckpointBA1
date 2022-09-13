package com.dh.clinicaOdonto.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_endereco")
    private Long id;
    @Column(name="rua")
    private String rua;
    @Column(name="numero")
    private Integer numero;
    @Column(name="bairro")
    private String bairro;
    @Column(name="cidade")
    private String cidade;
    @Column(name="estado")
    private String estado;
    @Column(name="cep")
    private Integer cep;

    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="id_paciente")
    private PacienteEntity paciente;


//    public EnderecoEntity(Integer id, String rua, Integer numero, String bairro, String cidade, String estado, Integer cep, Integer idUsuario) {
//        this.id = id;
//        this.rua = rua;
//        this.numero = numero;
//        this.bairro = bairro;
//        this.cidade = cidade;
//        this.estado = estado;
//        this.cep = cep;
//        this.idUsuario = idUsuario;
//    }
//
//    public EnderecoEntity(String rua, Integer numero, String bairro, String cidade, String estado, Integer cep, Integer idUsuario) {
//        this.rua = rua;
//        this.numero = numero;
//        this.bairro = bairro;
//        this.cidade = cidade;
//        this.estado = estado;
//        this.cep = cep;
//        this.idUsuario = idUsuario;
//    }

    public EnderecoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

}
