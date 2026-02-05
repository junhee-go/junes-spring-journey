package main;

import configuration.ProjectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import model.Comment;

public class Main {
    public static void main(String[] args) {
        // Component Annotation 붙은
        // CommentService, CommentNotificationProxy, CommentRepository 3개의 Bean이 Context에 추가됨
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        // comment 객체 생성하고,
        var comment = new Comment();
        comment.setAuthor("Lucy");
        comment.setText("Demo Comment");

        // Context에 있는 CommentService Bean 가져옴
        // 그 후, 해당 Bean의 publishComment() 메서드 호출 (comment 전달하면서)
        // publishComment()에서 의존성 객체의 메서드들을 각각 호출(storeComment(), sendComment())
        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);

        // Framework 미사용 때는 CommentService 인스턴스를 생성하였으나,
        // 지금은 Framework가 알아서 생성하고 Bean에 추가하니,
        // Bean에서 가져오는 형태
        // 마찬가지로, CommentService의 의존성 객체 CommentRepository, ..들도 직접 생성할 필요가 없음
        // 이게 Spring이 추구하는 IoC
    }
}