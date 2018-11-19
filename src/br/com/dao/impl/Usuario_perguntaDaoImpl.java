/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.impl;

import br.com.conexao.ConnectionFactory;
import br.com.dao.Usuario_perguntaDao;
import br.com.entidade.Usuario_pergunta;
import br.com.manter.manterUsuarioLogado;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.Date;
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
public class Usuario_perguntaDaoImpl implements Usuario_perguntaDao {

    private Connection conexao;

    @Override
    public void salvar(Object object) throws SQLException {
        try {
            Usuario_pergunta usuario_pergunta = (Usuario_pergunta)object;
            
            conexao = ConnectionFactory.getConnection();
            //NamedParameterStatement p = new NamedParameterStatement();
            PreparedStatement statement = conexao.prepareStatement("insert into usuario_pergunta (usuario_id, pergunta_id, correto) values (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);           
            statement.setInt(1, usuario_pergunta.getUsuario().getId());
            statement.setInt(2, usuario_pergunta.getPergunta().getId());
            statement.setBoolean(3, usuario_pergunta.getCorreto());
            statement.executeUpdate();
            //System.out.println(executeUpdate);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            conexao.close();
        }
    }

    @Override
    public void alterar(Object object) throws SQLException {
        try {
            Usuario_pergunta usuario_pergunta = (Usuario_pergunta)object;
            
            conexao = ConnectionFactory.getConnection();
            //NamedParameterStatement p = new NamedParameterStatement();
            PreparedStatement statement = conexao.prepareStatement("update usuario_pergunta set correto = ? where pergunta_id = ?;", Statement.RETURN_GENERATED_KEYS);           
            statement.setBoolean(1, usuario_pergunta.getCorreto());
            statement.setInt(2, usuario_pergunta.getPergunta().getId());
            statement.executeUpdate();           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            conexao.close();
        }       
    }

    @Override
    public void excluir(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object pesquisarPorId(Integer idPergunta) throws SQLException {
        try {
            conexao = ConnectionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM usuario_pergunta WHERE usuario_id = ? AND pergunta_id = ?;");
            statement.setInt(1, manterUsuarioLogado.getUsuario().getId());
            statement.setInt(2, idPergunta);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Usuario_pergunta usuario_pergunta = new Usuario_pergunta();
                usuario_pergunta.setId(rs.getInt("id"));
                usuario_pergunta.setCorreto(rs.getBoolean("correto"));
                return usuario_pergunta;
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
    public List listarTodos() throws SQLException {
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        try {
//            conexao = ConnectionFactory.getConnection();
//            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM pergunta;");
//            ResultSet rs = statement.executeQuery();
//            List<Pergunta> perguntas = new ArrayList();
//            while (rs.next()) {
//                Pergunta pergunta = new Pergunta();
//                pergunta.setId(rs.getInt("id"));
//                pergunta.setDescricao(rs.getString("descricao"));
//                pergunta.setNivel(rs.getInt("nivel"));
////                usuario.setNascimento(rs.getDate("nascimento"));
////                usuarios.add(usuario);               
//            }
//            return perguntas;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            conexao.close();
//        }
//        return null;
    }

    @Override
    public List pesquisar(String pesquisa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
