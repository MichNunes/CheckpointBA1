package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.entity.UsuarioRoles;
import com.dh.clinicaOdonto.service.Impl.UsuarioServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.management.relation.Role;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("usuario/")
public class UsuarioController {
    private final UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping("/todos")
    public ResponseEntity<List<UsuarioEntity>> listUsers(){
        return ResponseEntity.ok().body(usuarioServiceImpl.getUsuarios());
    }

    @PostMapping("/adicionar")
    public ResponseEntity<UsuarioEntity> saveUser(@RequestBody UsuarioEntity usuario){

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/usuario/adicionar").toUriString());
        return ResponseEntity.created(uri).body(usuarioServiceImpl.salvarUsuario(usuario));
    }
    @PostMapping("/role/adicionar")
    public ResponseEntity<UsuarioRoles> saveRole(@RequestBody UsuarioRoles roles){

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/usuario/role/adicionar").toUriString());
        return ResponseEntity.created(uri).body(usuarioServiceImpl.salvarRole(roles));
    }
    @GetMapping("/dados")
    public ResponseEntity<UsuarioEntity> dataUser(@RequestBody String username){
        return ResponseEntity.ok().body(usuarioServiceImpl.getUsuario(username));
    }

    @PostMapping("/role/adicionaraousuario")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        usuarioServiceImpl.addRoleToUsuario(form.getUsername(), form.getRole());
        return ResponseEntity.ok().build();
    }
}

@Data
class RoleToUserForm{
    private String username;
    private String role;
}