package com.dh.clinicaOdonto.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class UsuarioEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column(unique=true, nullable = false)
        private String usuario;
        private String senha;
        private String nome;
        private String sobrenome;
        @Column(name="is_adm")
        private Boolean isAdm;

        @OneToOne
        @Cascade(org.hibernate.annotations.CascadeType.ALL)
        private DentistaEntity dentista;

        @OneToOne
        @Cascade(org.hibernate.annotations.CascadeType.ALL)
        private PacienteEntity paciente;

        public UsuarioEntity() {
        }

        public UsuarioEntity(String usuario, String senha, String nome, String sobrenome, Boolean isAdm) {
                this.usuario = usuario;
                this.senha = senha;
                this.nome = nome;
                this.sobrenome = sobrenome;
                this.isAdm = isAdm;
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

        public Boolean getAdm() {
                return isAdm;
        }

        public void setAdm(Boolean adm) {
                isAdm = adm;
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
}
