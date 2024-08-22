package br.com.projeto.blog.mongoblog.repositories;

import br.com.projeto.blog.mongoblog.domain.Postagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String> {
	
}