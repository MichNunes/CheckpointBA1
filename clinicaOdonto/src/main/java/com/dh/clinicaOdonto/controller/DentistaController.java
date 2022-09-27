package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.controller.dto.DentistaDTO;
import com.dh.clinicaOdonto.entity.AgendaEntity;
import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.repository.IAgendaRepository;
import com.dh.clinicaOdonto.repository.IUsuarioRepository;
import com.dh.clinicaOdonto.service.DentistaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("dentista/")
public class DentistaController {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IAgendaRepository agendaRepository;
    private final DentistaService dentistaService;

    @PostMapping()
    public ResponseEntity<DentistaEntity> adicionarDentista(@RequestBody DentistaDTO dentistaDTO) {
        UsuarioEntity usuario = usuarioRepository.findById(dentistaDTO.getIdUsuario()).orElseThrow(EntityExistsException::new);

        if (usuario.getDentista() != null) {
            DentistaEntity existingDentista = usuario.getDentista();
            existingDentista.getMatricula();
        } else {
            DentistaEntity dentista = new DentistaEntity();
            dentista.setMatricula(dentistaDTO.getMatricula());

            usuario.setDentista(dentista);
            usuarioRepository.save(usuario);
        }
        return ResponseEntity.ok().body(usuario.getDentista());
    }

    @GetMapping()
    public ResponseEntity<List<DentistaEntity>> listarDentista() {
        return ResponseEntity.ok().body(dentistaService.listarDentista());
    }

    @GetMapping("{id}/consultas")
    public ResponseEntity<Optional<List<AgendaEntity>>> listarConsultas(@PathVariable Long id) {
        return ResponseEntity.ok().body(agendaRepository.findByDentista(new DentistaEntity(id)));
    }

    @GetMapping("{id}/dados")
    public ResponseEntity<Optional<UsuarioEntity>> listarDados(@PathVariable Long id) {
        return ResponseEntity.ok().body(usuarioRepository.findByDentista(new DentistaEntity(id)));
    }

    @DeleteMapping("{id}/excluir")
    public ResponseEntity<?> excluirDentista(@PathVariable Long id) {
        dentistaService.excluirDentista(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}/alterar")
    public ResponseEntity<DentistaEntity> alterarDentista(@RequestBody DentistaDTO dentistaDTO){
        return ResponseEntity.ok().body(dentistaService.alterarDentista(dentistaDTO.toEntity()));
    }

}

