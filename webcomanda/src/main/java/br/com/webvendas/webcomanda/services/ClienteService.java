package br.com.webvendas.webcomanda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

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
		
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		return clienteOptional.get();
	}
}