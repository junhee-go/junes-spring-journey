package com.example.ch10_ex6.controllers;

import com.example.ch10_ex6.model.PaymentDetails;
import com.example.ch10_ex6.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment() {
        PaymentDetails paymentDetails = paymentService.processPayment();

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
    // 더 이상 예외 발생에 대한 처리를 Controller Action에서 처리하지 않는다.
    // 오직 예외 발생 안 하는 정상적인 경우에만 집중!
    // Controller의 Action이 NotEnoughMoneyException을 일으킬 때 발생하는 상황에 대한
    // 로직은 ExceptionControllerAdvice라는 별도의 클래스에서 처리한다!
}