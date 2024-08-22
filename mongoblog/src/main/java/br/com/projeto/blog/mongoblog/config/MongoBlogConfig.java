package br.com.projeto.blog.mongoblog.config;

import br.com.projeto.blog.mongoblog.domain.Postagem;
import br.com.projeto.blog.mongoblog.domain.Usuario;
import br.com.projeto.blog.mongoblog.dtos.UsuarioAutorDTO;
import br.com.projeto.blog.mongoblog.dtos.ComentarioDTO;
import br.com.projeto.blog.mongoblog.repositories.PostagemRepository;
import br.com.projeto.blog.mongoblog.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class MongoBlogConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

    @Autowired
    private PostagemRepository postagemRepository;
	
	@Override
	public void run(String... args) throws Exception {

		usuarioRepository.deleteAll();
        postagemRepository.deleteAll();

		Usuario usuario1 = new Usuario("Murici Ramalho", "murici.sp@example.com", "administrador");
		Usuario usuario2 = new Usuario("Andrez Sanchez", "andrez.sc@example.com", "usuario-comum");
		Usuario usuario3 = new Usuario("Leila Pereira", "leila.sep@example.com", "usuario-comum");
		Usuario usuario4 = new Usuario("John Textor", "textor.bfsa@example.com", "moderador");

		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3, usuario4));

        UsuarioAutorDTO autor1 = new UsuarioAutorDTO(usuario2.getNome(),usuario2.getEmail());
        UsuarioAutorDTO autor2 = new UsuarioAutorDTO(usuario3.getNome(),usuario3.getEmail());
        UsuarioAutorDTO autor3 = new UsuarioAutorDTO(usuario4.getNome(),usuario4.getEmail());
        UsuarioAutorDTO autor4 = new UsuarioAutorDTO(usuario1.getNome(),usuario1.getEmail());

        Postagem postagem1 = new Postagem(Instant.parse("2024-08-21T23:53:07Z"),"Palmeiras não tem mundial",autor1);
        Postagem postagem2 = new Postagem(Instant.parse("2024-08-21T23:54:29Z"),"Corinthians é maior do Brasil",autor2);
        Postagem postagem3 = new Postagem(Instant.parse("2024-08-21T23:56:17Z"),"Botafogo foi roubado",autor3);
        Postagem postagem4 = new Postagem(Instant.parse("2024-08-21T23:58:20Z"),"Estádio tá pago!",autor1);
        Postagem postagem5 = new Postagem(Instant.parse("2024-08-21T23:59:01Z"),"O porco é meu!",autor2);

        ComentarioDTO comentario1 = new ComentarioDTO("Perdeu 7 decisões na própria casa!",Instant.parse("2024-08-22T02:03:08Z"), autor4);
        ComentarioDTO comentario2 = new ComentarioDTO("Vou contratar o Duilio pra presidir o Palmeiras",Instant.parse("2024-08-22T02:04:01Z"), autor2);
        ComentarioDTO comentario3 = new ComentarioDTO("Oh my God!",Instant.parse("2024-08-22T02:03:08Z"), autor3);
        ComentarioDTO comentario4 = new ComentarioDTO("Papai Noel existe!",Instant.parse("2024-08-22T02:03:08Z"), autor1);

        ComentarioDTO comentario5 = new ComentarioDTO("São Paulo é pai do Palmeiras",Instant.parse("2024-08-22T03:23:01Z"), autor4);
        ComentarioDTO comentario6 = new ComentarioDTO("São Paulo é pato do Corinthians",Instant.parse("2024-08-22T03:34:10Z"), autor1);
        ComentarioDTO comentario7 = new ComentarioDTO("Vou denunciar pro Trump",Instant.parse("2024-08-22T03:53:02Z"), autor3);

        ComentarioDTO comentario8 = new ComentarioDTO("I don't believe!",Instant.parse("2024-08-22T04:33:02Z"), autor3);
        ComentarioDTO comentario9 = new ComentarioDTO("Murumbi?",Instant.parse("2024-08-22T04:43:03Z"), autor4);
        ComentarioDTO comentario10 = new ComentarioDTO("Murubambis",Instant.parse("2024-08-22T04:54:03Z"), autor2);

        postagem1.getComentarios().addAll(Arrays.asList(comentario1, comentario2, comentario3, comentario4));
        postagem2.getComentarios().addAll(Arrays.asList(comentario5, comentario6, comentario7));
        postagem3.getComentarios().addAll(Arrays.asList(comentario8, comentario9, comentario10));

        postagemRepository.saveAll(Arrays.asList(postagem1, postagem2, postagem3, postagem4, postagem5));

        usuario2.setPostagens(Arrays.asList(postagem1, postagem4));
        usuarioRepository.save(usuario2);

        usuario3.setPostagens(Arrays.asList(postagem2, postagem5));
        usuarioRepository.save(usuario3);

        usuario4.setPostagens(Arrays.asList(postagem3));
        usuarioRepository.save(usuario4);
	}
}