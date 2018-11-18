/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.entidade;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Felipe-Sistema
 */
public class Usuario_pergunta {
    private Integer id;
    private Boolean correto;
    private Date dataResposta;
    private List<Usuario> usuarios;
    private List<Pergunta> pergunta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getCorreto() {
        return correto;
    }

    public void setCorreto(Boolean correto) {
        this.correto = correto;
    }

    public Date getDataResposta() {
        return dataResposta;
    }

    public void setDataResposta(Date dataResposta) {
        this.dataResposta = dataResposta;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Pergunta> getPergunta() {
        return pergunta;
    }

    public void setPergunta(List<Pergunta> pergunta) {
        this.pergunta = pergunta;
    }
    
}
