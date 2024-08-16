package br.com.webvendas.webcomanda.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 8L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valorPago;
    private Double troco;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momentoDoPagamento;

	@JsonIgnore
	@OneToOne
	@MapsId
	private Pedido pedido;

    @JsonIgnore
    @ManyToOne
    private Cliente cliente;

    public Pagamento() { }

    public Pagamento(Long id, Double valorPago, Double troco, Instant momentoDoPagamento, Pedido pedido) {
        this.id = id;
        this.valorPago = valorPago;
        this.troco = troco;
        this.momentoDoPagamento = momentoDoPagamento;
		this.pedido = pedido;

        setCliente(pedido.getCliente());
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Double getTroco() {
        return troco;
    }

    public void setTroco(Double troco) {
        this.troco = troco;
    }

    public Instant getMomentoDoPagamento() {
        return momentoDoPagamento;
    }

    public void setMomentoDoPagamento(Instant momentoDoPagamento) {
        this.momentoDoPagamento = momentoDoPagamento;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pagamento pagamento)) return false;

        return getId().equals(pagamento.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
