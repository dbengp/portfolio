package br.com.projeto.blog.mongoblog.services;

import br.com.projeto.blog.mongoblog.domain.Usuario;
import br.com.projeto.blog.mongoblog.dtos.UsuarioDTO;
import br.com.projeto.blog.mongoblog.dtos.UsuarioInsertDTO;
import br.com.projeto.blog.mongoblog.dtos.UsuarioUpdateDTO;
import br.com.projeto.blog.mongoblog.exceptions.ExcecaoDeDocumentoMongodbNaoEncontrado;
import br.com.projeto.blog.mongoblog.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<UsuarioDTO> findAll(){
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioDTO> usuarioDtos = usuarios
											.stream()
											.map(UsuarioDTO::new)
											.collect(Collectors.toList());
		return usuarioDtos;									
	}
	
	public Usuario findById(String id){
		try{
			Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
			return optionalUsuario.get();
		}catch (NoSuchElementException e) {
			throw new ExcecaoDeDocumentoMongodbNaoEncontrado("Documento não encontrado no MongoDB");
		}
	}
	
	public void insert(UsuarioInsertDTO usuarioInsertDto){
		
		Usuario usuario = usuarioInsertDto.obterUsuarioDoDTO();
		usuarioRepository.insert(usuario);
	}

	public void deleteById(String id){
		
		usuarioRepository.deleteById(id);
	}
	
	public void update(UsuarioUpdateDTO usuarioUpdateDto, String id){
        Usuario usuario = findById(id);
		usuario.setEmail(usuarioUpdateDto.getEmail());
		usuario.setPerfil(usuarioUpdateDto.getPerfil());
		usuarioRepository.save(usuario);
	}
}