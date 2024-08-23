package br.com.projeto.blog.mongoblog.repositories;

import br.com.projeto.blog.mongoblog.domain.Postagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String> {
	
	List<Postagem> findByConteudoDaPostagemContainingIgnoreCase(String texto);
	
	List<Postagem> findByDataDaPostagemAfter(Instant data);
	
	@Query("{ $and: [ { dataDaPostagem: {$gte: ?1} }, { dataDaPostagem: { $lte: ?2} } , { $or: [ { 'conteudoDaPostagem': { $regex: ?0, $options: 'i' } }, { 'comentarios.conteudo': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Postagem> findTextoEmPostagemEComentariosEntreDatasDaPostagem(String texto, Instant dataMinima, Instant dataMaxima);
	
}