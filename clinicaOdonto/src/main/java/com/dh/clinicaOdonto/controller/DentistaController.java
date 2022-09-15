package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.controller.dto.DentistaDTO;
import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.repository.IUsuarioRepository;
import com.dh.clinicaOdonto.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityExistsException;
import java.util.List;

@RestController
public class DentistaController {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    private final DentistaService dentistaService;
    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping("dentista/adicionar")
    public DentistaEntity adicionarDentista(@RequestBody DentistaDTO dentistaDTO){
        UsuarioEntity usuario = usuarioRepository.findById(dentistaDTO.getIdUsuario()).orElseThrow(EntityExistsException::new);

        if (usuario.getDentista() != null){
            DentistaEntity existingDentista = usuario.getDentista();
            existingDentista.getMatricula();
        }
        else {
            DentistaEntity dentista = new DentistaEntity();
            dentista.setMatricula(dentistaDTO.getMatricula());

            usuario.setDentista(dentista);
            usuarioRepository.save(usuario);
        }
        return  usuario.getDentista();
    }

    @GetMapping("dentista/listar")
    public List<DentistaEntity> listarDentista(){
        return dentistaService.listarDentista();
    }

}
