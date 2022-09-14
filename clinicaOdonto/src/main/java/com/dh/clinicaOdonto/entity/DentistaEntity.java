package com.dh.clinicaOdonto.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="dentista")
public class DentistaEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_dentista")
    private Long idDentista;
    private Integer matricula;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_usuario", referencedColumnName = "id_usuario")
    private UsuarioEntity fk_usuario_dentista;

    @OneToMany(mappedBy = "dentistaEntity")
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
        return idDentista;
    }

    public void setId(Long id) {
        this.idDentista = id;
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
