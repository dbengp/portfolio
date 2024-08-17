package br.com.webvendas.webcomanda.resources;

import br.com.webvendas.webcomanda.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.webvendas.webcomanda.entities.Cliente;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource{
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		
		List<Cliente> clientes = clienteService.findAll();
		return ResponseEntity.ok().body(clientes);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		
		Cliente cliente = clienteService.findById(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente){
		cliente = clienteService.insert(cliente);
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(cliente.getId())
						.toUri();
		return ResponseEntity.created(location).body(cliente);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, 
	                                      @RequestBody Cliente cliente){
		Cliente atualizado = clienteService.update(id, cliente);
		return ResponseEntity.ok().body(atualizado);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}