package com.example.groupware.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping(value = "/login")
    public String login(){
        return "home";
    }

    @GetMapping(value = "/home")
    public String home(){
        return "home";
    }
}
