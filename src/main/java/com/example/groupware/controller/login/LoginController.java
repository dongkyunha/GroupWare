package com.example.groupware.controller.login;

import com.example.groupware.entity.employee.Employee00VO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String loginPage(){
        return "login/login";
    }

    @PostMapping(value = "/login")
    public String login(Employee00VO loginForm, HttpSession session, RedirectAttributes redirectAttributes){
        log.info("LoginController 시작");
        return "home";
    }

    @GetMapping(value = "/home")
    public String home(){
        return "home";
    }
}
