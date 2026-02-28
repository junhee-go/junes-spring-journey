package com.example.ch11_ex1.proxy;

import com.example.ch11_ex1.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

// 해당 Interface 내의 메서드 호출 시,
// @FeignClient url 속성에 지정한 주소로 HTTP Request가 전달됨
// HTTP Method, 경로 등은 해당 메서드에 지정한 대로!
@FeignClient(name="payments", url="${name.service.url}")
public interface PaymentProxy {

    @PostMapping("/payment")
    Payment createPayment( // public abstract keyword 생략
            @RequestHeader String requestId,
            @RequestBody Payment payment); // 요청 헤더와 본문을 정의
}