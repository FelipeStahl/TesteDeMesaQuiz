/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.manter;

import br.com.entidade.Usuario;

/**
 *
 * @author Felipe-Sistema
 */
public class manterUsuarioLogado {
    private static Usuario usuario;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        manterUsuarioLogado.usuario = usuario;
    }
    
}
