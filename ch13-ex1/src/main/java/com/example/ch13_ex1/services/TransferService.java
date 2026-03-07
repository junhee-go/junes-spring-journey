package com.example.ch13_ex1.services;

import com.example.ch13_ex1.model.Account;
import com.example.ch13_ex1.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    // @Transactional 사용하여 메서드 호출이 트랜잭션에 포함되도록 지시
    public void transferMoney(
            long idSender,
            long idReceiver,
            BigDecimal amount) {
        // 각 계좌의 상세 정보를 가져옴
        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);

        // 돈 송금하는 계좌의 새 금액을 계산
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        // 돈 입금받는 계좌의 새 금액을 계산
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        // 출금 계좌에 새 금액 설정
        accountRepository.changeAmount(idSender, senderNewAmount);
        // 입금 계좌에 새 금액 설정
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}