package config;

import beans.Parrot;
import beans.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Lucy");
        return p;
    }

    @Bean
    // Spring이 person() Bean Method 호출할 때 파라미터로 Parrot Bean을 전달해 줌
    // 이때 전달되는 Parrot Bean은 Spring Context에 있던 녀석
    // 상세한 건 Notion
    public Person person(Parrot parrot) {
        Person p = new Person();
        p.setName("Rebecca");
        p.setParrot(parrot);
        return p;
    }
}