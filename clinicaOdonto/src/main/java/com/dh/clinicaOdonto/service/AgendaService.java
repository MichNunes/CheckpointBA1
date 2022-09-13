package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.entity.AgendaEntity;
import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.repository.IAgendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AgendaService {

    private final IAgendaRepository agendaRepository;

    public AgendaService (IAgendaRepository agendaRepository){
        this.agendaRepository = agendaRepository;
    }

    public AgendaEntity agendarConsulta(AgendaEntity agenda){
        if(agenda != null){
            return (AgendaEntity) agendaRepository.save(agenda);
        }
        return new AgendaEntity();
    }
}
