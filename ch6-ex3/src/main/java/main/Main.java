package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import model.Comment;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var s = context.getBean(CommentService.class); // proxy 객체 반환

        // 가로챌 메서드 publishComment()를 호출할 때 전달할 Comment 매개변수
        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Lucy");

        String returnedValue = s.publishComment(comment);

        // aspect logic에서 전혀 다른 return값인 "FAILED"가 반환되어 logging 됨!
        // 원래 publishComment()는 "SUCCESS"를 반환함
        logger.info(returnedValue);
    }
}