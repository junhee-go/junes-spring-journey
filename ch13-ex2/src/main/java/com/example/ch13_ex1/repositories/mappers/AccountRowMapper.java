package com.example.ch13_ex1.repositories.mappers;

import com.example.ch13_ex1.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// RowMapper 계약을 구현하고, 결과 행을 매핑할 모델 클래스(Account)를
// 제네릭 프로그래밍(generic programming) 타입으로 제공함
public class AccountRowMapper implements RowMapper<Account> {
    @Override
    // query 결과를 매개변수(ResultSet 객체 형태)로 가져와 현재 행을 매핑한 Account 인스턴스를 반환하는
    // mapRow() 메서드를 구현
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account a = new Account();
        // 현재 행의 값을 Account 속성에 매핑
        a.setId(resultSet.getInt("id"));
        a.setName(resultSet.getString("name"));
        a.setAmount(resultSet.getBigDecimal("amount"));

        return a;
        // DB에서 가져온 결과 값을 매핑한 Account Instance인 'a'를 반환
    }
}