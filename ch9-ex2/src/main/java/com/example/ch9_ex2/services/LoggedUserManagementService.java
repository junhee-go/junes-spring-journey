package com.example.ch9_ex2.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope // Bean의 Scope를 'Session'으로 변경
// 즉, Session Established 되면 인스턴스가 Context에 추가되고,
// 해당 Session과 연결됨
public class LoggedUserManagementService {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}