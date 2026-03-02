package com.example.ch11_ex3.proxy;

import com.example.ch11_ex3.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PaymentsProxy {
    private final WebClient webClient;
    // properties 파일에서 기본 url 가져옴
    @Value("${name.service.url}")
    private String url;

    public PaymentsProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Payment> createPayment(String requestId, Payment payment) {
        return webClient.post() // 호출할 때 사용할 HTTP Method 지정
                .uri(url + "/payment") // 호출 URI 지정
                .header("requestId", requestId) // 요청에 http header값 추가(중복 사용 가능)
                .body(Mono.just(payment), Payment.class) // HTTP 요청 본문을 제공
                .retrieve() // http request를 전송하고 http response를 수신
                .bodyToMono(Payment.class); // HTTP Response Body 가져와서 이를 최종 반환
    }
}