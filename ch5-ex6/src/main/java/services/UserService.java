package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repositories.CommentRepository;

@Component
public class UserService {
    @Autowired
    private CommentRepository commentRepository;
    // CommentRepository는 Prototype Scope Bean임
    // 즉, field에 Autowired를 통해 DI하는 이 시점에서 새로운 Instance가 생성되어 전달됨

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }
}