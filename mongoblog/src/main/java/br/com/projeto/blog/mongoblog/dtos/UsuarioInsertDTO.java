package br.com.projeto.blog.mongoblog.dtos;

import br.com.projeto.blog.mongoblog.domain.Usuario;

import java.io.Serializable;

public class UsuarioInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String email;
	private String perfil;
	
	public UsuarioInsertDTO(){}
	
	public UsuarioInsertDTO(Usuario usuario){
		
		nome = usuario.getNome();
		email = usuario.getEmail();
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Usuario obterUsuarioDoDTO(){
		
		Usuario usuario = new Usuario();
		usuario.setNome(getNome());
		usuario.setEmail(getEmail());
		usuario.setPerfil(getPerfil());
		
		return usuario;
	}
}