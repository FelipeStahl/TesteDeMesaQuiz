/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.entidade.Usuario;

/**
 *
 * @author Felipe-Sistema
 */
public interface UsuarioDao extends BaseDao{
    Usuario validarLogin(String usuario, String senha);
    
    Boolean usuarioExistente(String usuario);
}
