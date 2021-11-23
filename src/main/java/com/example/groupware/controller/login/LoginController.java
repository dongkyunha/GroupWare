package com.example.groupware.controller.login;

import com.example.groupware.entity.employee.Employee00VO;
import com.example.groupware.service.login.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping(value = "/login")
    public String loginPage(){
        return "login/login";
    }

    @PostMapping(value = "/login")
    public String login(Employee00VO loginForm, HttpSession session, RedirectAttributes redirectAttributes){
        log.info("LoginController 시작");
        return "login/home";
    }

    @GetMapping(value = "/login/register")
    public void register(){
    }

    @PostMapping(value = "/login/join")
    public String join(Employee00VO loginForm){
        if(loginForm.getEmployeeId().equals("")){

        }

        if(loginForm.getEmployeePassword().equals("")){

        }

        loginService.insertEmployeeInfo(loginForm);
        return "login/login";
    }

    @GetMapping(value = "login/home")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login/home");
        return mav;
    }
}
