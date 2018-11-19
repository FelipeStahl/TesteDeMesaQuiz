/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.impl;

import br.com.conexao.ConnectionFactory;
import br.com.dao.TesteDao;
import br.com.entidade.Pergunta;
import br.com.entidade.Teste;
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
public class TesteDaoImpl implements TesteDao {

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
        try {
            conexao = ConnectionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM teste WHERE id = ?;");           
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Teste teste = new Teste();
                teste.setId(rs.getInt("id"));
                teste.setNome(rs.getString("nome"));
                PerguntaDaoImpl perguntaDao = new PerguntaDaoImpl();
                String pesquisa = String.valueOf(rs.getInt("id"));
                List<Pergunta> perguntas = perguntaDao.pesquisar(pesquisa);
                teste.setPerguntas(perguntas);
                return teste;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexao.close();
        }
        return null;
    }

    @Override
    public List listarTodos() throws SQLException {
        try {
            conexao = ConnectionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM teste;");
            ResultSet rs = statement.executeQuery();
            List<Teste> testes = new ArrayList();
            while (rs.next()) {
                Teste teste = new Teste();
                teste.setId(rs.getInt("id"));
                teste.setNome(rs.getString("nome"));
                PerguntaDaoImpl perguntaDao = new PerguntaDaoImpl();
                String pesquisa = String.valueOf(rs.getInt("id"));
                List<Pergunta> perguntas = perguntaDao.pesquisar(pesquisa);
                teste.setPerguntas(perguntas);
                testes.add(teste);
            }
            return testes;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return null;
    }

    @Override
    public List pesquisar(String pesquisa) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
