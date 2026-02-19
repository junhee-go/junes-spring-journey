package com.example.ch9_ex1.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component // 이 클래스의 인스턴스를 Context에 추가하기 위한 Annotation
@RequestScope // 빈을 요청 스코프로 지정!
// 즉, Spring은 HTTP Request마다 새로운 인스턴스를 생성하게 됨
public class LoginProcessor {
    private String password;
    private String userName;

    public boolean login() {
        String password = this.getPassword();
        String userName = this.getUserName();

        // lucy && password라면 로그인 성공
        if ("lucy".equals(userName) && "password".equals(password))
            return true;
        else
            return false;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}