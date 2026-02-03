package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Ella";
    private final Parrot parrot; // final 사용 가능 -> App 실행되는 동안 불변 보장!

    @Autowired
    // Person은 Component Class이므로, Spring은 Bean을 생성하여 Context에 추가함
    // 객체를 생성하는 시점에 생성자를 호출함
    // 이때, Spring은 Context 내의 Parrot Bean을 생성자의 Parameter로 전달함
    public Person(Parrot parrot) {
        this.parrot = parrot; // bean 간 관계 설정
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }
}