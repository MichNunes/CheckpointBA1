package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.entity.AgendaEntity;
import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.entity.EnderecoEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.repository.IAgendaRepository;
import com.dh.clinicaOdonto.repository.IEnderecoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EnderecoSerivce {

    private final IEnderecoRepository enderecoRepository;

    public EnderecoSerivce (IEnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public EnderecoEntity addEndereco(EnderecoEntity endereco){
        if(endereco != null){
            return (EnderecoEntity) enderecoRepository.save(endereco);
        }
        return new EnderecoEntity();
    }
}
