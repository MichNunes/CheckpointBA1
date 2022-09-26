package com.dh.clinicaOdonto.controller.dto;

import com.dh.clinicaOdonto.entity.UsuarioEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDTO {
    private String usuario;
    private String senha;
    private String nome;
    private String sobrenome;

    public UsuarioEntity toEntity(){
        return new UsuarioEntity(this.usuario, this.senha, this.nome, this.sobrenome);
    }
}
