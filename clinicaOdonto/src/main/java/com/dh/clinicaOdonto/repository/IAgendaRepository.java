package com.dh.clinicaOdonto.repository;

import com.dh.clinicaOdonto.entity.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface IAgendaRepository extends JpaRepository<AgendaEntity, Long> {
    @Query("Select agenda a From Agenda where a.id_paciente = ?1")
    Optional<AgendaEntity> findConsultasByPaciente(Long pacientID);

    @Query("Select agenda a From Agenda where a.id_dentista = ?1")
    Optional<AgendaEntity> findConsultasByDentista(Long pacientID);

    @Query("Update Agenda SET data_consulta = ? where id_agenda = ?")
    Optional<AgendaEntity> updateDataConsulta(LocalDate novaData, Long agendaID);
}
