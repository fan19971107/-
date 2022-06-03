package com.fancx.Admin.Config;

import com.fancx.Admin.MVC.Interceptor.CheckLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        CheckLoginInterceptor checkLoginInterceptor = new CheckLoginInterceptor();//判断用户是否登录
        String[] notLogin = {"/admin/**",//不需要登录的路径
        };
        registry.addInterceptor(checkLoginInterceptor).addPathPatterns("/**").excludePathPatterns(notLogin);
    }
}
