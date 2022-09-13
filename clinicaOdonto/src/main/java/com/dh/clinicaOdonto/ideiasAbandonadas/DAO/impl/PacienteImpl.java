package com.dh.clinicaOdonto.ideiasAbandonadas.DAO.impl;

import com.dh.clinicaOdonto.ideiasAbandonadas.DAO.DAO;
import com.dh.clinicaOdonto.ideiasAbandonadas.model.Paciente;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PacienteImpl implements DAO<Paciente> {

    @Override
    public Paciente salvar(Paciente paciente) throws SQLException {
        return null;
    }

    @Override
    public Paciente atualizar(Paciente paciente) throws SQLException {
        return null;
    }

    @Override
    public void excluir(Integer id) throws SQLException {

    }

    @Override
    public Optional<Paciente> procurar(Integer id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Paciente> listarTodos() throws SQLException {
        return null;
    }
}
