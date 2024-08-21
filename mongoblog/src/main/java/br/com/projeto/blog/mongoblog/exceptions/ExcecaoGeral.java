package br.com.projeto.blog.mongoblog.exceptions;

import java.io.Serializable;

public class ExcecaoGeral implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String descricaoDaExcecao;
	private Integer codigoDaExcecao;
	private String localDoRecurso;

    public ExcecaoGeral() {
    }

    public ExcecaoGeral(String descricaoDaExcecao, Integer codigoDaExcecao, String localDoRecurso) {
        this.descricaoDaExcecao = descricaoDaExcecao;
        this.codigoDaExcecao = codigoDaExcecao;
        this.localDoRecurso = localDoRecurso;
    }

    public String getDescricaoDaExcecao() {
        return descricaoDaExcecao;
    }

    public void setDescricaoDaExcecao(String descricaoDaExcecao) {
        this.descricaoDaExcecao = descricaoDaExcecao;
    }

    public Integer getCodigoDaExcecao() {
        return codigoDaExcecao;
    }

    public void setCodigoDaExcecao(Integer codigoDaExcecao) {
        this.codigoDaExcecao = codigoDaExcecao;
    }

    public String getLocalDoRecurso() {
        return localDoRecurso;
    }

    public void setLocalDoRecurso(String localDoRecurso) {
        this.localDoRecurso = localDoRecurso;
    }
}