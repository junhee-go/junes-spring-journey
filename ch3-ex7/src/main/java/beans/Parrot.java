package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name = "David";
    private final Person person;

    @Autowired
    // 생성자를 통한 DI
    // 하지만, Parrot Instance를 생성하는 시점에 Person Bean은 Context 내에 없음
    // 따라서, Parrot Instance 생성 불가
    public Parrot(Person person) { // Spring은 Parrot Instance 생성하는 데에 Person Bean이 필요
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Parrot : " + name;
    }
}
