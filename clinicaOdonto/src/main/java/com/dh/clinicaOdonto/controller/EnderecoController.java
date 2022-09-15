package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.controller.dto.EnderecoDTO;
import com.dh.clinicaOdonto.entity.EnderecoEntity;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.service.EnderecoService;
import com.dh.clinicaOdonto.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("endereco/")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }

    @PostMapping("adicionar")
    public EnderecoEntity adicionarEndereco(@RequestBody EnderecoDTO endereco){
        return enderecoService.addEndereco(endereco.toEntity());
    }

    @GetMapping("listar")
    public List<EnderecoEntity> listarEnderecos(){
        return enderecoService.listarEnderecos();
    }

    @PutMapping("alterar")
    public EnderecoEntity alterarEndereco(@RequestBody EnderecoDTO endereco){
        return enderecoService.atualizarEndereco(endereco.toEntity());
    }
}
