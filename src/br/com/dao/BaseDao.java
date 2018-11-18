/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Felipe-Sistema
 */
public interface BaseDao {
    public abstract void salvar(Object object) throws SQLException;
    
    void alterar (Object object) throws  SQLException;
    
    void excluir (Integer id) throws SQLException; 
    
    Object pesquisarPorId(Integer id) throws  SQLException;
    
    List pesquisar(String pesquisa) throws  SQLException;
    
    List listarTodos() throws  SQLException;
}
