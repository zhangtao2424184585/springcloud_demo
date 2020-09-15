package com.example.demo.configer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname UserNamePasswordFilter
 * @Description TODO
 * @Date 2020/9/2 13:28
 * @Created by zhangtao
 */
public class UserNamePasswordFilter extends AbstractAuthenticationProcessingFilter {
    public UserNamePasswordFilter(){
        super(new AntPathRequestMatcher("/login","POST"));
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        ServletInputStream inputStream = request.getInputStream();

        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        String body = new String(bytes,0,read);
        JSONObject jsonObject = (JSONObject)JSONObject.parse(body);
        String username =(String)jsonObject.get("username");
        String password = (String)jsonObject.get("password");
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        return this.getAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);
    }
}
