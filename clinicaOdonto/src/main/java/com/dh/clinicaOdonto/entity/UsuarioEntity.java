package com.dh.clinicaOdonto.entity;

import com.dh.clinicaOdonto.controller.dto.DataUsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name="usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String usuario;
        private String senha;
        private String nome;
        private String sobrenome;
        @ManyToMany(fetch = EAGER)
        private Collection<UsuarioRoles> roles = new ArrayList<>();

        @OneToOne
        @Cascade(org.hibernate.annotations.CascadeType.ALL)
        private DentistaEntity dentista;

        @OneToOne
        @Cascade(org.hibernate.annotations.CascadeType.ALL)
        private PacienteEntity paciente;

        public UsuarioEntity(String usuario, String senha, String nome, String sobrenome) {
                this.usuario = usuario;
                this.senha = senha;
                this.nome = nome;
                this.sobrenome = sobrenome;
        }

        public DataUsuarioDTO toDataUsuarioDTO(){
                return new DataUsuarioDTO(this.usuario, this.nome, this.sobrenome, this.roles, this.dentista, this.paciente);
        }
}
