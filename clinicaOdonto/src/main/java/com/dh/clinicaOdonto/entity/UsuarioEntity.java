package com.dh.clinicaOdonto.entity;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class UsuarioEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="id_usuario")
        private Long idUsuario;
        @Column(name="usuario")
        private String usuario;
        @Column(name="senha")
        private String senha;
        @Column(name="nome")
        private String nome;
        @Column(name="sobrenome")
        private String sobrenome;
        @Column(name="is_adm")
        private Boolean isAdm;

        @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
        @JoinColumn(name="id_tipo_usuario")
        private TipoUsuarioEntity tipoUsuario;

        @OneToOne(mappedBy = "fk_usuario_dentista")
        private DentistaEntity dentista;

        @OneToOne(mappedBy = "fk_usuario_paciente")
        private PacienteEntity paciente;


//        public UsuarioEntity(Integer id, String usuario, String senha, String nome, String sobrenome, Integer idTipoUsuario) {
//                this.id = id;
//                this.usuario = usuario;
//                this.senha = senha;
//                this.nome = nome;
//                this.sobrenome = sobrenome;
//                this.idTipoUsuario = idTipoUsuario;
//        }
//
//        public UsuarioEntity(String usuario, String senha, String nome, String sobrenome, Integer idTipoUsuario) {
//                this.usuario = usuario;
//                this.senha = senha;
//                this.nome = nome;
//                this.sobrenome = sobrenome;
//                this.idTipoUsuario = idTipoUsuario;
//        }

        public UsuarioEntity() {
        }

        public Long getId() {
                return idUsuario;
        }

        public void setId(Long id) {
                this.idUsuario = id;
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
}
