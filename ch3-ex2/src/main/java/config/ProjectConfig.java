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
    public Person person() {
        Person p = new Person();
        p.setName("Rebecca");
        p.setParrot(parrot()); // Person의 Parrot 속성에 앵무새 Bean의 참조를 설정!
        // parrot() Bean 메서드를 직접 호출하고, 반환되는 Parrot 인스턴스로 Person의 parrot field를 set
        // 이로써 Person 객체는 parrot을 가지는 has-A 관계가 성립됨
        // Q. 이 구조는 parrot Instance가 2개 만들어지는 구조 아닌가? => Notion 확인
        return p;
    }
}