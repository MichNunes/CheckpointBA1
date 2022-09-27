package com.dh.clinicaOdonto.controller.dto;

import com.dh.clinicaOdonto.entity.DentistaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DentistaDTO {
    private Integer matricula;
    private  Long idUsuario;

    public DentistaEntity toEntity(){
       return new DentistaEntity(this.idUsuario, this.matricula);
    }
}
