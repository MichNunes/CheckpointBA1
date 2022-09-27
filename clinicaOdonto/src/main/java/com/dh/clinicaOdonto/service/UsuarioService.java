package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.controller.dto.DataUsuarioDTO;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.entity.UsuarioRoles;

import java.util.List;

public interface UsuarioService {
    UsuarioEntity salvarUsuario(UsuarioEntity usuario);
    UsuarioRoles salvarRole(UsuarioRoles roles);
    void addRoleToUsuario(String usuario, String nomeRole);
    UsuarioEntity getUsuario(String usuario);
    List<UsuarioEntity>getUsuarios();
    DataUsuarioDTO atualizarUsuario(UsuarioEntity usuario);
    void excluirUsuario(String username);
}
