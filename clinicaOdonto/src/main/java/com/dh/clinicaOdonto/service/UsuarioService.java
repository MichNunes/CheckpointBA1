package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.controller.dto.UsuarioDTO;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UsuarioService {

    private static Logger logger = Logger.getLogger(String.valueOf(UsuarioService.class));
    private final IUsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService (IUsuarioRepository usuarioRepository){this.usuarioRepository = usuarioRepository;}

    public String addUsuario (UsuarioDTO usuario){
        if(usuario != null){
            logger.info("Verificando se usuario já esta cadastrado");
            usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
            return (UsuarioEntity) usuarioRepository.save(usuario.toEntity()).getId();
        }
        logger.info("New usuario");
        return new UsuarioEntity();
    }

    public List<UsuarioEntity> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public void excluirUsuario(Long id){usuarioRepository.deleteById(id);}

    public UsuarioEntity alterarUsuario(UsuarioEntity usuario){
        return usuarioRepository.saveAndFlush(usuario);
    }
}
