package main;

import beans.Parrot;
import beans.Person;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Spring Context Instance 생성 based on ProjectConfig(=Configuration Class)
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class); // Context 내의 Person Bean의 참조를 얻음
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("Person's name: " + person.getName()); // Rebecca
        System.out.println("Parrot's name: " + parrot.getName()); // Lucy

        System.out.println("Person's parrot: " + person.getParrot()); // null
        // Person 객체의 setParrot() 메서드를 통해 parrot field는 초기화 안 됐으므로 null
        // 즉, 사람과 앵무새의 관계가 아직 설정되지 않음!
    }
}