package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="beans")
// beans package 내 Component Annotation 된 Class의 Instance를 생성하여 그들을 Context에 추가
public class ProjectConfig {
}