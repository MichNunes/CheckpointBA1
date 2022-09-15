package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.controller.dto.PacienteDTO;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.repository.IUsuarioRepository;
import com.dh.clinicaOdonto.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class PacienteController {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    private final PacienteService pacienteService;
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("paciente/adicionar")
    public PacienteEntity adicionarPaciente(@RequestBody PacienteDTO pacienteDTO){
        UsuarioEntity usuario = usuarioRepository.findById(pacienteDTO.getIdUsuario()).orElseThrow(EntityNotFoundException::new);

        if(usuario.getPaciente() != null){
           PacienteEntity existingPacient = usuario.getPaciente();
           existingPacient.setRg(pacienteDTO.getRg());
           usuarioRepository.save(usuario);
        }else{
            PacienteEntity paciente = new PacienteEntity();
            paciente.setRg(pacienteDTO.getRg());

            usuario.setPaciente(paciente);
            usuarioRepository.save(usuario);
        }

        return usuario.getPaciente();
    }

    @GetMapping("paciente/listar")
    public List<PacienteEntity> listarPacientes(){
        return pacienteService.listarPacientes();
    }
}
