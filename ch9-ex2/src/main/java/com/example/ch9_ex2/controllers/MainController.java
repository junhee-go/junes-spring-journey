package com.example.ch9_ex2.controllers;

import com.example.ch9_ex2.services.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    // 사용자의 로그인 여부를 알아내기 위해 Logged...ManagementService Bean과 관계를 설정
    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService mService) {
        loggedUserManagementService = mService;
    }

    @GetMapping("/main")
    public String home(
            @RequestParam(required = false) String logout, // 요청 매개변수(비필수)
            Model model) {
        // logout 로직
        if (logout != null) { // logout 매개변수에 값이 전달된다면, 로그아웃 수행
            loggedUserManagementService.setUserName(null); // null 저장 -> 로그아웃 처리
        }

        // 로그인 검증 로직
        // userName 값을 가져옴
        String userName = loggedUserManagementService.getUserName();
        // login이 됐다면? => null이 아닌 다른 값이어아먄 함(로그인 시 userName 저장하니)

        if (userName == null) {
            return "redirect:/"; // 로그인 안 했다면 로그인 페이지로 리디렉션
        }
        // redirect 수행:
        // 브라우저는 이 응답을 받자마자 주소창의 주소를 redirect: ~~~~로 바꾸고(여기선 /),
        // 서버에 새로운 'GET Request'를 자동으로 보낸다!
        // 즉, Controller에서 이에 대한 Action을 정의해야 함
        // 주소창이 실제로 바뀌면서 redirect 한 경로에 매핑된 Action이 처음부터 다시 실행된다.

        // 화면에 Welcome, username 표시하기 위해
        // view에 userName을 전달함
        model.addAttribute("userName", userName);
        return "main.html"; // 로그인 했다면 메인 페이지 뷰를 반환
    }
}