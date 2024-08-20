package br.com.projeto.blog.mongoblog.services;

import br.com.projeto.blog.mongoblog.domain.Usuario;
import br.com.projeto.blog.mongoblog.dtos.UsuarioDTO;
import br.com.projeto.blog.mongoblog.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}