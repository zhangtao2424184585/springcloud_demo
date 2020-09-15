package com.example.xixixi.configer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname JwtAuthenticationTokenFilter
 * @Description TODO
 * @Date 2020/9/1 11:32
 * @Created by zhangtao
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    public JwtService getJwtService() {
        return jwtService;
    }

    public void setJwtService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    private JwtService jwtService;

    public AuthenticationManager getManager() {
        return manager;
    }

    public void setManager(AuthenticationManager manager) {
        this.manager = manager;
    }

    private AuthenticationManager manager;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
//        if (authHeader==null){
//            throw new RuntimeException("tokenweikong");
//        }
        SelfUserDetails userInfo = new SelfUserDetails();
        userInfo.setUsername("zhangtao");
        userInfo.setPassword(new BCryptPasswordEncoder().encode("123"));
        Set authoritiesSet = new HashSet();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
        authoritiesSet.add(authority);
        userInfo.setAuthorities(authoritiesSet);
//        UsernamePasswordAuthenticationToken authentication =
//                new UsernamePasswordAuthenticationToken(userInfo, null, userInfo.getAuthorities());
//        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        JwtAuthenticationToken authentication = new JwtAuthenticationToken(userInfo,null,userInfo.getAuthorities());
        manager.authenticate(authentication);

        chain.doFilter(request, response);
    }
}
