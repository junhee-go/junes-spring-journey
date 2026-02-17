package com.example.ch8_ex1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// Controller 애너테이션 붙여서 해당 클래스가 Spring MVC 컨트롤러 클래스라고 명시
// 이는 Stereotype Annotation이므로, Context에 이 타입의 빈이 추가됨
public class MainController {
    @RequestMapping("/home") // http 요청 경로에 대한 컨트롤러 액션을 명시하기 위한 애너테이션
    public String home(Model page) { // Model 인스턴스는 Notion 참고
        page.addAttribute("userName", "Katy");
        // View에 포함할 Data를 Model 객체에 저장
        page.addAttribute("color", "red");

        return "home.html"; // 컨트롤러는 렌더링할 View(=HTML)를 http response로 반환
        // 템플릿 엔진은 해당 html에다가 model 내에 저장된 데이터를 집어넣어
        // 완성된 html 텍스트를 만듦
    }
}