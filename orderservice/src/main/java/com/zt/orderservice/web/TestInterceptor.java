package com.zt.orderservice.web;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname TestInterceptor
 * @Description TODO
 * @Date 2020/8/20 9:42
 * @Created by zhangtao
 */
public class TestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("需要验证");
        return true;
    }
}
