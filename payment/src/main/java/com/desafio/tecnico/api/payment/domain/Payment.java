package com.desafio.tecnico.api.payment.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Payment {

    @Id
    private Long id;
	private Integer debitCode;
    private String payerDocument;//CPF ou CNPJ do Pagador
    private String paymentMethod;// boleto, pix, cartao_credito ou cartao_debito
    private String cardNumber;//caso método de pagamento for cartao
	private BigDecimal paymentAmount;

}