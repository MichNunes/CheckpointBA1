package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.entity.AgendaEntity;
import com.dh.clinicaOdonto.service.AgendaService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("agenda/")
public class AgendaController {
    private final AgendaService agendaService;

    @PostMapping()
    @Transactional
    public ResponseEntity<AgendaEntity> addAgenda (@RequestBody AgendaEntity agenda){
        return ResponseEntity.ok().body(agendaService.agendarConsulta(agenda));
    }

    @GetMapping()
    public ResponseEntity<List<AgendaEntity>> listarConsultas(){
        return ResponseEntity.ok().body(agendaService.listarConsultas());
    }

    @DeleteMapping("{id}/excluir")
    public ResponseEntity<?> excluirAgenda(@PathVariable Long id){
        agendaService.excluirAgenda(id);
        return ResponseEntity.ok().build();
    }

}
