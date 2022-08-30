package com.dh.clinicaOdonto.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConfiguracaoJDBC {

    private String jdbcDriver;
    private String url;
    private String usuario;
    private String senha;

    public ConfiguracaoJDBC(String jdbcDriver, String url, String usuario, String senha) {
        this.jdbcDriver = jdbcDriver;
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Connection getConnection() {
        Connection connection = null;

        try{
            Class.forName(this.jdbcDriver);
            connection = DriverManager.getConnection(this.url,this.usuario,this.senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
