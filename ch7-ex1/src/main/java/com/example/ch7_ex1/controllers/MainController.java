package com.example.ch7_ex1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Action을 가진 Class임을 알림
public class MainController {
    @RequestMapping("/home") // /home 주소로 요청이 오면 수행할 Action
    // 즉, Action을 HTTP 요청 경로와 연결함
    public String home() {
        return "home.html"; // response로 보낼 문서 이름을 문자열로 반환
    }
}