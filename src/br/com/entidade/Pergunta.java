/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entidade;

import java.util.List;

/**
 *
 * @author Felipe-Sistema
 */
public class Pergunta {
    private Integer id;
    private String descricao;
    private Integer nivel;
    private Teste teste;
    private List<Alternativa> alternativas;
    private Usuario_pergunta usuario_pergunta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Teste getTeste() {
        return teste;
    }

    public void setTeste(Teste teste) {
        this.teste = teste;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public Usuario_pergunta getUsuario_pergunta() {
        return usuario_pergunta;
    }

    public void setUsuario_pergunta(Usuario_pergunta usuario_pergunta) {
        this.usuario_pergunta = usuario_pergunta;
    }
    
    
}
