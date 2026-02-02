package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Parrot p1 = context.getBean(Parrot.class);
        /*
        현재 Context에 저장된 Parrot 타입 인스턴스는 총 3개이므로,
        getBean()은 3개의 인스턴스를 반환하는데, 이를 Parrot 타입의 p1에 저장할 수 없음
        따라서, 런타임 에러가 발생함.
        Parrot 타입의 빈을 달라는데, 3개나 있는 상황에서 뭘 주라는 건지 어떻게 알겠는가?
        이때 발생하는 예외: "NoUniqueBeanDefinitionException"
         */

        Parrot p = context.getBean("parrot2", Parrot.class);
        System.out.println(p.getName()); // David
        /*
        Spring Context에 들어있는 Parrot 타입의 객체의 참조를 반환하는데,
        이때 parrot2라는 "식별자"를 사용하여 단 하나의 인스턴스만을 반환하므로, 문제X
        식별자 이름 == @Bean Annotation이 붙은 Method의 이름!
        즉, Bean 이름 == 식별자 이름
         */

        // System.out.println(context.getBean("parrot3", Parrot.class).getName());
        // @Bean의 name 속성 사용하여 식별자 이름을 임의로 변경 -> 기본 식별자는 사용 불가능
        // 식별자 이름 변경해 놓고 기본 식별자 그대로 사용 시 발생하는 예외: "NoSuchBeanDefinitionException"
        System.out.println(context.getBean("riki", Parrot.class).getName()); // Riki

        System.out.println(context.getBean(Parrot.class).getName()); // Lucy
        // 식별자 지정 안 하고 참조 => Primary Bean이 반환됨
    }
}