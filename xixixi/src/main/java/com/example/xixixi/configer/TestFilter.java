package com.example.xixixi.configer;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname TestFilter
 * @Description TODO
 * @Date 2020/9/1 16:44
 * @Created by zhangtao
 */
public class TestFilter extends OncePerRequestFilter {
    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    private AuthenticationManager authenticationManager;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("执行了");
        filterChain.doFilter(httpServletRequest,httpServletResponse);
        SelfUserDetails userInfo = new SelfUserDetails();
        userInfo.setUsername("zhangsan");
        userInfo.setPassword(new BCryptPasswordEncoder().encode("123"));

        Set authoritiesSet = new HashSet();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
        authoritiesSet.add(authority);
        TestToken token = new TestToken(userInfo);
        AuthenticationManager authenticationManager = this.getAuthenticationManager();
        authenticationManager.authenticate(token);

    }
}
