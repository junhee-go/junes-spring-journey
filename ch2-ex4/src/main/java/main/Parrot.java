package main;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
// Component Annotation 붙여서 Spring이 해당 클래스의 인스턴스 생성해서 Context에 추가하도록 지정
public class Parrot {
    private String name;

    @PostConstruct // Spring이 Component 클래스의 인스턴스를 생성하자마자 수행하는 메서드
    // 마치 생성자와 비슷한 맥락임
    public void init() {
        this.name = "Lucy";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}