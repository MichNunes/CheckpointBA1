package com.dh.clinicaOdonto.entity;

import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name="usuario")
public class UsuarioEntity implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String usuario;
        private String senha;
        private String nome;
        private String sobrenome;
        @Enumerated(EnumType.STRING)
        private UsuarioRoles nivel;

        @OneToOne
        @Cascade(org.hibernate.annotations.CascadeType.ALL)
        private DentistaEntity dentista;

        @OneToOne
        @Cascade(org.hibernate.annotations.CascadeType.ALL)
        private PacienteEntity paciente;

        public UsuarioEntity() {
        }

        public UsuarioEntity(String usuario, String senha, String nome, String sobrenome, UsuarioRoles nivel) {
                this.usuario = usuario;
                this.senha = senha;
                this.nome = nome;
                this.sobrenome = sobrenome;
                this.nivel = nivel;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getUsuario() {
                return usuario;
        }

        public void setUsuario(String usuario) {
                this.usuario = usuario;
        }

        public String getSenha() {
                return senha;
        }

        public void setSenha(String senha) {
                this.senha = senha;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getSobrenome() {
                return sobrenome;
        }

        public void setSobrenome(String sobrenome) {
                this.sobrenome = sobrenome;
        }

        public UsuarioRoles getNivel() {
                return nivel;
        }

        public void setNivel(UsuarioRoles nivel) {
                this.nivel = nivel;
        }

        public DentistaEntity getDentista() {
                return dentista;
        }

        public void setDentista(DentistaEntity dentista) {
                this.dentista = dentista;
        }

        public PacienteEntity getPaciente() {
                return paciente;
        }

        public void setPaciente(PacienteEntity paciente) {
                this.paciente = paciente;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(nivel.name());

                return Collections.singleton(grantedAuthority);
        }

        @Override
        public String getPassword() {
                return null;
        }

        @Override
        public String getUsername() {
                return null;
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }
}
