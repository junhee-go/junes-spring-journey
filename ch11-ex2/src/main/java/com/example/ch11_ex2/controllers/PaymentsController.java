package com.example.ch11_ex2.controllers;

import com.example.ch11_ex2.model.Payment;
import com.example.ch11_ex2.proxy.PaymentsProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {
    private final PaymentsProxy paymentsProxy;

    // PaymentsProxy 인스턴스는 Context에 추가됨
    // 이를 @Autowired를 통해 DI
    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment") // 액션 정의 및 /payment 경로와 매핑
    // 결제 Data를 Request Body로 받음
    public Payment createPayment(@RequestBody Payment payment) {
        // Proxy Method 호출, 즉 결제 Endpoint가 호출됨
        // Response Body가 반환될 것이며, 이를 최종적으로 Client에게 반환함
        return paymentsProxy.createPayment(payment);
    }
}