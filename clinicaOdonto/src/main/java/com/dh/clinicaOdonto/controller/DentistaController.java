package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.service.DentistaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DentistaController {

    private final DentistaService dentistaService;

    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping("dentista/adicionar")
    public DentistaEntity addDentista (@RequestBody DentistaEntity dentistaEntity){
        return dentistaService.addDentista(dentistaEntity);
    }

    @GetMapping("dentista/listar")
    public List<DentistaEntity> listarDentista(){
        return dentistaService.listarDentista();
    }

}
