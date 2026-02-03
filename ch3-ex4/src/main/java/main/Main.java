package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.ProjectConfig;
import beans.Person;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person p = context.getBean(Person.class);

        System.out.println("Person's name: " + p.getName()); // Ella
        System.out.println("Person's parrot: " + p.getParrot()); // null
        // Person Class 내에서 parrot field가 Autowired Annotation 됐기에,
        // Context 내에서 Parrot Bean으로 Person의 parrot field를 초기화
        // 이때, Parrot 인스턴스의 name field는 "Lucy"로 선언과 동시에 초기화가 됐으므로,
        // Parrot: Lucy가 출력됨 (System.out.print()에 Object를 전달 -> 해당 Object의 toString()를 호출함
    }
}