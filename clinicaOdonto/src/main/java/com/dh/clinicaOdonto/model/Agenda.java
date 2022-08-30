package com.dh.clinicaOdonto.model;

import java.time.LocalDate;

public class Agenda {

    private int id;
    private Dentista destista;
    private Paciente paciente;
    private LocalDate dataConsulta;

    public Agenda(int id, Dentista destista, Paciente paciente, LocalDate dataConsulta) {
        this.id = id;
        this.destista = destista;
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
    }

    public int getId() {
        return id;
    }

    public Dentista getDestista() {
        return destista;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }
}
