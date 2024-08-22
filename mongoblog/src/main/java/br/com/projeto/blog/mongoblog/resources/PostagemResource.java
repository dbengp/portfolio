package br.com.projeto.blog.mongoblog.resources;

import br.com.projeto.blog.mongoblog.domain.Postagem;
import br.com.projeto.blog.mongoblog.services.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/postagens")
public class PostagemResource {
	
	@Autowired
	PostagemService postagemService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Postagem> findById(@PathVariable String id){

		Postagem postagem = postagemService.findById(id);
		return ResponseEntity.ok().body(postagem);
	}

}