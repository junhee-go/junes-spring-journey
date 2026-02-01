package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // (@Configuration 붙은) ProjectConfig Class 내의 @Bean 메서드를 호출하고, 반환되는 인스턴스를 Context에 추가함
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class); // Spring Context에 있는 객체들 중 Parrot 타입의 Bean 참조를 가져옴
        // getBean(): Spring Context에 있는 객체는 Heap에 할당되어 있고, 해당 공간의 참조를 반환
        System.out.println(p.getName()); // Lucy

        // 추가로 Context에 넣은 Instance들 출력
        System.out.println(context.getBean(String.class)); // hello
        System.out.println(context.getBean(Integer.class)); // 10
    }
}