package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.entity.AgendaEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.repository.IAgendaRepository;
import com.dh.clinicaOdonto.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    private final IPacienteRepository pacienteRepository;
    public PacienteService (IPacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    public PacienteEntity addPaciente(PacienteEntity paciente){
        if(paciente != null){
            return (PacienteEntity) pacienteRepository.save(paciente);
        }

        return new PacienteEntity();
    }

    public List<PacienteEntity> listarPacientes(){
        return pacienteRepository.findAll();
    }
}
