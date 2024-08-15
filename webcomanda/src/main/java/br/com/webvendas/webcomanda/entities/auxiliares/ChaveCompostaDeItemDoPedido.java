package br.com.webvendas.webcomanda.entities.auxiliares;

import br.com.webvendas.webcomanda.entities.Pedido;
import br.com.webvendas.webcomanda.entities.Produto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ChaveCompostaDeItemDoPedido implements Serializable {
	
	private static final long serialVersionUID = 4L;
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ChaveCompostaDeItemDoPedido that)) return false;

        return getPedido().equals(that.getPedido()) && getProduto().equals(that.getProduto());
	}

	@Override
	public int hashCode() {
		int result = getPedido().hashCode();
		result = 31 * result + getProduto().hashCode();
		return result;
	}
}