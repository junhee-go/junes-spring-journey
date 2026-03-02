package com.example.ch11_ex3.controllers;

import com.example.ch11_ex3.model.Payment;
import com.example.ch11_ex3.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class PaymentsController {
    private final PaymentsProxy paymentsProxy;

    public PaymentsController (PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment") // endpoint 노출
    public Mono<Payment> createPayment(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        return paymentsProxy.createPayment(requestId, payment);
        // proxy가 최종적으로 반환하는 HTTP Response Body를 마지막으로 반환함!
    }
}