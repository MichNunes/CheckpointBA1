package com.dh.clinicaOdonto.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dh.clinicaOdonto.controller.dto.DataUsuarioDTO;
import com.dh.clinicaOdonto.controller.dto.UsuarioDTO;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.entity.UsuarioRoles;
import com.dh.clinicaOdonto.service.Impl.UsuarioServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("usuario/")
public class UsuarioController {
    private final UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioEntity>> listUsers(){
        return ResponseEntity.ok().body(usuarioServiceImpl.getUsuarios());
    }

    @PostMapping()
    public ResponseEntity<UsuarioEntity> saveUser(@RequestBody UsuarioDTO usuario){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/usuario/adicionar").toUriString());
        return ResponseEntity.created(uri).body(usuarioServiceImpl.salvarUsuario(usuario.toEntity()));
    }
    @PostMapping("/role")
    public ResponseEntity<UsuarioRoles> saveRole(@RequestBody UsuarioRoles roles){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/usuario/role/adicionar").toUriString());
        return ResponseEntity.created(uri).body(usuarioServiceImpl.salvarRole(roles));
    }
    @GetMapping("/dados")
    public ResponseEntity<UsuarioEntity> dataUser(@RequestBody String username){
        return ResponseEntity.ok().body(usuarioServiceImpl.getUsuario(username));
    }

    @PostMapping("/role/vincular")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        usuarioServiceImpl.addRoleToUsuario(form.getUsername(), form.getRole());
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<DataUsuarioDTO> updateUser(@RequestBody UsuarioDTO usuario){
        return ResponseEntity.ok().body(usuarioServiceImpl.atualizarUsuario(usuario.toEntity()));
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            try{
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("testsecret".getBytes());

                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);

                String username = decodedJWT.getSubject();
                UsuarioEntity usuario = usuarioServiceImpl.getUsuario(username);

                String access_token = JWT.create()
                        .withSubject(usuario.getUsuario())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", usuario.getRoles().stream().map(UsuarioRoles::getNome).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);

                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            }
            catch(Exception e){
                response.setHeader("error", e.getMessage());
                response.setStatus(FORBIDDEN.value());

                Map<String, String> error = new HashMap<>();
                error.put("error_message", e.getMessage());

                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        }
        else{
            throw new RuntimeException("Refresh Token is missing");
        }

    }
}

@Data
class RoleToUserForm{
    private String username;
    private String role;
}