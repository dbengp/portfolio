package br.com.webvendas.webcomanda.services;

import br.com.webvendas.webcomanda.repositories.ProdutoRepository;
import br.com.webvendas.webcomanda.entities.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto findById(Long id) {
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		return optionalProduto.get();
	}
}