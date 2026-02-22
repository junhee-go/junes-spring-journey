package com.example.ch10_ex7.controllers;

import com.example.ch10_ex7.model.PaymentDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {
    private Logger logger = Logger.getLogger(PaymentController.class.getName());

    @PostMapping("/payment")
    // HTTP 요청 본문에서 결제 상세 정보를 얻는다!
    // JSON 형식으로 Request Body가 전달되고,
    // Spring은 JSON 문자열 데이터를 뜯어 사용자가 명시한(PaymentDetails) 타입의
    // 인스턴스를 만들어 낸다.
    // JSON 데이터에 포함된 속성과 (명시한 Class와)일치하는 속성에 해당 데이터를 저장하는 구조
    public ResponseEntity<PaymentDetails> makePayment(
            @RequestBody PaymentDetails paymentDetails) {
        logger.info("Received payment " + paymentDetails.getAmount());
        // 서버 콘솔에 결제 금액을 로깅

        // HTTP Response Body에 결제 상세 정보 객체를 body로서 넣고,
        // 응답 상태를 202 Accepted로 설정하여 응답을 전송함
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}