package com.example.ch13_ex1.controllers;

import com.example.ch13_ex1.dto.TransferRequest;
import com.example.ch13_ex1.model.Account;
import com.example.ch13_ex1.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    // DB 변경 작업을 하기에, /transfer endpoint에 POST Method를 사용
    // RequestBody를 사용하여 원본 계좌ID, 대상 계좌ID, 금액을 가져옴
    public void transferMoney(
            @RequestBody TransferRequest request) {
        // 계좌 이체 사용 사례를 구현하는 트랜잭션 메서드인 서비스의 transferMoney() 메서드를 호출!
        // @Transactional이 붙은 Service Class의 transferMoney() 메서드가 호출되는
        // 이 시점에서 트랜잭션이 시작된다!
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount()
        );
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return transferService.getAllAccounts();
    }
}