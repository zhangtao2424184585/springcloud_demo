package com.example.xixixi.configer;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname JsonLoginSuccessHandler
 * @Description TODO
 * @Date 2020/8/31 13:59
 * @Created by zhangtao
 */
public class JsonLoginSuccessHandler implements AuthenticationSuccessHandler {
    private JwtService jwtService;
    public JsonLoginSuccessHandler(JwtService jwtService){
        this.jwtService = jwtService;
    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String s = jwtService.saveUserLoginInfo((UserDetails) authentication.getPrincipal());
        response.setHeader("Authorization", s);

    }
}
