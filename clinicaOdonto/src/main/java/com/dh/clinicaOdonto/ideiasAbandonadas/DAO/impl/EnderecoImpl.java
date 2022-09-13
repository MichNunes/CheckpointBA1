package com.dh.clinicaOdonto.ideiasAbandonadas.DAO.impl;

import com.dh.clinicaOdonto.ideiasAbandonadas.DAO.DAO;
import com.dh.clinicaOdonto.ideiasAbandonadas.model.Endereco;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EnderecoImpl implements DAO<Endereco> {

    @Override
    public Endereco salvar(Endereco endereco) throws SQLException {
        return null;
    }

    @Override
    public Endereco atualizar(Endereco endereco) throws SQLException {
        return null;
    }

    @Override
    public void excluir(Integer id) throws SQLException {

    }

    @Override
    public Optional<Endereco> procurar(Integer id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Endereco> listarTodos() throws SQLException {
        return null;
    }
}
