package br.com.projeto.blog.mongoblog.repositories;

import br.com.projeto.blog.mongoblog.domain.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
}