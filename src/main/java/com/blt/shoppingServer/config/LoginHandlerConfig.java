package com.blt.shoppingServer.config;

import com.blt.shoppingServer.handler.LoginHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@Configuration
public class LoginHandlerConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> excludeMapping=new ArrayList<String>();
        excludeMapping.add("/login");
        excludeMapping.add("/register");
        excludeMapping.add("/forgetPassword");
       // InterceptorRegistration registration = registry.addInterceptor(new LoginHandler()).excludePathPatterns(excludeMapping).addPathPatterns("/**");


    }
}
