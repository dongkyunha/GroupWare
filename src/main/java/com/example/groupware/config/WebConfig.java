package com.example.groupware.config;

import com.example.groupware.container.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final LoginInterceptor loginInterceptor;

    public WebConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login/login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        addInterceptor : 등록할 인터셉터 설정
//        addPathPatterns : 적용할 url 패턴 설정
//        excludePathPatterns : 인터셉터를 제외할 url 패턴 등록

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns(loginInterceptor.loginEssential)
                .excludePathPatterns(loginInterceptor.loginInessential);
//                .excludePathPatterns("/post/page")
//                .addPathPatterns("/post/**")
//                .addPathPatterns("/comment/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(0);
    }
}
