package br.com.projeto.blog.mongoblog.resources;

import br.com.projeto.blog.mongoblog.dtos.UsuarioDTO;
import br.com.projeto.blog.mongoblog.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping()
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		
		List<UsuarioDTO> usuarioDtos = usuarioService.findAll();
		return ResponseEntity.ok().body(usuarioDtos);
	}
} 