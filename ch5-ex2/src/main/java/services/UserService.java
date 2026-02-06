package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CommentRepository;

@Service
public class UserService {
    @Autowired
    private CommentRepository repo;

    public CommentRepository getCommentRepository() {
        return repo;
    }
}