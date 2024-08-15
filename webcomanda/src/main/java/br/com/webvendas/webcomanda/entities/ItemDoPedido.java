package br.com.webvendas.webcomanda.entities;

import br.com.webvendas.webcomanda.entities.auxiliares.ChaveCompostaDeItemDoPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "tb_item_pedido")
public class ItemDoPedido implements Serializable {
	
	private static final long serialVersionUID = 5L;
	
	@EmbeddedId
	private ChaveCompostaDeItemDoPedido chaveCompostaDeItemDoPedido =  new ChaveCompostaDeItemDoPedido();
	
	private Integer quantidade;
	private Double preco;
	
	public ItemDoPedido() {
	}
	
	public ItemDoPedido(Pedido pedido, Produto produto,Integer quantidade, Double preco) {
		
		chaveCompostaDeItemDoPedido.setPedido(pedido);
		chaveCompostaDeItemDoPedido.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	@JsonIgnore
	public Pedido getPedido() {
		return chaveCompostaDeItemDoPedido.getPedido();
	}

	public void setPedido(Pedido pedido) {
		chaveCompostaDeItemDoPedido.setPedido(pedido);
	}

	public Produto getProduto() {
		return chaveCompostaDeItemDoPedido.getProduto();
	}

	public void setProduto(Produto produto) {
		chaveCompostaDeItemDoPedido.setProduto(produto);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getSubTotal() {
		return preco * quantidade;
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ItemDoPedido that)) return false;

        return chaveCompostaDeItemDoPedido.equals(that.chaveCompostaDeItemDoPedido);
	}

	@Override
	public int hashCode() {
		return chaveCompostaDeItemDoPedido.hashCode();
	}
}