package services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import repositories.CommentRepository;
import proxies.CommentNotificationProxy;
import model.Comment;

@Component
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    // CommentRepository는 Bean이 DBComment.. 하나 뿐이니까 Qualifier로 지정한 게 없으니 그냥 그대로
    // CommentNotificationProxy을 구현한 의존성은 2개이고, 둘 다 Context에 있음
    // Qualifier 안 쓰면 Spring은 어떤 Bean을 주입해야 할지 모르기에,
    // 해당 Bean들을 만들 때 @Qualifier로 이름을 설정해 놨으므로,
    // 이를 이용해서 주입할 의존성을 선택!
    public CommentService(
            CommentRepository commentRepository,
            @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}