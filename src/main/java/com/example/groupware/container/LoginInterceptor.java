package com.example.groupware.container;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    //필요한 page
    public List loginEssential = Arrays.asList("/get/**", "/post/**", "/comment/**",  "/category/**", "/member/manage/**", "/main/edit/**");

    //불필요한 page
    public List loginInessential = Arrays.asList("/post/board/**", "/post/read/**", "/post/like/**" );

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String loginId  = (String)request.getSession().getAttribute("LoginId");
        Optional<String> user = Optional.ofNullable(loginId);

        if(user.isPresent()) {
            return true;
        }else{
            String destUri = request.getRequestURI();
            String destQuery = request.getQueryString();
            String dest = (destQuery == null) ? destUri : destUri+"?"+destQuery;
            request.getSession().setAttribute("dest", dest);
//            response.getOutputStream().println("LOGIN REQUIRED");

            response.sendRedirect("login/login");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
