package br.com.projeto.blog.mongoblog.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nome;
	private String email;
	private String perfil;

	@DBRef(lazy = true)
	private List<Postagem> postagens = new ArrayList<>();

	public Usuario() {
	}

	public Usuario(String nome, String email, String perfil) {

		this.nome = nome;
		this.email = email;
		this.perfil = perfil;
	}

	public Usuario(String id, String nome, String email, String perfil, List<Postagem> postagens) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.perfil = perfil;
		setPostagens(postagens);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Usuario usuario)) return false;

        return getId().equals(usuario.getId());
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}
}