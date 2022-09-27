package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.controller.dto.EnderecoDTO;
import com.dh.clinicaOdonto.entity.EnderecoEntity;
import com.dh.clinicaOdonto.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("endereco/")
@AllArgsConstructor
public class EnderecoController {
    private final EnderecoService enderecoService;

    @PostMapping()
    public ResponseEntity<EnderecoEntity> adicionarEndereco(@RequestBody EnderecoDTO endereco){
        return ResponseEntity.ok().body(enderecoService.addEndereco(endereco.toEntity()));
    }

    @GetMapping()
    public ResponseEntity<List<EnderecoEntity>> listarEnderecos(){
        return new ResponseEntity<>(enderecoService.listarEnderecos(), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<EnderecoEntity> alterarEndereco(@RequestBody EnderecoDTO endereco){
        return ResponseEntity.ok().body(enderecoService.alterarEndereco(endereco.toEntity()));
    }

    @DeleteMapping("{id}/excluir")
    public ResponseEntity<?> excluirEndereco(@PathVariable Long id){
        enderecoService.excluirEndereco(id);
        return ResponseEntity.ok().build();
    }


}
