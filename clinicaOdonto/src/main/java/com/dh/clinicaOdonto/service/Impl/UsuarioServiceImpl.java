package com.dh.clinicaOdonto.service.Impl;

import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.entity.UsuarioRoles;
import com.dh.clinicaOdonto.repository.IUsuarioRepository;
import com.dh.clinicaOdonto.repository.IUsuarioRoles;
import com.dh.clinicaOdonto.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
    private final IUsuarioRepository usuarioRepository;
    private final IUsuarioRoles rolesRepository;
    private final PasswordEncoder passwordEncoder;

//    public UsuarioServiceImpl(IUsuarioRepository usuarioRepository){this.usuarioRepository = usuarioRepository;}

//    public UsuarioEntity addUsuario (UsuarioEntity usuario){
//        if(usuario != null){
//            logger.info("Verificando se usuario já esta cadastrado");
//            return (UsuarioEntity) usuarioRepository.save(usuario);
//        }
//        logger.info("New usuario");
//        return new UsuarioEntity();
//    }
//
//    public List<UsuarioEntity> listarUsuarios(){
//        return usuarioRepository.findAll();
//    }
//
//    public void excluirUsuario(Long id){usuarioRepository.deleteById(id);}
//
//    public UsuarioEntity alterarUsuario(UsuarioEntity usuario){
//        return usuarioRepository.saveAndFlush(usuario);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuario = usuarioRepository.findByUsuario(username);

        if(usuario == null){
            log.error("Usuario não encontrado");
            throw new UsernameNotFoundException("Usuário não encontrado no bd");
        }
        else{
            log.info("Usuário encontrado no bd: {}", username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        usuario.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getNome()));
        });

        return new User(usuario.getUsuario(), usuario.getSenha(), authorities);
    }
    @Override
    public UsuarioEntity salvarUsuario(UsuarioEntity usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioRoles salvarRole(UsuarioRoles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public void addRoleToUsuario(String usuario, String nomeRole) {
        UsuarioEntity usuarioToSave = usuarioRepository.findByUsuario(usuario);
        UsuarioRoles role = rolesRepository.findByNome(nomeRole);

        usuarioToSave.getRoles().add(role);
    }

    @Override
    public UsuarioEntity getUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

    @Override
    public List<UsuarioEntity> getUsuarios() {
        return usuarioRepository.findAll();
    }
}
