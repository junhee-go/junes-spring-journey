package com.example.ch11_ex2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProjectConfig {

    @Bean // RestTemplate 인스턴스를 Context에 추가
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}