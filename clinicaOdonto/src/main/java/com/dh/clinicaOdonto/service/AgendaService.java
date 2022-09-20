package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.entity.AgendaEntity;
import com.dh.clinicaOdonto.repository.IAgendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AgendaService {

    private static Logger logger = Logger.getLogger(String.valueOf(AgendaService.class));
    private final IAgendaRepository agendaRepository;

    public AgendaService (IAgendaRepository agendaRepository){
        this.agendaRepository = agendaRepository;
    }

    public AgendaEntity agendarConsulta(AgendaEntity agenda){
        if(agenda != null){
            logger.info("Verificando se a consulta já foi marcada.");
            return (AgendaEntity) agendaRepository.save(agenda);
        }
        logger.info("Nova consulta agendada");
        return new AgendaEntity();
    }

    public List<AgendaEntity> listarConsultas(){
        return agendaRepository.findAll();
    }
}


