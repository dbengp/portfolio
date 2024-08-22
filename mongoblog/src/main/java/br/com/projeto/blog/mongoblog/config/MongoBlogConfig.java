package br.com.projeto.blog.mongoblog.config;

import br.com.projeto.blog.mongoblog.domain.Postagem;
import br.com.projeto.blog.mongoblog.domain.Usuario;
import br.com.projeto.blog.mongoblog.dtos.UsuarioAutorDTO;
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


        Postagem postagem1 = new Postagem(Instant.parse("2024-08-22T23:53:07Z"),"Palmeiras não tem mundial",autor1);
        Postagem postagem2 = new Postagem(Instant.parse("2024-08-22T23:54:29Z"),"Corinthians é maior do Brasil",autor2);
        Postagem postagem3 = new Postagem(Instant.parse("2024-08-22T23:56:17Z"),"Botafogo foi roubado",autor3);
        Postagem postagem4 = new Postagem(Instant.parse("2024-08-22T23:58:20Z"),"Estádio tá pago!",autor1);
        Postagem postagem5 = new Postagem(Instant.parse("2024-08-22T23:59:01Z"),"O porco é meu!",autor2);

        postagemRepository.saveAll(Arrays.asList(postagem1, postagem2, postagem3, postagem4, postagem5));

        usuario2.setPostagens(Arrays.asList(postagem1, postagem4));
        usuarioRepository.save(usuario2);

        usuario3.setPostagens(Arrays.asList(postagem2, postagem5));
        usuarioRepository.save(usuario3);

        usuario4.setPostagens(Arrays.asList(postagem3));
        usuarioRepository.save(usuario4);
	}
}