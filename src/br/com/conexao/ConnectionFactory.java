/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Felipe-Sistema
 */
public class ConnectionFactory {
    public static Connection getConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/testedemesabd", "root", "root");
    }
}
