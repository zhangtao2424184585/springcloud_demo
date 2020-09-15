package com.zt.memservice.web;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname UseInterceptor
 * @Description TODO
 * @Date 2020/8/19 13:31
 * @Created by zhangtao
 */
public class UseInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println();
        return false;
    }
}
