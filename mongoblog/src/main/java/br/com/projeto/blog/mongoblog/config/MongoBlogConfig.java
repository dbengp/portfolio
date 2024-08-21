package br.com.projeto.blog.mongoblog.config;

import br.com.projeto.blog.mongoblog.domain.Usuario;
import br.com.projeto.blog.mongoblog.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MongoBlogConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {

		usuarioRepository.deleteAll();
		
		Usuario usuario1 = new Usuario(null, "Ana Santos", "ana.santos@example.com", "administrador");
		Usuario usuario2 = new Usuario(null, "Pedro Gomes", "pedro.gomes@example.com", "usuario-comum");
		Usuario usuario3 = new Usuario(null, "Maria Souza", "maria.souza@example.com", "usuario-comum");
		Usuario usuario4 = new Usuario(null, "João da Silva", "joao.silva@example.com", "moderador");

		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3, usuario4));
	}
}