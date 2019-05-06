package com.ogic.hellobootstrap.config;

import com.ogic.hellobootstrap.component.MyLocaleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Autowired
    HandlerInterceptor handlerInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/404").setViewName("404");
        registry.addViewController("/main").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handlerInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/","/user/login","/login");
    }

    @Bean
    @Autowired
    public LocaleResolver localeResolver(LocaleResolver localeResolver){
        return localeResolver;
    }
}
