package com.example.ch13_ex1.repositories;

import com.example.ch13_ex1.model.Account;
import com.example.ch13_ex1.repositories.mappers.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
// 이 클래스의 Bean을 Context에 추가하고,
// 나중에 Service Class에서 이 Bean을 사용하는 곳에 주입함
public class AccountRepository {
    private final JdbcTemplate jdbc;

    // 생성자 의존성 주입을 통해 DB와 함께 작동할 JdbcTemplate 객체를 가져옴
    public AccountRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Account findAccountById(long id) {
        String sql = "SELECT * FROM account WHERE id = ?";
        // JdbcTemplate의 queryForObject() 메서드를 사용하여 DBMS에 SELECT QUERY 전송하여
        // 계좌 상세 정보를 가져옴!
        // 또, 결과의 행을 모델 객체에 매핑하는 방법을 JdbcTemplate에 알려주기 위해
        // RowMapper를 제공!
        // AccountRowMapper라는 Class를 repositories 패키지 내에 정의
        // => /repositories/mappers/AccountRowMapper

        // 매개변수로 받은 id에 해당하는 계좌의 데이터를 DB에서 가져오고,
        // 해당 Data를 Account Model Class로 매핑하고(AccountRowMapper Class 참고),
        // 최종적으로 해당 Account Instance를 반환한다!
        return jdbc.queryForObject(sql, new AccountRowMapper(), id);
    }

    public List<Account> findAllAccounts() {
        String sql = "SELECT * FROM account";
        return jdbc.query(sql, new AccountRowMapper());
    }

    public void changeAmount(long id, BigDecimal amount) {
        String sql = "UPDATE account SET amount = ? WHERE id = ?";
        jdbc.update(sql, amount, id);
    }
}