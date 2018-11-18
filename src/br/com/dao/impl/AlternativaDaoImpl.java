/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.impl;

import br.com.conexao.ConnectionFactory;
import br.com.dao.AlternativaDao;
import br.com.entidade.Alternativa;
import br.com.entidade.Pergunta;
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
public class AlternativaDaoImpl implements AlternativaDao {

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
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM alternativa WHERE id = ?;");           
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Alternativa alternativa = new Alternativa();
                alternativa.setId(rs.getInt("id"));
                alternativa.setDescricao(rs.getString("descricao"));
                return alternativa;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List pesquisar(String pesquisa) throws SQLException {
        try {
            conexao = ConnectionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("SELECT * FROM alternativa WHERE pergunta_id = '"+ pesquisa +"';");           
            ResultSet rs = statement.executeQuery();
            List<Alternativa> alternativas = new ArrayList();
            while(rs.next()){
                Alternativa alternativa = new Alternativa();
                alternativa.setId(rs.getInt("id"));
                alternativa.setDescricao(rs.getString("descricao"));
                alternativa.setVerdadeiro(rs.getBoolean("verdadeiro"));
                alternativas.add(alternativa);
            }
            return alternativas;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            conexao.close();
        }
        return null;
    }

}
