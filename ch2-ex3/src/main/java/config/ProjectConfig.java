package config;

import main.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {
    @Bean
    @Primary
        // 선택할 빈이 여러 개 있을 때, 사용자가 식별자 지정하지 않을 때 스프링이 선택하는 Bean
        // 즉, Primary Annotation이 붙는 Bean: 스프링의 Default Bean
    Parrot parrot1() {
        var p = new Parrot();
        p.setName("Lucy");
        return p;
    }

    @Bean
    Parrot parrot2() { // 2개 이상의 @Bean Method -> 동일 타입의 인스턴스 여러 개를 Spring에 추가
        var p = new Parrot();
        p.setName("David");
        return p;
    }

    @Bean(name = "riki")
    /*
    @Bean 애노테이션의 name 속성 사용:
    식별자 == Bean Method 이름이라는 규칙을 깨고,
    내가 원하는 고유한 식별자 부여 가능
     */
    Parrot parrot3() {
        var p = new Parrot();
        p.setName("Riki");
        return p;
    }
}