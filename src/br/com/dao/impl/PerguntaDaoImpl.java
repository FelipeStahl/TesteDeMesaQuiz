/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.impl;

import br.com.conexao.ConnectionFactory;
import br.com.dao.PerguntaDao;
import br.com.entidade.Alternativa;
import br.com.entidade.Pergunta;
import br.com.entidade.Usuario_pergunta;
import br.com.manter.manterTeste;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Felipe-Sistema
 */
public class PerguntaDaoImpl implements PerguntaDao{

    private Connection conexao;
    
    @Override
    public void salvar(Object object) throws SQLException {
        try {
            Pergunta pergunta = (Pergunta)object;
            conexao = ConnectionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("insert into pergunta (descricao, nivel, teste_id) values (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, pergunta.getDescricao());
            statement.setInt(2, pergunta.getNivel());
            statement.setInt(3, manterTeste.getTeste().getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexao.close();
        }
    }
    
    public int salvarId(Object object) throws SQLException {
        try {
            Pergunta pergunta = (Pergunta)object;
            conexao = ConnectionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("insert into pergunta (descricao, nivel, teste_id) values (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, pergunta.getDescricao());
            statement.setInt(2, pergunta.getNivel());
            statement.setInt(3, manterTeste.getTeste().getId()); 
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
                if(rs.next())
                {
                    int ultimoId = rs.getInt(1);
                    System.out.println(ultimoId);
                    return ultimoId;
                }
                return 0;
        } catch (Exception e) {
            return 0;
        }finally{
            conexao.close();
        }
    }

    @Override
    public void alterar(Object object) throws SQLException {
        try {
            Pergunta pergunta = (Pergunta)object;
            conexao = ConnectionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("update pergunta set descricao = ?, nivel = ? where id = ?;", Statement.RETURN_GENERATED_KEYS);           
            statement.setString(1, pergunta.getDescricao());
            statement.setInt(2, pergunta.getNivel());
            statement.setInt(3, pergunta.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
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
        try {
            conexao = ConnectionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM pergunta;");           
            ResultSet rs = statement.executeQuery();
            List<Pergunta> perguntas = new ArrayList();
            while(rs.next()){
                Pergunta pergunta = new Pergunta();
                pergunta.setId(rs.getInt("id"));
                pergunta.setDescricao(rs.getString("descricao"));
                pergunta.setNivel(rs.getInt("nivel"));
//                usuario.setNascimento(rs.getDate("nascimento"));
//                usuarios.add(usuario);               
            }
            return perguntas;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexao.close();
        }
        return null;
    }

    @Override
    public List pesquisar(String pesquisa) throws SQLException {
        try {
            conexao = ConnectionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM pergunta WHERE teste_id = '"+ pesquisa +"';");           
            ResultSet rs = statement.executeQuery();
            List<Pergunta> perguntas = new ArrayList();
            while(rs.next()){
                Pergunta pergunta = new Pergunta();
                pergunta.setId(rs.getInt("id"));
                pergunta.setDescricao(rs.getString("descricao"));
                pergunta.setNivel(rs.getInt("nivel"));
                
                AlternativaDaoImpl alternativaDao = new AlternativaDaoImpl();
                String valor = String.valueOf(rs.getInt("id"));
                List<Alternativa> alternativas = alternativaDao.pesquisar(valor);
                pergunta.setAlternativas(alternativas);
                
                Usuario_perguntaDaoImpl usuario_pergunta = new Usuario_perguntaDaoImpl();
                pergunta.setUsuario_pergunta((Usuario_pergunta)usuario_pergunta.pesquisarPorId(rs.getInt("id")));
                perguntas.add(pergunta);
            }
            return perguntas;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexao.close();
        }
        return null;
    }
    
}
