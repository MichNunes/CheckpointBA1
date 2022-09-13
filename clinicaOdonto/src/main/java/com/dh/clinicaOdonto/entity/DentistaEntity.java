package com.dh.clinicaOdonto.entity;

import com.dh.clinicaOdonto.ideiasAbandonadas.model.Usuario;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Dentista")
public class DentistaEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_dentista")
    private Long id;
    private Integer matricula;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "dentista_agenda")
    private Set<AgendaEntity> agenda = new HashSet<>();

//    public DentistaEntity(Integer id, Integer idUsuario, Integer matricula) {
//        this.id = id;
//        this.idUsuario = idUsuario;
//        this.matricula = matricula;
//    }
//
//    public DentistaEntity(Integer idUsuario, Integer matricula) {
//        this.idUsuario = idUsuario;
//        this.matricula = matricula;
//    }

    public DentistaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Set<AgendaEntity> getAgenda() {
        return agenda;
    }

    public void setAgenda(Set<AgendaEntity> agenda) {
        this.agenda = agenda;
    }
}
