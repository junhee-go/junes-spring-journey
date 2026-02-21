package com.example.ch10_ex1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RestController 애너테이션 쓰면 모든 메서드에 @ResponseBody 안 써도 됨
// @Controller -> @RestController로 대체하는 것!
@Controller // Spring MVC Controller임을 명시
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    /*
    @ResponseBody Annotation으로 해당 메서드가 View 이름이 아닌,
    HTTP Response를 직접 반환한다고 Dispatcher Servlet에게 알림
     */
    public String hello() {
        return "Hello!";
    }
}