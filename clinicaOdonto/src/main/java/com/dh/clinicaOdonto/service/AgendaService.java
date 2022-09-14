package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.entity.AgendaEntity;
import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.repository.IAgendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public List<AgendaEntity> listarConsultas(){
        return agendaRepository.findAll();
    }
}
