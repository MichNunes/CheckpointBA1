package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.controller.dto.DentistaDTO;
import com.dh.clinicaOdonto.controller.dto.PacienteDTO;
import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.entity.EnderecoEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.repository.IAgendaRepository;
import com.dh.clinicaOdonto.repository.IDentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DentistaService {
    private final IDentistaRepository dentistaRepository;
    @Autowired
    public DentistaService (IDentistaRepository dentistaRepository){
        this.dentistaRepository = dentistaRepository;
    }

    public DentistaEntity addDentista(DentistaEntity dentista){
        if(dentista != null){
            return (DentistaEntity) dentistaRepository.save(dentista);
        }

        return new DentistaEntity();
    }


    public List<DentistaEntity> listarDentista(){
        return dentistaRepository.findAll();
    }

    public void excluirDentista(Long id){
        dentistaRepository.deleteById(id);
    }

    public DentistaEntity alterarDentista(DentistaEntity dentista){
        return dentistaRepository.saveAndFlush(dentista);
    }





}
