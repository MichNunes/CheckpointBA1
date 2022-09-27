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
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("paciente/")
public class PacienteController {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IAgendaRepository agendaRepository;
    @Autowired
    private IEnderecoRepository enderecoRepository;
    private final PacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<PacienteEntity> adicionarPaciente(@RequestBody PacienteDTO pacienteDTO){
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

        return ResponseEntity.ok().body(usuario.getPaciente());
    }

    @GetMapping()
    public ResponseEntity<List<PacienteEntity>> listarPacientes(){
        return ResponseEntity.ok().body(pacienteService.listarPacientes());
    }

    @GetMapping("{id}/consultas")
    public ResponseEntity<Optional<List<AgendaEntity>>> listarConsultas(@PathVariable Long id){
        return ResponseEntity.ok().body(agendaRepository.findByPaciente(new PacienteEntity(id)));
    }

    @GetMapping("{id}/dados")
    public ResponseEntity<Optional<UsuarioEntity>> listarDados(@PathVariable Long id){
        return ResponseEntity.ok().body(usuarioRepository.findByPaciente(new PacienteEntity(id)));
    }

    @GetMapping("{id}/enderecos")
    public ResponseEntity<Optional<Set<EnderecoDTO>>> listarEnderecos(@PathVariable Long id){
        return ResponseEntity.ok().body(enderecoRepository.findByPaciente(new PacienteEntity(id)));
    }

    @DeleteMapping("{id}/excluir")
    public ResponseEntity<?> excluirPaciente(@PathVariable Long id){
        pacienteService.excluirPaciente(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping()
    public ResponseEntity<PacienteEntity> alterarPaciente(@RequestBody PacienteEntity paciente){
        return ResponseEntity.ok().body(pacienteService.alterarPaciente(paciente));
    }

}
