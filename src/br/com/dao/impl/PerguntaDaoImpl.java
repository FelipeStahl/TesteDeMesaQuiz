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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
