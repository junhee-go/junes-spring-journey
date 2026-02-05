package services;

import proxies.CommentNotificationProxy;
import repositories.CommentRepository;
import model.Comment;

public class CommentService {
    // Class의 Field로 의존성을 정의함
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    // 객체가 생성될 때 생성자의 매개변수로 의존성을 제공함
    public CommentService(CommentRepository commentRepo,
                          CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepo;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    // '댓글 저장'과 '알림 전송' 책임을 의존성에 위임하는 사용 사례를 구현
    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment); // comment를 DB에 저장
        commentNotificationProxy.sendComment(comment); // email로 comment 전송
    }
}