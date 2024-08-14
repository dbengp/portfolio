package br.com.webvendas.webcomanda.entities;

import br.com.webvendas.webcomanda.entities.Cliente;

import java.time.Instant;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 2L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momentoDoPedido;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public Pedido(){}
	
	public Pedido(Long id, Instant momentoDoPedido, Cliente cliente){
		
		this.id = id;
		this.momentoDoPedido = momentoDoPedido;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomentoDoPedido() {
		return momentoDoPedido;
	}

	public void setMomentoDoPedido(Instant momentoDoPedido) {
		this.momentoDoPedido = momentoDoPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Pedido pedido)) return false;

        return getId().equals(pedido.getId());
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}
}