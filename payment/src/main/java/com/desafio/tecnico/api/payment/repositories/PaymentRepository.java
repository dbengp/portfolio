package com.desafio.tecnico.api.payment.repositories;

import com.desafio.tecnico.api.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}