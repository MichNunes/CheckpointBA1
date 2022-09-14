package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.controller.UsuarioController;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final IUsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService (IUsuarioRepository usuarioRepository){this.usuarioRepository = usuarioRepository;}

    public UsuarioEntity addUsuario (UsuarioEntity usuario){
        if(usuario != null){
            return (UsuarioEntity) usuarioRepository.save(usuario);
        }

        return new UsuarioEntity();
    }

    public List<UsuarioEntity> listarUsuarios(){
        return usuarioRepository.findAll();
    }
}
