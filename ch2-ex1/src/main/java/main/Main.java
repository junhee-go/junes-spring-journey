package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        Parrot p = new Parrot(); // 단순 객체 생성. spring context에 추가되기 전!
        var context = new AnnotationConfigApplicationContext();
        // AnnotationConfigApplicationContext() -> Class Constructor -> AnnotationConfigApp...Context 이 자체가 Class이며, new Parrot();와 동일한 꼴
        // 따라서, Spring Context(=Container) Instance를 생성하여 context 변수로 관리!
    }
}