package com.example.ch9_ex2.model;

import com.example.ch9_ex2.services.LoggedUserManagementService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope // 요청 스코프 선언
// 즉, 로그인 요청마다 해당 Bean의 새로운 Instance가 생성됨
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;

    private String userName;
    private String password;

    // @AutoWired 생략
    public LoginProcessor(LoggedUserManagementService mService) {
        loggedUserManagementService = mService;
    }

    public boolean login() {
        String userName = this.getUserName();
        String password = this.getPassword();

        boolean loginRes = false;
        if ("lucy".equals(userName) && "password".equals(password)) {
            loginRes = true;
            loggedUserManagementService.setUserName(userName);
            // 로그인 성공 시 로그인 관리 Bean의 userName 속성에 값(유저 이름)을 넣음
        }

        return loginRes;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}