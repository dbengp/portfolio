package br.com.projeto.blog.mongoblog.services;

import br.com.projeto.blog.mongoblog.domain.Postagem;
import br.com.projeto.blog.mongoblog.exceptions.ExcecaoDeDocumentoMongodbNaoEncontrado;
import br.com.projeto.blog.mongoblog.repositories.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}