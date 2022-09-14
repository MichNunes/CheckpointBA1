package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("usuario/adicionar")
    public UsuarioEntity adicionarUsuario(@RequestBody UsuarioEntity usuario){
        return usuarioService.addUsuario(usuario);
    }

    @GetMapping("usuario/listar")
    public List<UsuarioEntity> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }
}
