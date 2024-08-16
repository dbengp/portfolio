package br.com.webvendas.webcomanda.entities;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 3L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	
	public Produto() { }

	public Produto(Long id, String nome, String descricao, Double preco) {
		
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Produto produto)) return false;

        return getId().equals(produto.getId());
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}
}