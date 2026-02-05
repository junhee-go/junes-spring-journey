package model;

public class Comment {
    // 댓글 Model이 고려하는 속성
    private String author; // 댓글 작성자
    private String text; // 댓글 내용

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}