package br.com.webvendas.webcomanda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.webvendas.webcomanda.repositories.PedidoRepository;
import br.com.webvendas.webcomanda.entities.Pedido;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}
	
	public Pedido findById(Long id){
		
		Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
		return pedidoOptional.get();
	}
}