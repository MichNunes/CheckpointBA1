package com.dh.clinicaOdonto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsuarioEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Integer id;
        private String usuario;
        private String senha;
        private String nome;
        private String sobrenome;
        private Integer idTipoUsuario;


        public UsuarioEntity(Integer id, String usuario, String senha, String nome, String sobrenome, Integer idTipoUsuario) {
                this.id = id;
                this.usuario = usuario;
                this.senha = senha;
                this.nome = nome;
                this.sobrenome = sobrenome;
                this.idTipoUsuario = idTipoUsuario;
        }

        public UsuarioEntity(String usuario, String senha, String nome, String sobrenome, Integer idTipoUsuario) {
                this.usuario = usuario;
                this.senha = senha;
                this.nome = nome;
                this.sobrenome = sobrenome;
                this.idTipoUsuario = idTipoUsuario;
        }

        public UsuarioEntity() {
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
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

        public Integer getIdTipoUsuario() {
                return idTipoUsuario;
        }

        public void setIdTipoUsuario(Integer idTipoUsuario) {
                this.idTipoUsuario = idTipoUsuario;
        }
}
