package com.dh.clinicaOdonto.controller.dto;

public class DentistaDTO {
    private Integer matricula;
    private  Long idUsuario;

    public DentistaDTO(){
    }

    public DentistaDTO(Integer matricula, Long idUsuario) {
        this.matricula = matricula;
        this.idUsuario = idUsuario;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }
}
