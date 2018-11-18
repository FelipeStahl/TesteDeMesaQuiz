/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.impl;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Felipe-Sistema
 */
public class UsuarioDaoImplTest {
    
    public UsuarioDaoImplTest() {
        //testValidarLogin();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of salvar method, of class UsuarioDaoImpl.
     */
    //@Test
    public void testSalvar() throws Exception {
        System.out.println("salvar");
        Object object = null;
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        instance.salvar(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class UsuarioDaoImpl.
     */
    //@Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        Object object = null;
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        instance.alterar(object);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class UsuarioDaoImpl.
     */
    //@Test
    public void testExcluir() throws Exception {
        System.out.println("excluir");
        Integer id = null;
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        instance.excluir(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pesquisarPorId method, of class UsuarioDaoImpl.
     */
   // @Test
    public void testPesquisarPorId() throws Exception {
        System.out.println("pesquisarPorId");
        Integer id = null;
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        Object expResult = null;
        Object result = instance.pesquisarPorId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodos method, of class UsuarioDaoImpl.
     */
    //@Test
    public void testListarTodos() throws Exception {
        System.out.println("listarTodos");
        UsuarioDaoImpl instance = new UsuarioDaoImpl();
        List expResult = null;
        List result = instance.listarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarLogin method, of class UsuarioDaoImpl.
     */
    @Test
    public void testValidarLogin() {
        UsuarioDaoImpl usuariodao = new UsuarioDaoImpl();
        usuariodao.validarLogin("admin", "admin");
//        System.out.println("validarLogin");
//        String nome = "";
//        String senha = "";
//        UsuarioDaoImpl instance = new UsuarioDaoImpl();
//        Boolean expResult = null;
//        Boolean result = instance.validarLogin(nome, senha);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
