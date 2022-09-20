package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.controller.dto.EnderecoDTO;
import com.dh.clinicaOdonto.controller.dto.PacienteDTO;
import com.dh.clinicaOdonto.entity.AgendaEntity;
import com.dh.clinicaOdonto.entity.PacienteEntity;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.repository.IAgendaRepository;
import com.dh.clinicaOdonto.repository.IEnderecoRepository;
import com.dh.clinicaOdonto.repository.IUsuarioRepository;
import com.dh.clinicaOdonto.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("paciente/")
public class PacienteController {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    private IAgendaRepository agendaRepository;
    private IEnderecoRepository enderecoRepository;
    private final PacienteService pacienteService;
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("adicionar")
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

    @GetMapping("listar")
    public List<PacienteEntity> listarPacientes(){
        return pacienteService.listarPacientes();
    }

    @GetMapping("{id}/consultas")
    public Optional<List<AgendaEntity>> listarConsultas(@PathVariable Long id){
        return agendaRepository.findByPaciente(new PacienteEntity(id));
    }

    @GetMapping("{id}/dados")
    public Optional<UsuarioEntity> listarDados(@PathVariable Long id){
        return usuarioRepository.findByPaciente(new PacienteEntity(id));
    }

    @GetMapping("{id}/enderecos")
    public Optional<Set<EnderecoDTO>> listarEnderecos(@PathVariable Long id){
        return enderecoRepository.findByPaciente(new PacienteEntity(id));
    }

    @DeleteMapping("{id}/excluir")
    public void excluirPaciente(@PathVariable Long id){
        pacienteService.excluirPaciente(id);
    }


    @PutMapping("alterar")
    public PacienteEntity alterarPaciente(@RequestBody PacienteEntity paciente){
        return pacienteService.alterarPaciente(paciente);
    }

}
