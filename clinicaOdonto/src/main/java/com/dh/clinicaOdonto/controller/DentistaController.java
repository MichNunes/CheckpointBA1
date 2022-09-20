package com.dh.clinicaOdonto.controller;

import com.dh.clinicaOdonto.controller.dto.DentistaDTO;
import com.dh.clinicaOdonto.entity.AgendaEntity;
import com.dh.clinicaOdonto.entity.DentistaEntity;
import com.dh.clinicaOdonto.entity.UsuarioEntity;
import com.dh.clinicaOdonto.repository.IAgendaRepository;
import com.dh.clinicaOdonto.repository.IUsuarioRepository;
import com.dh.clinicaOdonto.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("dentista/")
public class DentistaController {
    @Autowired
    private IUsuarioRepository usuarioRepository;
    private IAgendaRepository agendaRepository;
    private final DentistaService dentistaService;

    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping("adicionar")
    public DentistaEntity adicionarDentista(@RequestBody DentistaDTO dentistaDTO) {
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
        return usuario.getDentista();
    }

    @GetMapping("listar")
    public List<DentistaEntity> listarDentista() {
        return dentistaService.listarDentista();
    }

    @GetMapping("{id}/consultas")
    public Optional<List<AgendaEntity>> listarConsultas(@PathVariable Long id) {
        return agendaRepository.findByDentista(new DentistaEntity(id));
    }

    @GetMapping("{id}/dados")
    public Optional<UsuarioEntity> listarDados(@PathVariable Long id) {
        return usuarioRepository.findByDentista(new DentistaEntity(id));
    }

    @DeleteMapping("{id}/excluir")
    public void excluirDentista(@PathVariable Long id) {
        dentistaService.excluirDentista(id);
    }

    @PutMapping("{id}/alterar")
    public O

}

