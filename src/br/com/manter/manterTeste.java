/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.manter;

import br.com.entidade.Teste;
import java.util.List;

/**
 *
 * @author Felipe-Sistema
 */
public class manterTeste {
    private static Teste teste;
    private static Integer numPerguntaAtual;
    private static Integer numPerguntaTotal;

    public static Integer getNumPerguntaTotal() {
        return numPerguntaTotal;
    }

    public static void setNumPerguntaTotal(Integer numPerguntaTotal) {
        manterTeste.numPerguntaTotal = numPerguntaTotal;
    }

    public static Integer getNumPerguntaAtual() {
        return numPerguntaAtual;
    }

    public static void setNumPerguntaAtual(Integer numPerguntaAtual) {
        manterTeste.numPerguntaAtual = numPerguntaAtual;
    }

    public static Teste getTeste() {
        return teste;
    }

    public static void setTeste(Teste teste) {
        manterTeste.teste = teste;
    }
    
}
