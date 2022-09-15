package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.entity.EnderecoEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.repository.IEnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final IEnderecoRepository enderecoRepository;

    public EnderecoService(IEnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public EnderecoEntity addEndereco(EnderecoEntity endereco){
        if(endereco != null){
            return (EnderecoEntity) enderecoRepository.save(endereco);
        }
        return new EnderecoEntity();
    }

    public List<EnderecoEntity> listarEnderecos(){
        return enderecoRepository.findAll();
    }

    public EnderecoEntity atualizarEndereco(EnderecoEntity endereco){
        return enderecoRepository.saveAndFlush(endereco);
    }
}
