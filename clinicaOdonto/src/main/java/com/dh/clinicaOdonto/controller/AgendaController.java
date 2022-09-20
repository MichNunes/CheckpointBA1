package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.entity.AgendaEntity;
import com.dh.clinicaOdonto.service.AgendaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class AgendaController {
    private final AgendaService agendaService;
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping("agenda/adicionar")
    @Transactional
        public AgendaEntity addAgenda (@RequestBody AgendaEntity agenda){
        return agendaService.agendarConsulta(agenda);
    }

    @GetMapping("agenda/listar")
    public List<AgendaEntity> listarConsultas(){
        return agendaService.listarConsultas();
    }
}
