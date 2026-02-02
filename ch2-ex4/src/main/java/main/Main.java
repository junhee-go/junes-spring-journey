package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Context 생성(ProjectConfig Class를 가장 먼저 읽음)
        // 그럼, 그 클래스에 ComponentScan 명시돼 있으니까, 해당 범위로 가서
        // Component 붙은 클래스 찾아다가 Instance 생성해서,
        // 그들을 Spring Context에 다 넣어 초기화!
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p); // Object Reference(e.g., main.Parrot@5b7a...)
        System.out.println(p.getName()); // null => Context에 있는 Parrot 객체의 name field는 초기화 안 됐으니 null 출력
        // 위 설명은 PostConstruct 사용 전 기준에 대한 설명. PostConstruct 사용하면 Lucy가 출력될 것
    }
}