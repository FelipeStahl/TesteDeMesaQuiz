/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.impl;

import br.com.conexao.ConnectionFactory;
import br.com.dao.UsuarioDao;
import br.com.entidade.Usuario;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe-Sistema
 */
public class UsuarioDaoImpl implements UsuarioDao {

    private Connection conexao;

    @Override
    public void salvar(Object object) throws SQLException {
        try {
            Usuario usuario = (Usuario) object;
            conexao = ConnectionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("insert into usuario (nome, senha) values (?, ?);", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSenha());
            statement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            conexao.close();
        }
    }

    @Override
    public void alterar(Object object) throws SQLException {
        try {
            Usuario usuario = (Usuario) object;
            conexao = ConnectionFactory.getConnection();
            //NamedParameterStatement p = new NamedParameterStatement();
            PreparedStatement statement = conexao.prepareStatement("update usuario set pontos = ? where id = ?;", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, usuario.getPontos());
            statement.setInt(2, usuario.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            conexao.close();
        }
    }

    @Override
    public void excluir(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object pesquisarPorId(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario validarLogin(String nome, String senha) {
        try {
            conexao = ConnectionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM usuario WHERE nome = ? AND senha = ?;");
            statement.setString(1, nome);
            statement.setString(2, senha);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setPontos(rs.getInt("pontos"));
                usuario.setAdmin(rs.getBoolean("admin"));
                return usuario;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public List pesquisar(String pesquisa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean usuarioExistente(String usuario) {
        try {
            conexao = ConnectionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM usuario WHERE nome = ?;");
            statement.setString(1, usuario);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    

}
