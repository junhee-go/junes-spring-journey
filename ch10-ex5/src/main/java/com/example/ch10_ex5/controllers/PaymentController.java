package com.example.ch10_ex5.controllers;

import com.example.ch10_ex5.exceptions.NotEnoughMoneyException;
import com.example.ch10_ex5.model.ErrorDetails;
import com.example.ch10_ex5.model.PaymentDetails;
import com.example.ch10_ex5.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService pService) {
        paymentService = pService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try {
            PaymentDetails paymentDetails = paymentService.processPayment();
            // processPayment() 메서드 호출하여 결제 시작!
            // 해당 메서드는 NotEnoughMoneyException을 던진다.

            // processPayment()에서 예외 안 던지고, 결제가 잘 마무리됐다면?
            // 즉, 서비스 메서드 호출에 성공하면,
            // 상태가 Accepted이고,
            // Response Body로 PaymentDetails Instance를 반환하는 ResponseEntity 인스턴스를 반환
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        }
        catch (NotEnoughMoneyException e) { // NotEnoughMoneyException을 잡아서,
            ErrorDetails errorDetails = new ErrorDetails();

            // NotEnoughMoneyException 타입의 예외가 발생하면,
            // Bad Request 상태 코드와
            // ErrorDetails 인스턴스를 본문으로 하는 HTTP Response를 반환함
            errorDetails.setMessage("Not enough money to make the purchase.");
            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
        }
    }
}