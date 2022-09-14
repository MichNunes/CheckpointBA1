package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.entity.EnderecoEntity;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.service.EnderecoService;
import com.dh.clinicaOdonto.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }

    @PostMapping("endereco/adicionar")
    public EnderecoEntity adicionarEndereco(@RequestBody EnderecoEntity endereco){
        return enderecoService.addEndereco(endereco);
    }

    @GetMapping("endereco/listar")
    public List<EnderecoEntity> listarEnderecos(){
        return enderecoService.listarEnderecos();
    }
}
