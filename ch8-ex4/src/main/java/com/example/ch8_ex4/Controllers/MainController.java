package com.example.ch8_ex4.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home/{color}") // 경로 변수 이름 정의 및 { } 안에 명시
    public String home(
            @PathVariable String color,
            Model page) {
        page.addAttribute("userName", "Lucy");
        page.addAttribute("color", color);
        return "home.html";
    }
}