package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 구성 클래스: Spring 시작되자마자 찾는 Class
@ComponentScan(basePackages="main") // "main" 패키지 내에 있는 클래스들 중 @Component 붙어있는 클래스 찾으라고 지시!
public class ProjectConfig {
}