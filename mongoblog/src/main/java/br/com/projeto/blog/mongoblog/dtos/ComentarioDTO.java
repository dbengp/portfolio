package br.com.projeto.blog.mongoblog.dtos;

import java.io.Serializable;
import java.time.Instant;

public class ComentarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String conteudo;
	private Instant data;
	private UsuarioAutorDTO autor;

	public ComentarioDTO() { }

	public ComentarioDTO(String conteudo, Instant data, UsuarioAutorDTO autor) {
		this.conteudo = conteudo;
		this.data = data;
		this.autor = autor;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public UsuarioAutorDTO getAutor() {
		return autor;
	}

	public void setAutor(UsuarioAutorDTO autor) {
		this.autor = autor;
	}
}