package br.com.webvendas.webcomanda.entities;

import br.com.webvendas.webcomanda.enums.EstadoDoPedido;
import java.time.Instant;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

	private Integer estadoDoPedido;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "chaveCompostaDeItemDoPedido.pedido")
	private Set<ItemDoPedido> itens = new HashSet<>();
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Pedido(){}
	
	public Pedido(Long id, Instant momentoDoPedido, Cliente cliente, EstadoDoPedido estadoDoPedido){
		
		this.id = id;
		this.momentoDoPedido = momentoDoPedido;
		this.cliente = cliente;
		setEstadoDoPedido(estadoDoPedido);
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
	
	public EstadoDoPedido getEstadoDoPedido() {
		return EstadoDoPedido.valueOf(estadoDoPedido);
	}

	public void setEstadoDoPedido(EstadoDoPedido estadoDoPedido) {
		if(estadoDoPedido != null)
			this.estadoDoPedido = estadoDoPedido.getCode();
	}
	
	public Set<ItemDoPedido>getItens(){
		return itens;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Double getTotalaPagar(){
		double total = 0.0;
		for (ItemDoPedido item : itens){
			total += item.getSubTotal();
		}
		return total;
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