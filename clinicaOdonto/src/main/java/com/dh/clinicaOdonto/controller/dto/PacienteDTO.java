package com.dh.clinicaOdonto.controller.dto;

public class PacienteDTO {
    private String rg;
    private Long idUsuario;

    public PacienteDTO() {
    }

    public PacienteDTO(String rg, Long idUsuario) {
        this.rg = rg;
        this.idUsuario = idUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getRg() {
        return rg;
    }
}
