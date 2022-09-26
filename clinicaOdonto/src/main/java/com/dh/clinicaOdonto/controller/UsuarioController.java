package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.model.AuthenticationRequest;
import com.dh.clinicaOdonto.model.AuthenticationResponse;
import com.dh.clinicaOdonto.security.JwtUtil;
import com.dh.clinicaOdonto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario/")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value = "/authenticate",method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));

        }catch (BadCredentialsException e) {
            throw new Exception("Incorrect", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse((jwt)));
    }

    @PostMapping()
    public UsuarioEntity adicionarUsuario(@RequestBody UsuarioEntity usuario){
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        return usuarioService.addUsuario(usuario);
    }

    @GetMapping("listar")
    public List<UsuarioEntity> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @DeleteMapping("{id}")
    public void excluirUsuario(@PathVariable Long id){
        usuarioService.excluirUsuario(id);
    }

    @PutMapping()
    public UsuarioEntity alterarUsuario(@RequestBody UsuarioEntity usuario){
        return usuarioService.alterarUsuario(usuario);
    }

}
