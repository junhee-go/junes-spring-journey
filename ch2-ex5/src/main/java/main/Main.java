package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot x = new Parrot();
        x.setName("Lucy");

        Supplier<Parrot> parrotSupplier = () -> x;
        // parrotSupplier:
        // x(name field가 Lucy인 Parrot 타입의 객체)를 반환하는 get() 메서드를 가진 Supplier<Parrot> 타입 객체
        // parrotSupplier.get() 호출: name field가 Lucy인 객체 x의 참조를 반환

        // context.registerBean("parrot1", Parrot.class, parrotSupplier); // customizers(varargs) 생략
        // Parrot p = context.getBean(Parrot.class);
        // System.out.println(p.getName()); // Context에 Parrot 타입 Bean이 하나 뿐이니 당연히 에러 없이 Lucy 나옴
        // 만약 Parrot 타입 Bean이 여러 개였다면? NoUnique...Exception 발생했을 것! 어떤 Parrot Bean을 줄지 모르니까..

        context.registerBean("parrot1",
                Parrot.class,
                parrotSupplier,
                bc -> bc.setPrimary(true));
         // 4th 인자: Notion BeanDefinitionCustomizer Interface Toggle 확인
        System.out.println(context.getBean(Parrot.class).getName()); // 당연히 얘도 Lucy가 출력됨
        // 이때, registerBean() 호출하여 Context에 추가한 Bean이 Primary로 설정되었으니,
        // Context에 여러 개의 Parrot 타입의 Bean이 있었다면,
        // Default로 해당 Bean이 참조될 것
    }
}