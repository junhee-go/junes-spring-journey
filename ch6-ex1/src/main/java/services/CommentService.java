package services;

import org.springframework.stereotype.Service;
import java.util.logging.Logger;
import model.Comment;

@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName()); // Logger => notion 참조

    public void publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
    }
}