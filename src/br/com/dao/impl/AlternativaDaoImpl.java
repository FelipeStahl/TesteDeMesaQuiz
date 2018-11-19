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
public class AlternativaDaoImpl implements AlternativaDao {

    private Connection conexao;

    @Override
    public void salvar(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int salvarId(Object object) throws SQLException {
        try {
            Alternativa alternativa = (Alternativa)object;
            conexao = ConnectionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("insert into alternativa (descricao, pergunta_id, verdadeiro) values (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, alternativa.getDescricao());
            statement.setInt(2, alternativa.getPergunta().getId());      
            statement.setBoolean(3, alternativa.getVerdadeiro());      
            return statement.executeUpdate();
        } catch (Exception e) {
            return 0;
        }finally{
            conexao.close();
        }
    }

    @Override
    public void alterar(Object object) throws SQLException {
        try {
            Alternativa alternativa = (Alternativa)object;
            conexao = ConnectionFactory.getConnection();
            PreparedStatement statement = conexao.prepareStatement("update alternativa set descricao = ?, verdadeiro = ? where id = ?;", Statement.RETURN_GENERATED_KEYS);
            
            statement.setString(1, alternativa.getDescricao());
            statement.setBoolean(2, alternativa.getVerdadeiro());
            statement.setInt(3, alternativa.getId());      
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
