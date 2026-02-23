package com.example.ch11_payments.controllers;

import com.example.ch11_payments.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {
    private static Logger logger = Logger.getLogger(PaymentController.class.getName());
    // 엔드포인트 호출될 때 액션이 올바른 데이터를 가져오는지 확인하기 위해 logger 사용

    // App은 /payment 경로로 HTTP POST를 사용하여 엔드포인트를 노출함
    @PostMapping("/payment")
    // 엔드포인트 호출자에서 요청 헤더와 요청 본문을 가져와야 함.
    // 이를 위해, 액션은 이 두 가지 세부 정보를 매개변수로서 가져온다.
    public ResponseEntity<Payment> createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment) {
        logger.info("received request with ID " + requestId +
                " ;payment amount: " + payment.getAmount());
        payment.setId(UUID.randomUUID().toString()); // 결제 ID용으로 랜덤값 설정

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId)
                .body(payment);
        // 액션은 HTTP Response를 반환함.
        // 이 응답에는 헤더(requestId)와 랜덤 id값이 설정된 결제가 포함된 body가 있음
    }
}