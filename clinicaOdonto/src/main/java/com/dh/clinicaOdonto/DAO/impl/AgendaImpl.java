package com.dh.clinicaOdonto.DAO.impl;

import com.dh.clinicaOdonto.DAO.DAO;
import com.dh.clinicaOdonto.model.Agenda;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AgendaImpl implements DAO<Agenda> {

    @Override
    public Agenda salvar(Agenda agenda) throws SQLException {
        return null;
    }

    @Override
    public Agenda atualizar(Agenda agenda) throws SQLException {
        return null;
    }

    @Override
    public void excluir(Integer id) throws SQLException {

    }

    @Override
    public Optional<Agenda> procurar(Integer id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Agenda> listarTodos() throws SQLException {
        return null;
    }
}
