package com.example.ch9_ex2.controllers;

import com.example.ch9_ex2.model.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/") // 로그인 안 했다면 "redirect:/"를 통해 GET 요청이 발생함
    // 그에 대한 Action
    public String loginGet() {
        return "login.html"; // login view를 반환
    }

    // 로그인 버튼 누르면 "/" 경로의 POST 요청이 발생함
    // login.html 참고
    @PostMapping("/")
    public String loginPost(
            @RequestParam String userName,
            @RequestParam String password,
            Model model) {
        loginProcessor.setUserName(userName);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login();

        // 로그인 성공 시 앱은 main page로 리디렉션
        if (loggedIn) return "redirect:/main";
        // 마찬가지로, "/main"인 GET 요청을 날림
        // 이에 대한 Action은 MainController에 있음

        model.addAttribute("message", "Login failed!");
        return "login.html"; // 로그인 실패 문구 띄우고, 로그인 페이지 view 반환
    }
}