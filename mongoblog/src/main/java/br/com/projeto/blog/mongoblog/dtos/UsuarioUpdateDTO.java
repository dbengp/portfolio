package br.com.projeto.blog.mongoblog.dtos;

import br.com.projeto.blog.mongoblog.domain.Usuario;

import java.io.Serializable;

public class UsuarioUpdateDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;
	private String perfil;
	
	public UsuarioUpdateDTO(){}
	
	public UsuarioUpdateDTO(Usuario usuario){
		
		email = usuario.getEmail();
		perfil = usuario.getPerfil();
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}