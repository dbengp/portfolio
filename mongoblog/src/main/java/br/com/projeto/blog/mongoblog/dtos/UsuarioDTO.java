package br.com.projeto.blog.mongoblog.dtos;

import br.com.projeto.blog.mongoblog.domain.Usuario;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String perfil;
	
	public UsuarioDTO(){}
	
	public UsuarioDTO(Usuario usuario){
		
		nome = usuario.getNome();
		perfil = usuario.getPerfil();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}