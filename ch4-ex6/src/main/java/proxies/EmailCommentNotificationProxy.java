package proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import model.Comment;

@Component
@Qualifier("EMAIL") // @Qualifier로 이름을 지정! 이 이름을 이용해 DI를 선택적으로 하면 됨
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for comment: " + comment.getText());
    }
}