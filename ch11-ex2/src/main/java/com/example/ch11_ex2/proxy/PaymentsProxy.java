package com.example.ch11_ex2.proxy;

import com.example.ch11_ex2.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import java.util.UUID;

@Component
public class PaymentsProxy {
    private final RestTemplate rest;

    // properties 파일에서 결제 서비스에 대한 URL을 가져옴
    @Value("${name.service.url}")
    private String paymentsServiceUrl;

    // configuration class에서 RestTemplate Bean을 Context에 추가하고,
    // 생성자 DI를 통해 Spring Context의 RestTemplate을 주입함
    public PaymentsProxy(RestTemplate rest) {
        this.rest = rest;
    }

    public Payment createPayment(Payment payment) {
        // 결제 서비스(ch11-payments) URI
        String uri = paymentsServiceUrl + "/payment";

        // HttpHeaders 객체를 만들어 HTTP Request Header를 정의
        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", UUID.randomUUID().toString());

        // HttpEntity 객체를 만들어 요청 데이터를 정의
        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);

        // exchange() 메서드를 사용하여 HTTP Request를 전송하고,
        // HTTP Response를 수신함
        ResponseEntity<Payment> response = rest.exchange(uri,
                HttpMethod.POST, httpEntity, Payment.class);

        // HTTP Response Body를 반환
        return response.getBody();
    }
}