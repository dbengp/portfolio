package br.com.projeto.blog.mongoblog.resources;

import br.com.projeto.blog.mongoblog.domain.Postagem;
import br.com.projeto.blog.mongoblog.domain.Usuario;
import br.com.projeto.blog.mongoblog.dtos.UsuarioDTO;
import br.com.projeto.blog.mongoblog.dtos.UsuarioInsertDTO;
import br.com.projeto.blog.mongoblog.dtos.UsuarioUpdateDTO;
import br.com.projeto.blog.mongoblog.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable String id){
		
		Usuario usuario = usuarioService.findById(id);
		UsuarioDTO usuarioDto = new UsuarioDTO(usuario);
		return ResponseEntity.ok().body(usuarioDto);
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody UsuarioInsertDTO usuarioInsertDto){
		
		usuarioService.insert(usuarioInsertDto);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){

		usuarioService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody UsuarioUpdateDTO usuarioUpdateDto,
	                                   @PathVariable String id){
		
		usuarioService.update(usuarioUpdateDto, id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/{id}/postagens")
	public ResponseEntity<List<Postagem>> findPostagens(@PathVariable String id){

		Usuario usuario = usuarioService.findById(id);
		return ResponseEntity.ok().body(usuario.getPostagens());
	}
} 