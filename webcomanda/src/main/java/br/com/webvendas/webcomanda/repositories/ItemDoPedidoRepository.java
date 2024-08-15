package br.com.webvendas.webcomanda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.webvendas.webcomanda.entities.ItemDoPedido;
import br.com.webvendas.webcomanda.entities.auxiliares.ChaveCompostaDeItemDoPedido;

public interface ItemDoPedidoRepository extends JpaRepository<ItemDoPedido, ChaveCompostaDeItemDoPedido> {

}