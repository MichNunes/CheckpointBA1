//package com.dh.clinicaOdonto.security;
//
//import com.dh.clinicaOdonto.entity.UsuarioEntity;
//import com.dh.clinicaOdonto.repository.IUsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//
//@Service
//@Transactional
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    IUsuarioRepository usuarioRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//        UsuarioEntity appUsuario = usuarioRepository.findByUsuario(username);
//
//        UserDetails usuario = null;
//        usuario = (UserDetails) new UsuarioEntity(username, appUsuario.getSenha(), appUsuario.getAdm());
//        return usuario;
//    }
//
//}
