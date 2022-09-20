package com.dh.clinicaOdonto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="dentista")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DentistaEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer matricula;

//    @OneToMany(mappedBy = "dentista")
//    private Set<AgendaEntity> agenda = new HashSet<>();

    public DentistaEntity() {
    }

    public DentistaEntity(Long id) {
        this.id = id;
    }

    public DentistaEntity(Long id, Integer matricula) {
        this.id = id;
        this.matricula = matricula;
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
}
