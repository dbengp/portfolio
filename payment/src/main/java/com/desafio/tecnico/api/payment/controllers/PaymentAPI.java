package com.desafio.tecnico.api.payment.controllers;

import java.util.List;

import com.desafio.tecnico.api.payment.domain.Payment;
import com.desafio.tecnico.api.payment.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping(value = "/payments", produces = MediaType.APPLICATION_JSON_VALUE)
public class PaymentAPI {

    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping("/list")
    public List<Payment> listPayments() {
        return paymentRepository.findAll();
    }
}