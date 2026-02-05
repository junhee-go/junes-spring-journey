package repositories;

import model.Comment;

// CommentRepository Interface
/*
인터페이스로 추상화 해놓고,
실질적인 기능들은 이 Interface를 구현할 때 정의함
 */
public interface CommentRepository {
    void storeComment(Comment comment);
}