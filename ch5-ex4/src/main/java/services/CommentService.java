package services;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
// Lazy Instantiation
@Lazy // 무조건 생성해서 Context에 넣는 게 아님.
// 사용이 될 때, 그때 비로소 Instance를 생성하는 방식!
// 즉, @Lazy Annotation은 "누군가 처음 이 빈을 참조할 때만 스프링에 빈을 생성하도록 지시!
@Service
public class CommentService {
    public CommentService() {
        System.out.println("CommentService Instance Created!");
    }
}