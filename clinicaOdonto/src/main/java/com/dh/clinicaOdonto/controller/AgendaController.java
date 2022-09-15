package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.entity.AgendaEntity;
import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.repository.IUsuarioRepository;
import com.dh.clinicaOdonto.service.AgendaService;
import com.dh.clinicaOdonto.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgendaController {
    private final AgendaService agendaService;
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping("agenda/adicionar")
    public AgendaEntity addAgenda (@RequestBody AgendaEntity agenda){
        return agendaService.agendarConsulta(agenda);
    }

    @GetMapping("agenda/listar")
    public List<AgendaEntity> listarConsultas(){
        return agendaService.listarConsultas();
    }
}
