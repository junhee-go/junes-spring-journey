package main;

import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var service = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Lucy");

        service.publishComment(comment);
        service.deleteComment(comment);
        service.editComment(comment);
        // deleteComment()에 @ToLog가 붙었으므로,
        // deleteComment()를 호출할 때 해당 메서드를 가로챔!
    }
}