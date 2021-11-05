package com.example.groupware.controller.login;

import com.example.groupware.entity.employee.EmployeeVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @PostMapping(value = "/login")
    public String login(EmployeeVO loginForm, HttpSession session, RedirectAttributes redirectAttributes){

        return "home";
    }

    @GetMapping(value = "/home")
    public String home(){
        return "home";
    }
}
