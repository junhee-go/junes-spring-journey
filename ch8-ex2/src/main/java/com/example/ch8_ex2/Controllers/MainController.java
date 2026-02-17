package com.example.ch8_ex2.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/home")
    // 요청 매개변수 방식으로 data를 받아오기 위해 @RequestParam 애너테이션 사용하여
    // 매개변수 선언함
    public String home(Model page,
                       @RequestParam String color,
                       @RequestParam String name) {
        page.addAttribute("userName", name);
        // controller는 client가 전송한 이름(name)을 view로 전달!
        page.addAttribute("color", color);
        // controller는 client가 전송한 색상(color)을 view로 전달!
        return "home.html";
    }
}