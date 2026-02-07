package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.ProjectConfig;
import services.CommentService;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var s1 = context.getBean(CommentService.class);
        var s2 = context.getBean(UserService.class);

        boolean res = s1.getCommentRepository() == s2.getCommentRepository();
        System.out.println(res); // false

        // 서로 다른 두 Service의 의존성인 CommentRepository에는
        // "서로 다른" Bean이 저장되어 있으므로, res엔 false가 반환됨
    }
}