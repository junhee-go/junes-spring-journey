package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import model.Comment;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = context.getBean(CommentService.class); // proxy 객체 반환

        Comment comment = new Comment();
        comment.setText("Demo Comment");
        comment.setAuthor("Lucy");

        service.publishComment(comment); // 가로챌 메서드 호출 -> aspect 메서드로 제어권 넘어감
    }
}