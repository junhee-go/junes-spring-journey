package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.ProjectConfig;
import services.CommentService;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        // 구성 클래스를 ㄹ기반으로 Spring Context 생성
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Spring Context에서 두 서비스 Bean에 대한 참조를 가져옴
        var s1 = context.getBean(CommentService.class);
        var s2 = context.getBean(UserService.class);

        // CommentService, UserService는 CommentRepository라는 동일한 의존성을 가지고 있음
        // 따라서, b에는 true가 저장됨
        boolean b = s1.getCommentRepository() == s2.getCommentRepository();
        System.out.println(b); //
        /*
        CommentRepository 의존성은 Singleton이므로,
        두 서비스(User, Comment..)는 동일한 참조(Dependency에 대한)를 사용하는 셈이다!
        따라서, 콘솔에는 항상 true가 출력됨
         */
    }
}