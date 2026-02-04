package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import beans.Parrot;
import beans.Person;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot1() { // Parrot bean 2
        Parrot p = new Parrot();
        p.setName("Lucy");
        return p;
    }

    @Bean
    public Parrot parrot2() { // Parrot Bean 2
        Parrot p = new Parrot();
        p.setName("David");
        return p;
    }
    // Context에는 Parrot Type Bean이 2개 존재

    @Bean
    // Person Bean 만들 때 Parameter로 Parrot Bean을 넘겨줌
    // 이때, Context에는 Parrot Bean이 여러 개(2개) 있음
    // Context 내부: Parrot Bean1(ID: parrot1), Parrot Bean2(ID: parrot2)
    // 어떤 Bean이 parameter로 넘어올까?
    // parameter명이 parrot2이고, Context 내에 parrot2 Bean이 있으므로,
    // Spring은 매개변수 이름과 Bean 이름이 일치하는 Parrot Bean2를 전달!
    public Person person(Parrot parrot2) {
        Person p = new Person();
        p.setName("Rebecca");
        p.setParrot(parrot2);
        return p;
    }
}