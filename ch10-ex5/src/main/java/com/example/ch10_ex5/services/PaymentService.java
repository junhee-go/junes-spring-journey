package com.example.ch10_ex5.services;

import com.example.ch10_ex5.exceptions.NotEnoughMoneyException;
import com.example.ch10_ex5.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    // PaymentDetails => 결제 성공할 때 Action이 반환할 것으로 기대되는
    // Response Body에 기술하는 모델 클래스일 뿐
    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException(); // 결제 과정에서 '돈 부족 예외'를 발생시킴!
    }
}