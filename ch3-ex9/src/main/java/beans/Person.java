package beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Rebecca";
    private final Parrot parrot;

    // @Autowired 생략된 구조! (생성자 1개일 땐 Autowired가 생략돼 있음)
    // Context엔 2개의 Parrot Bean이 있는데, 그들 중 parrot2를 선택하여 주입함
    // parrot2()와 매개변수 이름이 동일하니까..
    public Person(Parrot parrot2) {
        this.parrot = parrot2;
    }

    // 당연히 아래처럼 Qualifier Annotation 사용하는 것도 가능
    // 동작 방식은 100% 동일
//    public Person(@Qualifier("parrot2") Parrot parrot) {
//        this.parrot = parrot;
//    }

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