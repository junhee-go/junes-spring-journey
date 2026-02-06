package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CommentRepository;

@Service
public class CommentService {
    // @Autowired 이용하여 field에 직접 DI
    @Autowired
    private CommentRepository repo;

    public CommentRepository getCommentRepository() {
        return repo;
    }
}