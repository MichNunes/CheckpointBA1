package com.dh.clinicaOdonto.DAO.impl;

import com.dh.clinicaOdonto.DAO.DAO;
import com.dh.clinicaOdonto.model.Dentista;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DentistaImpl implements DAO<Dentista> {

    @Override
    public Dentista salvar(Dentista dentista) throws SQLException {
        return null;
    }

    @Override
    public Dentista atualizar(Dentista dentista) throws SQLException {
        return null;
    }

    @Override
    public void excluir(Integer id) throws SQLException {

    }

    @Override
    public Optional<Dentista> procurar(Integer id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Dentista> listarTodos() throws SQLException {
        return null;
    }
}
