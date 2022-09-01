package com.dh.clinicaOdonto.DAO.impl;

import com.dh.clinicaOdonto.DAO.ConfiguracaoJDBC;
import com.dh.clinicaOdonto.DAO.DAO;
import com.dh.clinicaOdonto.model.Usuario;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.logging.log4j.LogManager.getLogger;

public class UsuarioImpl implements DAO<Usuario> {

    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = getLogger(UsuarioImpl.class);

    @Override
    public Usuario salvar(Usuario usuario) throws SQLException {
        log.info("Abrindo conexão;");
        String query = String.format("INSERT INTO Usuario (usuario,senha,nome,sobrenome,idTipoUsuario" +
                "VALUES ('%s','%s','%s','%s',%s)", usuario.getUsuario(),usuario.getSenha(),usuario.getNome(),usuario.getSobrenome(),usuario.getIdTipoUsuario());

        Connection connection;
        Statement statement = null;

        try{
            log.info("Salvando usuario: user="+usuario.getUsuario()+" || tipoUsuario="+usuario.getIdTipoUsuario());
            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver","jdbc:h2:~/test;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM './src/main/java/com.dh.clinicaOdonto/initDB.sql'", "sa","");
            connection = configuracaoJDBC.getConnection();
            statement = connection.createStatement();
            statement.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()){
                usuario.setId(rs.getInt(1));
                log.info("Usuario salvo; id="+rs.getInt(1));
            }
        } catch (SQLException throwables){
            log.error("Erro salvar: "+ throwables.getMessage());
            throwables.printStackTrace();
        } finally {
            log.info("Fechando conexão;");
            assert statement != null;
            statement.close();
        }

        return usuario;
    }

    @Override
    public Usuario atualizar(Usuario usuario) throws SQLException{
        log.info("Abrindo conexão;");
        String query = String.format("UPDATE usuario SET usuario = '%s', senha = '%s', nome = '%s', sobrenome = '%s' WHERE id = %s;",
                usuario.getUsuario(),usuario.getSenha(),usuario.getSenha(),usuario.getNome(),usuario.getId());

        Connection connection;
        Statement statement = null;

        try {
            log.info("Alterando o valor do usuario id=" + usuario.getId());
            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver","jdbc:h2:~/test;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM './src/main/java/com.dh.clinicaOdonto/initDB.sql'", "sa","");
            connection = configuracaoJDBC.getConnection();
            statement = connection.createStatement();
            statement.execute(query);
            log.info("Sucesso na alteração;");
        } catch (SQLException throwables) {
            log.error("Erro ao alterar o usuario: "+ throwables.getMessage());
            throwables.printStackTrace();
        } finally {
            log.info("Fechando conexão");
            assert statement != null;
            statement.close();
        }
        return usuario;
    }

    @Override
    public void excluir(Integer id)  throws SQLException{
        log.info("Abrindo conexão;");
        String query = String.format("DELETE FROM usuario where id= %s", id);

        Connection connection = null;
        Statement statement = null;
        try {
            log.info("Deletando usuario com id= "+id);
            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver","jdbc:h2:~/test;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM './src/main/java/com.dh.clinicaOdonto/initDB.sql'", "sa","");
            connection = configuracaoJDBC.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
            log.info("Usuario deletado;");
        } catch (SQLException throwables){
            log.error("Erro ao deletar usuario: "+throwables.getMessage());
            throwables.printStackTrace();
        } finally {
            log.info("Fechando conexão;");
            assert statement != null;
            statement.close();
        }
    }

    @Override
    public Optional<Usuario> procurar(Integer id)  throws SQLException{
        log.info("Abrindo conexão;");
        String query = String.format("SELECT * FROM produto where id= %s", id);

        Connection connection = null;
        Statement statement = null;
        Usuario usuario = null;
        try{
            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver","jdbc:h2:~/test;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM './src/main/java/com.dh.clinicaOdonto/initDB.sql'", "sa","");
            connection = configuracaoJDBC.getConnection();
            log.debug("Buscando produto por id: "+id);
            statement = connection.createStatement();
            ResultSet resultado = statement.executeQuery(query);

            while(resultado.next()){
                usuario = criarObjetoUsuario(resultado);
            }

        }catch (SQLException throwables){
            log.error("Erro ao procurar usuario: "+throwables.getMessage());
            throwables.printStackTrace();
        }finally {
            log.info("Fechando conexão;");
            assert statement != null;
            statement.close();
        }
        return usuario != null ? Optional.of(usuario) : Optional.empty();
    }

    @Override
    public List<Usuario> listarTodos()  throws SQLException{
        log.debug("Abrindo uma conexão no banco");
        String query = "SELECT * FROM produto";

        Connection connection = null;
        Statement statement = null;
        List<Usuario> usuarios = new ArrayList<>();
        try{
            configuracaoJDBC = new ConfiguracaoJDBC("org.h2.Driver","jdbc:h2:~/test;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM './src/main/java/com.dh.clinicaOdonto/initDB.sql'", "sa","");
            connection = configuracaoJDBC.getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            log.debug("Buscando todos os usuarios do banco");

            while(rs.next()){
                usuarios.add(criarObjetoUsuario(rs));
            }
        }catch(SQLException throwables){
            log.error("Erro ao listar usuarios: "+throwables.getMessage());
            throwables.printStackTrace();
        }finally {
            log.info("Fechando conexão;");
            assert statement != null;
            statement.close();
        }

        return usuarios;
    }

    private Usuario criarObjetoUsuario(ResultSet resultSet) throws SQLException{
        Integer id = resultSet.getInt("id");
        String usuario = resultSet.getString("usuario");
        String senha = resultSet.getString("senha");
        String nome = resultSet.getString("nome");
        String sobrenome = resultSet.getString("sobrenome");
        Integer idTipoUsuario = resultSet.getInt("idTipoUsuario");
        return new Usuario(id, usuario, senha, nome, sobrenome, idTipoUsuario);
    }
}
