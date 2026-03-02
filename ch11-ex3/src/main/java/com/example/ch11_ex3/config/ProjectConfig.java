package com.example.ch11_ex3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProjectConfig {
    @Bean
    public WebClient webClient() {
        // WebClient Bean을 생성하고 Spring Context에 추가
        return WebClient.builder().build();
    }
}