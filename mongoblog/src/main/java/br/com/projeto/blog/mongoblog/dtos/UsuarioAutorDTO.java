package br.com.projeto.blog.mongoblog.dtos;

import java.io.Serializable;

public class UsuarioAutorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;

    public UsuarioAutorDTO() { }

    public UsuarioAutorDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
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
}
