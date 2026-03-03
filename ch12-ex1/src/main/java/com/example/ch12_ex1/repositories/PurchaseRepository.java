package com.example.ch12_ex1.repositories;

import com.example.ch12_ex1.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Context에 Bean으로 추가
public class PurchaseRepository {
    private final JdbcTemplate jdbc;

    // DI
    // JdbcTemplate Instance는 Context에 추가되어 있음 by Spring
    // starter-jdbc dependency를 추가한 것을 보고 알아서 해줌
    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // 메서드는 저장될 데이터를 나타내는 매개변수를 받음
    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase VALUES (NULL, ?, ?)";
        // query는 문자열로 작성되며, 쿼리의 매개변수 값은 ?로 대체됨.
        // id의 경우, 열 값을 생성하도록 DBMS를 구성했기에 NULL 사용

        jdbc.update(sql,purchase.getProduct(), purchase.getPrice());
    }

    // DB에서 조회한 레코드를 Purchase 객체 List로 변경하여 반환하는 메서드
    public List<Purchase> findAllPurchases() {
        // 구매 테이블의 모든 레코드를 가져오기 위한 SELECT query를 정의
        String sql = "SELECT * FROM purchase";

        // JdbcTemplate에 ResultSet의 행을 Purchase 객체로 변환하는 방법을 정의하는 RowMapper 객체를 구현
        // 상세 설명은 Notion 참고
        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            // JdbcTemplate은 ResultSet의 각 행에 대해 아래 로직을 수행함
            Purchase rowObject = new Purchase();

            // ResultSet의 getter 메서드를 사용하여, 현재 행의 컬럼값을 가져오고,
            // 해당 값으로 Purchase 인스턴스의 속성을 초기화
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
        };

        return jdbc.query(sql, purchaseRowMapper);
        /*
        JdbcTemplate의 query() 메서드 사용 시,
        DB에서 가져온 ResultSet을 기반으로,
        각각의 행에 대해 내가 정의한 람다 표현식 로직을 거치고,
        가공된 각 행을 List에 add한 List 결과물이 최종적으로 반환됨
        */
    }
}