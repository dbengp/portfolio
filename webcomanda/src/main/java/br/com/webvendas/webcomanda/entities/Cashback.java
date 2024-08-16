package br.com.webvendas.webcomanda.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;


@Entity
@Table(name = "tb_cashback")
public class Cashback implements Serializable {
	
	private static final long serialVersionUID = 6L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataDeExpiracao;
	private Double valor;
	private String politicaDeUso;

	@JsonIgnore
	@OneToOne
	@MapsId
	private Cliente cliente;
	
	public Cashback() { }

	public Cashback(Long id, Instant dataDeExpiracao, Double valor, String politicaDeUso, Cliente cliente) {

		this.id = id;
		this.dataDeExpiracao = dataDeExpiracao;
		this.valor = valor;
		this.politicaDeUso = politicaDeUso;
		this.cliente = cliente;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataDeExpiracao() {
		return dataDeExpiracao;
	}

	public void setDataDeExpiracao(Instant dataDeExpiracao) {
		this.dataDeExpiracao = dataDeExpiracao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getPoliticaDeUso() {
		return politicaDeUso;
	}

	public void setPoliticaDeUso(String politicaDeUso) {
		this.politicaDeUso = politicaDeUso;
	}

	@Override
	public final boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Cashback cashback)) return false;

        return getId().equals(cashback.getId());
	}

	@Override
	public int hashCode() {
		return getId().hashCode();
	}
}