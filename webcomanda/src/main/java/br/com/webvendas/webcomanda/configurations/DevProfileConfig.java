package br.com.webvendas.webcomanda.configurations;

import br.com.webvendas.webcomanda.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.webvendas.webcomanda.repositories.ItemDoPedidoRepository;
import br.com.webvendas.webcomanda.repositories.ClienteRepository;
import br.com.webvendas.webcomanda.repositories.PedidoRepository;
import br.com.webvendas.webcomanda.repositories.ProdutoRepository;
import br.com.webvendas.webcomanda.enums.EstadoDoPedido;

import java.time.Instant;
import java.util.Arrays;


@Configuration
@Profile("dev")
public class DevProfileConfig implements CommandLineRunner {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemDoPedidoRepository itemDoPedidoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Produto marmitaUm = new Produto(null, "Carne Assada","Porção satisfatória de lombo bovino, com batata e macarrão",17.58);
		Produto marmitaDois = new Produto(null, "Frango Empanado","Suculento filezinho de frango, com cebola caramelizada e arroz-xadrez",16.71);
		Produto marmitaTres = new Produto(null, "Peixe Frito","Filé de Pescada Amarela frita, com salada polonesa e farrofa de macaxeira",20.89);
		Produto marmitaQuatro = new Produto(null, "Miojo Gourmet","Macarrão instântaneo no ponto com legumes em cubos e ovos de codorna",10.25);

		produtoRepository.saveAll(Arrays.asList(marmitaUm, marmitaDois, marmitaTres, marmitaQuatro));
	
		Cliente primeiro = new Cliente(null, "Primeiro Cliente", "primeiro_c@devmail.com", "9191111111");
		Cliente segundo = new Cliente(null, "Segundo Cliente", "segundo_c@devgmail.com", "9192222222");
		Cliente terceiro = new Cliente(null, "Terceiro Cliente", "terceiro_c@devmail.com", "9193333333");
		Cliente quarto = new Cliente(null, "Quarto Cliente", "quarto_c@devmail.com", "9194444444");
		Cliente quinto = new Cliente(null, "Quinto Cliente", "quinto_c@devmail.com", "9195555555");

		clienteRepository.saveAll(Arrays.asList(primeiro, segundo, terceiro, quarto, quinto));

		Pedido um = new Pedido(null, Instant.parse("2024-08-14T02:09:01Z"), primeiro, EstadoDoPedido.CANCELADO);
		Pedido dois = new Pedido(null, Instant.parse("2024-08-14T02:10:02Z"), segundo, EstadoDoPedido.FEITO);
		Pedido tres = new Pedido(null, Instant.parse("2024-08-14T02:11:03Z"), terceiro, EstadoDoPedido.FEITO);
		Pedido quatro = new Pedido(null, Instant.parse("2024-08-14T02:12:04Z"), quarto, EstadoDoPedido.PAGO);
		Pedido cinco = new Pedido(null, Instant.parse("2024-08-14T02:13:05Z"), quinto, EstadoDoPedido.PAGO);
		Pedido seis = new Pedido(null, Instant.parse("2024-08-14T02:14:06Z"), primeiro, EstadoDoPedido.FEITO);
		Pedido sete = new Pedido(null, Instant.parse("2024-08-14T02:15:07Z"), segundo, EstadoDoPedido.PAGO);

		pedidoRepository.saveAll(Arrays.asList(um, dois, tres, quatro, cinco, seis, sete));
		
		ItemDoPedido itemUm = new ItemDoPedido(dois, marmitaUm, 2, false);
		ItemDoPedido itemDois = new ItemDoPedido(tres, marmitaDois, 3, false);
		ItemDoPedido itemTres = new ItemDoPedido(quatro, marmitaTres, 4, false);
		ItemDoPedido itemQuatro = new ItemDoPedido(cinco, marmitaQuatro, 1, true);
		ItemDoPedido itemCinco = new ItemDoPedido(seis, marmitaUm, 2,false);
		ItemDoPedido itemSeis = new ItemDoPedido(sete, marmitaDois, 1, false);
		ItemDoPedido itemSete = new ItemDoPedido(sete, marmitaTres, 1, false);
		ItemDoPedido itemOito = new ItemDoPedido(sete, marmitaQuatro, 1, true);

		itemDoPedidoRepository.saveAll(Arrays.asList(itemUm, itemDois, itemTres, itemQuatro, itemCinco, itemSeis, itemSete, itemOito));
		
		Cashback cashbackUm = new Cashback(null, Instant.parse("2025-08-14T02:12:04Z"), 2.01, "Voce tem até a data de expiração para fazer uso do cashback", quarto);
		Cashback cashbackDois = new Cashback(null, Instant.parse("2025-08-14T02:13:05Z"), 3.09, "Voce tem até a data de expiração para fazer uso do cashback", quinto);
		Cashback cashbackTres = new Cashback(null, Instant.parse("2025-08-14T02:15:07Z"), 1.27, "Voce tem até a data de expiração para fazer uso do cashback", segundo);

		quarto.setCashback(cashbackUm);
		quinto.setCashback(cashbackDois);
		segundo.setCashback(cashbackTres);

		clienteRepository.saveAll(Arrays.asList(segundo, quarto, quinto));
		
		Pagamento pagamentoUm = new Pagamento(null, 83.56, 0.0, Instant.parse("2024-08-14T03:12:04Z"), quatro);
		Pagamento pagamentoDois = new Pagamento(null, 20.00, 9.75, Instant.parse("2024-08-14T03:13:05Z"), cinco);
		Pagamento pagamentoTres = new Pagamento(null, 50.00, 2.15, Instant.parse("2024-08-14T02:16:07Z"), sete);

		quatro.setPagamento(pagamentoUm);
		cinco.setPagamento(pagamentoDois);
		sete.setPagamento(pagamentoTres);

		pedidoRepository.saveAll(Arrays.asList(quatro,cinco, sete));

	}
}