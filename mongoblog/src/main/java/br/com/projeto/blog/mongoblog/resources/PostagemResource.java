package br.com.projeto.blog.mongoblog.resources;

import br.com.projeto.blog.mongoblog.domain.Postagem;
import br.com.projeto.blog.mongoblog.services.PostagemService;
import br.com.projeto.blog.mongoblog.utils.DecodificadorURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	
	@GetMapping(value = "/contendo")
	public ResponseEntity<List<Postagem>> findByConteudoDaPostagemContainingIgnoreCase(
													@RequestParam(value = "texto", defaultValue = "") String texto){

		String textoUtf8 = DecodificadorURL.decodificarParametroDeRequisicao(texto);
		List<Postagem> postagens = postagemService.findByConteudoDaPostagemContainingIgnoreCase(textoUtf8);
		return ResponseEntity.ok().body(postagens);
	}

    @GetMapping(value = "/apos")
	public ResponseEntity<List<Postagem>> findByDataDaPostagemAfter(@RequestParam(value = "data") String data){

		String dataUtf8 = DecodificadorURL.decodificarParametroDeRequisicao(data);
		List<Postagem> postagens = postagemService.findByDataDaPostagemAfter(dataUtf8);
		return ResponseEntity.ok().body(postagens);
	}
	
	@GetMapping(value = "/textopesquisado")
	public ResponseEntity<List<Postagem>> findTextoEmPostagemEComentariosEntreDatasDaPostagem(
													@RequestParam(value = "texto", defaultValue = "") String texto,
													@RequestParam(value = "dataMinima") String dataMinima,
													@RequestParam(value = "dataMaxima") String dataMaxima){

		String textoUtf8 = DecodificadorURL.decodificarParametroDeRequisicao(texto);
		String dataMinimaUtf8 = DecodificadorURL.decodificarParametroDeRequisicao(dataMinima);
		String dataMaximaUtf8 = DecodificadorURL.decodificarParametroDeRequisicao(dataMaxima);
		
		List<Postagem> postagens = postagemService.findTextoEmPostagemEComentariosEntreDatasDaPostagem(textoUtf8, dataMinimaUtf8, dataMaximaUtf8);
		
		return ResponseEntity.ok().body(postagens);
	}

}