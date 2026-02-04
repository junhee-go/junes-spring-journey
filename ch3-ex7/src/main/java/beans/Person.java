package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Lucy";
    private final Parrot parrot;

    @Autowired
    // Person Instance도 마찬가지로, Spring이 Parrot Bean을 param으로 넘겨줘야 하는데,
    // 이전에 Person Bean이 Context 내에 없었기에 Parrot Bean 생성에 실패했고,
    // 그에 따라 Parrot Bean도 Context 내에 없으므로,
    // Person Bean 생성에도 실패함
    // 즉, Spring은 Deadlock에 빠진다! -> BeanIsCurrentlyInCreationException 발생
    public Person(Parrot parrot) { // Spring은 Person Instance 생성하는 데에 Parrot Bean 필요
        this.parrot = parrot;
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