package com.dh.clinicaOdonto.service;

import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.repository.IDentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class DentistaService {
    private static Logger logger = Logger.getLogger(String.valueOf(DentistaService.class));
    private final IDentistaRepository dentistaRepository;
    @Autowired
    public DentistaService (IDentistaRepository dentistaRepository){
        this.dentistaRepository = dentistaRepository;
    }

    public DentistaEntity addDentista(DentistaEntity dentista){
        if(dentista != null){
            logger.info("Verificando se o dentista foi cadastrado.");
            return (DentistaEntity) dentistaRepository.save(dentista);
        }
        logger.info("Novo dentista cadastrado");
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
