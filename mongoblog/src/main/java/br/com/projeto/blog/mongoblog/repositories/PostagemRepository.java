package br.com.projeto.blog.mongoblog.repositories;

import br.com.projeto.blog.mongoblog.domain.Postagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String> {
	
	List<Postagem> findByConteudoDaPostagemContainingIgnoreCase(String texto);
	
	List<Postagem> findByDataDaPostagemAfter(Instant data);
	
}