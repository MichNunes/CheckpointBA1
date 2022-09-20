package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.controller.dto.PacienteDTO;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.repository.IPacienteRepository;
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

    public void excluirPaciente(Long id){
        pacienteRepository.deleteById(id);
    }

    public PacienteEntity alterarPaciente(PacienteEntity paciente){
        return pacienteRepository.saveAndFlush(paciente);
    }
}
