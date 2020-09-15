package com.zt.memservice.web.config;

import com.zt.memservice.web.UseInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Classname MYin
 * @Description TODO
 * @Date 2020/8/19 13:30
 * @Created by zhangtao
 */
public class MYin implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new UseInterceptor());
        interceptorRegistration.addPathPatterns("/**");
        System.out.println("拦截器生效");
    }
}
