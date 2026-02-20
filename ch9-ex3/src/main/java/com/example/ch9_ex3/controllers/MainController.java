package com.example.ch9_ex3.controllers;

import com.example.ch9_ex3.services.LoggedUserManagementService;
import com.example.ch9_ex3.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    public MainController(
            LoggedUserManagementService loggedUserManagementService,
            LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/main")
    public String home(
            @RequestParam(required = false) String logout,
            Model model) {
        if (logout != null) {
            loggedUserManagementService.setUserName(null);
        }

        String userName = loggedUserManagementService.getUserName();
        // 애플리케이션 스코프 빈에서 로그인 횟수 get
        int count = loginCountService.getCount();

        if (userName == null) return "redirect:/";

        model.addAttribute("userName", userName);
        model.addAttribute("loginCount", count); // login 횟수를 view에 포함

        return "main.html";
    }
}