package com.example.ch10_ex5.exceptions;

// RuntimeException을 상속받아 예외 메시지를 담거나,
// 에러가 발생한 경로(스택 트레이스)를 출력하는 등의 모든 예외 기능을 그대로 물려받음
public class NotEnoughMoneyException extends RuntimeException {
}