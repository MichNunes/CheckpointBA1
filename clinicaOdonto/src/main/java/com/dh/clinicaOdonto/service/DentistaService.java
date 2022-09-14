package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.entity.AgendaEntity;
import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.repository.IDentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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


}
