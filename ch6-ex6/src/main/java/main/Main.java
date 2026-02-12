package main;

import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Lucy");

        service.publishComment(comment);
        // publishComment()는 SecurityAspect, LoggingAspect 총 2개의
        // Aspect가 가로채는 메서드이며, Aspect의 순서 지정이 안 되어 있음
        // 즉, 두 Aspect가 호출되는 순서가 보장되지 않음
        // 순서 보장 안 된다는 게 매 실행 때마다 순서가 바뀐다는 게 아닌,
        // 스프링이 임의의 순서를 결정해서 aspect를 실행한다는 의미임
    }
}