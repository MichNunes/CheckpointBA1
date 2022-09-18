package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UsuarioService {

    private static Logger logger = Logger.getLogger(String.valueOf(UsuarioService.class));
    private final IUsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService (IUsuarioRepository usuarioRepository){this.usuarioRepository = usuarioRepository;}

    public UsuarioEntity addUsuario (UsuarioEntity usuario){
        if(usuario != null){
            logger.info("Verificando se usuario já esta cadastrado");
            return (UsuarioEntity) usuarioRepository.save(usuario);
        }
        logger.info("New usuario");
        return new UsuarioEntity();
    }

    public List<UsuarioEntity> listarUsuarios(){
        return usuarioRepository.findAll();
    }
}
