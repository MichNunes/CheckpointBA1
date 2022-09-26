package com.dh.clinicaOdonto.controller.dto;

import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.entity.UsuarioRoles;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataUsuarioDTO {
    private String usuario;
    private String nome;
    private String sobrenome;
    private Collection<UsuarioRoles> roles = new ArrayList<>();
    private DentistaEntity dentista;
    private PacienteEntity paciente;
}
