package main;

import proxies.EmailCommentNotificationProxy;
import repositories.DBCommentRepository;
import services.CommentService;
import model.Comment;

public class Main {
    public static void main(String[] args) {
        // 의존성 객체 2개 생성!
        var commentRepository = new DBCommentRepository(); // DB에 저장하는 객체 생성
        var commentNotificationProxy = new EmailCommentNotificationProxy(); // email로 전달하는 객체 생성
        // 기능 변경하고 싶다면?
        // interface 추가로 구현해서 클래스 만들고, 해당 클래스의 인스턴스 생성한 다음,
        // 그 인스턴스를 CommentService의 생성자 매개변수로 전달해주면 끝

        // 의존성을 제공하여 Service Class Instance를 생성함
        var commentService = new CommentService(commentRepository,
                commentNotificationProxy);

        // 댓글 게시 사용 사례를 위해 매개변수로 전달할 댓글 인스턴스 생성
        var comment = new Comment();
        comment.setText("Demo Comment");
        comment.setAuthor("Lucy");

        // 댓글 게시 사용 사례를 호출!
        commentService.publishComment(comment);
    }
}