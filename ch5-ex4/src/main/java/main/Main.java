package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.ProjectConfig;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // CommentService 사용 전이므로,
        // @Lazy 애노테이션 된 CommentService Instance는 생성되지 않음 -> 생성자 호출 X
        System.out.println("Before retrieving the CommentService");

        // 이때서야 CommentService를 사용하므로,
        // 이때 비로소 CommentService Instance가 생성됨!
        // 즉, 생성자가 호출돼서 "~~ created!"가 Console에 출력됨

        // 이 코드 줄에서 Spring은 CommentService 빈의 참조 값을 제공해야 함.
        // 이떄 빈 인스턴스를 생성!!
        var service = context.getBean(CommentService.class);

        System.out.println("After retrieving the CommentService");
    }
}