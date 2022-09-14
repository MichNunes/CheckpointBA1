package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.service.PacienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("paciente/adicionar")
    public PacienteEntity adicionarPaciente(@RequestBody PacienteEntity pacienteEntity){
        return pacienteService.addPaciente(pacienteEntity);
    }

    @GetMapping("paciente/listar")
    public List<PacienteEntity> listarPacientes(){
        return pacienteService.listarPacientes();
    }
}
