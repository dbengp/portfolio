package br.com.webvendas.webcomanda.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import br.com.webvendas.webcomanda.exceptions.ExcecaoDeBancoDeDados;
import br.com.webvendas.webcomanda.exceptions.ExcecaoDeRecursoNaoEncontrado;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import br.com.webvendas.webcomanda.repositories.ClienteRepository;
import br.com.webvendas.webcomanda.entities.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
	public Cliente findById(Long id){

		try {
			Optional<Cliente> clienteOptional = clienteRepository.findById(id);
			return clienteOptional.get();
		} catch (NoSuchElementException e) {
			throw new ExcecaoDeRecursoNaoEncontrado();
		}
	}
	
	public Cliente insert (Cliente cliente){
		return clienteRepository.save(cliente);
	}
	
	public Cliente update(Long id, Cliente cliente){
		
		try{
			Cliente atualizado = clienteRepository.getReferenceById(id);
			if(!Objects.equals(cliente.getNome(), null)){
				if(!Objects.equals(cliente.getNome(), "" ))
					atualizado.setNome(cliente.getNome());
			}
			if(!Objects.equals(cliente.getEmail(), null)){
				if(!Objects.equals(cliente.getEmail(), ""))
					atualizado.setEmail(cliente.getEmail());
			}
			if(!Objects.equals(cliente.getContato(), null)){
				if(!Objects.equals(cliente.getContato(), ""))
					atualizado.setContato(cliente.getContato());
			}
			return clienteRepository.save(atualizado);
		} catch(EntityNotFoundException e){
			throw new ExcecaoDeBancoDeDados();
		}
	}
	
	public void delete (Long id){
		
		try{
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new ExcecaoDeBancoDeDados();
		}
	}
}
