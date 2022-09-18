package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.entity.EnderecoEntity;
import com.dh.clinicaOdonto.repository.IEnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class EnderecoService {

    private static Logger logger = Logger.getLogger(String.valueOf(EnderecoService.class));
    private final IEnderecoRepository enderecoRepository;

    public EnderecoService(IEnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public EnderecoEntity addEndereco(EnderecoEntity endereco){
        if(endereco != null){
            logger.info("Verificando se o endereço já esta cadastrado");
            return (EnderecoEntity) enderecoRepository.save(endereco);
        }
        logger.info("New endereço");
        return new EnderecoEntity();
    }

    public List<EnderecoEntity> listarEnderecos(){
        return enderecoRepository.findAll();
    }

    public EnderecoEntity atualizarEndereco(EnderecoEntity endereco){
        return enderecoRepository.saveAndFlush(endereco);
    }
}
