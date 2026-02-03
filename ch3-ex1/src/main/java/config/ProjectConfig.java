package config;

import beans.Parrot;
import beans.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot() { // context에 Parrot 추가
        Parrot p = new Parrot();
        p.setName("Lucy");
        return p;
    }

    @Bean
    public Person person() { // context에 Person 추가
        Person p = new Person();
        p.setName("Rebecca");
        return p;
    }
}