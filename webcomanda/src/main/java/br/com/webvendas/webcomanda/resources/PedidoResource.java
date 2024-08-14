package br.com.webvendas.webcomanda.resources;

import br.com.webvendas.webcomanda.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.webvendas.webcomanda.entities.Pedido;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource{
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(){
		
		List<Pedido> pedidos = pedidoService.findAll();
		return ResponseEntity.ok().body(pedidos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		
		Pedido pedido = pedidoService.findById(id);
		return ResponseEntity.ok().body(pedido);
	}
	
	
}