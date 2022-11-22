package com.example.formtest.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/goSignUp")
    public String goSignup() {
        return "signup";
    }

    @GetMapping("/goLogin")
    public String goLogin() {
        return "login";
    }

    @GetMapping("/goMember")
    public String goMember(HttpSession session) {
        if (session.getAttribute("email") == null) { //로그인 안한 경우
            return "signup";
        } else {
            return "index";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
//        session.invalidate(); //이건 절대 쓰지 마세요 !!
        session.setAttribute("email",null);
        return "index";
    }

}
