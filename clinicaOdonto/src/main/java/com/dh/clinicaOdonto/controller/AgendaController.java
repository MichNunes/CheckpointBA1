package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.entity.AgendaEntity;
import com.dh.clinicaOdonto.service.AgendaService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("agenda/")
public class AgendaController {
    private final AgendaService agendaService;
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping("adicionar")
    @Transactional
        public AgendaEntity addAgenda (@RequestBody AgendaEntity agenda){
        return agendaService.agendarConsulta(agenda);
    }

    @GetMapping("listar")
    public List<AgendaEntity> listarConsultas(){
        return agendaService.listarConsultas();
    }

    @DeleteMapping("{id}/excluir")
    public void excluirAgenda(@PathVariable Long id){
        agendaService.excluirAgenda(id);
    }

}
