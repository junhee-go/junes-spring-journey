package com.example.ch9_ex1.controllers;

import com.example.ch9_ex1.model.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginProcessor loginProcessor;

    // 로그인 검증 로직 메서드를 가진 LoginProcessor에 대한 관계를 설정
    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/") // Action을 App의 루트 경로(/)에다가 매핑
    public String loginGet() {
        return "login.html"; // app이 렌더링하는 view 이름 반환
    }

    // 사용자가 제출 버튼 클릭 -> html form이 생성하는 http post 요청을 처리하려면
    // 아래와 같은 또 하나의 액션이 필요
    @PostMapping("/") // Action을 로그인 페이지의 http post 요청과 매핑
    public String loginPost(
            @RequestParam String userName, @RequestParam String password,
            Model model) {
        loginProcessor.setUserName(userName);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login(); // login 결과

        // 로그인 결과에 따라 view에 적절한 메시지 전달
        if (loggedIn)
            model.addAttribute("message", "you are now logged in");
        else
            model.addAttribute("message", "Login failed");

        // 여전히 뷰 이름 login.html을 반환하므로, 동일한 페이지로 이동됨
        // 즉, 로그인 결과 추가한 이후에 리렌더링 하는 것
        return "login.html";
    }
}