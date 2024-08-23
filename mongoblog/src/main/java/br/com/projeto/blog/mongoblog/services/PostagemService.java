package br.com.projeto.blog.mongoblog.services;

import br.com.projeto.blog.mongoblog.domain.Postagem;
import br.com.projeto.blog.mongoblog.exceptions.ExcecaoDeDocumentoMongodbNaoEncontrado;
import br.com.projeto.blog.mongoblog.repositories.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostagemService {

	@Autowired
	PostagemRepository postagemRepository;

	public Postagem findById(String id){
		try{
			Optional<Postagem> optionalPostagem = postagemRepository.findById(id);
			return optionalPostagem.get();
		}catch (NoSuchElementException e) {
			throw new ExcecaoDeDocumentoMongodbNaoEncontrado("Documento não encontrado no MongoDB");
		}
	}
	
	public List<Postagem> findByConteudoDaPostagemContainingIgnoreCase(String texto){
			
		return postagemRepository.findByConteudoDaPostagemContainingIgnoreCase(texto);
	}	
	
	public List<Postagem> findByDataDaPostagemAfter(String dataLimite){
		
		Instant data = Instant.parse(dataLimite);
		return postagemRepository.findByDataDaPostagemAfter(data);
	}
	
	public List<Postagem> findTextoEmPostagemEComentariosEntreDatasDaPostagem(String texto, String dataMinimaUtf8, String dataMaximaUtf8){
	
		Instant dataMinima = Instant.parse(dataMinimaUtf8);
		Instant dataMaxima = Instant.parse(dataMaximaUtf8);
		
		return postagemRepository.findTextoEmPostagemEComentariosEntreDatasDaPostagem(texto, dataMinima, dataMaxima);
	}

}