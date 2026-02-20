package com.example.ch9_ex3.model;

import com.example.ch9_ex3.services.LoggedUserManagementService;
import com.example.ch9_ex3.services.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope // 요청 스코프로 변경
// 즉, 매 로그인마다 해당 Bean의 Instance를 생성
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    private String userName;
    private String password;

    // LoginCountService Bean 주입
    public LoginProcessor(
            LoggedUserManagementService loggedUserManagementService,
            LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    public boolean login() {
        loginCountService.increment(); // 로그인 로직 돌아갈 떄마다 count++

        String userName = this.getUserName();
        String password = this.getPassword();

        boolean loginRes = false;
        if ("lucy".equals(userName) && "password".equals(password)) {
            loginRes = true;
            loggedUserManagementService.setUserName(userName);
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