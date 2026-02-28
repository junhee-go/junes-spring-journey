package com.example.ch11_ex1.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration // 구성 클래스 지정
@EnableFeignClients(basePackages = "com.example.ch11_ex1.proxy")
// Client 계약(Interface)을 검색할 위치를 OpenFeign에게 명시함!
public class ProjectConfig {
}