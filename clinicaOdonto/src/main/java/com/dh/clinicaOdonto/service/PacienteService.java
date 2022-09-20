package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.repository.IPacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PacienteService {

    private static Logger logger = Logger.getLogger(String.valueOf(PacienteService.class));
    private final IPacienteRepository pacienteRepository;
    public PacienteService (IPacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    public PacienteEntity addPaciente(PacienteEntity paciente){
        if(paciente != null){
            logger.info("Verificando a existencia do paciente.");
            return (PacienteEntity) pacienteRepository.save(paciente);
        }
        logger.info("New paciente.");
        return new PacienteEntity();
    }

    public List<PacienteEntity> listarPacientes(){
        return pacienteRepository.findAll();
    }
}
