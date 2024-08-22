package br.com.projeto.blog.mongoblog.domain;

import br.com.projeto.blog.mongoblog.dtos.ComentarioDTO;
import br.com.projeto.blog.mongoblog.dtos.UsuarioAutorDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "postagens")
public class Postagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Instant dataDaPostagem;
    private String conteudoDaPostagem;
    private UsuarioAutorDTO autorDaPostagem;
    private List<ComentarioDTO> comentarios = new ArrayList<>();

    public Postagem() {  }

    public Postagem(Instant dataDaPostagem, String conteudoDaPostagem, UsuarioAutorDTO autorDaPostagem) {

        this.dataDaPostagem = dataDaPostagem;
        this.conteudoDaPostagem = conteudoDaPostagem;
        setAutorDaPostagem(autorDaPostagem);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getDataDaPostagem() {
        return dataDaPostagem;
    }

    public void setDataDaPostagem(Instant dataDaPostagem) {
        this.dataDaPostagem = dataDaPostagem;
    }

    public String getConteudoDaPostagem() {
        return conteudoDaPostagem;
    }

    public void setConteudoDaPostagem(String conteudoDaPostagem) {
        this.conteudoDaPostagem = conteudoDaPostagem;
    }

    public UsuarioAutorDTO getAutorDaPostagem() {
        return autorDaPostagem;
    }

    public void setAutorDaPostagem(UsuarioAutorDTO autorDaPostagem) {
        this.autorDaPostagem = autorDaPostagem;
    }

    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Postagem postagem)) return false;

        return getId().equals(postagem.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
