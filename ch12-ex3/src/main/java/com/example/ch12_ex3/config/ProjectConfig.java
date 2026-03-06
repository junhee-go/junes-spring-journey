package com.example.ch12_ex3.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {
    @Value("${custom.datasource.url}")
    private String dataSourceUrl;

    @Value("${custom.datasource.username}")
    private String dataSourceUsername;

    @Value("${custom.datasource.password}")
    private String dataSourcePassword;

    @Bean // @Bean 써서 해당 메서드의 반환값을 Context로 추가
    // 이 메서드는 DataSource 객체를 반환함.
    // Spring Boot는 Context에 이미 DataSource가 있음을 발견한다면,
    // 이를 구성하지 않는다. 즉, 해당 메서드를 실행 안 하고, 결국 Context에 추가되는 Bean 없음을 의미
    public DataSource dataSource() {
        // DataSource 구현체로 HikariCP를 사용함. 다른 구현체 써도 된다.
        HikariDataSource dataSource = new HikariDataSource();

        // DataSource에 커넥션 매개변수(url, username, password)를 설정
        dataSource.setJdbcUrl(dataSourceUrl);
        dataSource.setUsername(dataSourceUsername);
        dataSource.setPassword(dataSourcePassword);
        dataSource.setConnectionTimeout(1000);
        // ConnectionTimeout: DataSource가 Connection을 획득하기까지 대기하는 시간

        // DataSource Instance를 반환하고, Spring은 이를 Context에 추가함
        return dataSource;
    }
}