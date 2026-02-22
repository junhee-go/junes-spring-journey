package com.example.ch10_ex6.controllers.advice;

import com.example.ch10_ex6.exceptions.NotEnoughMoneyException;
import com.example.ch10_ex6.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice// REST Controller Advice임을 명시하기 위해 이 애너테이션을 사용
public class ExceptionControllerAdvice {
    // @ExceptionHandler 메서드를 사용하여 메서드가 구현할 로직을 예외와 연결한다!
    // 즉, 애너테이션에 명시한 예외가 발생하면, 그에 대한 로직은 이 메서드가 수행함
    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money to make the purchase.");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}