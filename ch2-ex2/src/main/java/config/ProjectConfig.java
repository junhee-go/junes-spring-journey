package config;

import main.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Configuration Annotation: @Bean 붙은 메서드(인스턴스 반환하는)가 호출되고, 반환되는 객체를 context에 추가함
public class ProjectConfig {
    @Bean
    Parrot parrot() { // 해당 메서드는 @Bean이므로, Spring 시작되자마자 호출되고, 반환되는 인스턴스는 Spring Context에 들어감
        var p = new Parrot();
        p.setName("Lucy");
        return p;
    }

    @Bean // @Bean 메서드 여러 개 만들어서 Spring Context에 여러 개의 인스턴스를 초기화 할 수 있음
    String hello() {
        return "hello";
    }

    @Bean // 스프링 컨텍스트에 정수 10 추가
    Integer ten() {
        return 10;
    }
}