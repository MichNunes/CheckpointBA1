package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.service.UsuarioService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario/")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("adicionar")
    public UsuarioEntity adicionarUsuario(@RequestBody UsuarioEntity usuario){
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        return usuarioService.addUsuario(usuario);
    }

    @GetMapping("listar")
    public List<UsuarioEntity> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @DeleteMapping("{id}/excluir")
    public void excluirUsuario(@PathVariable Long id){
        usuarioService.excluirUsuario(id);
    }

    @PutMapping("alterar")
    public UsuarioEntity alterarUsuario(@RequestBody UsuarioEntity usuario){
        return usuarioService.alterarUsuario(usuario);
    }

}
