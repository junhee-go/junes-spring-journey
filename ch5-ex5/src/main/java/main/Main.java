package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.ProjectConfig;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Prototype Scope인 CommentService를 참조할 땐 그때마다 새로운 Instance가 반환됨!
        var c1 = context.getBean("commentService", CommentService.class);
        var c2 = context.getBean("commentService", CommentService.class);

        System.out.println(c1 == c2); // false
        // c1과 c2엔 CommentService 타입의 "서로 다른" Instance가 저장돼 있음!
    }
}