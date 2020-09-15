package com.example.xixixi.configer;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Classname TestProvider
 * @Description TODO
 * @Date 2020/9/1 17:00
 * @Created by zhangtao
 */
public class TestProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("执行了 provider");
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        TestToken token = new TestToken(principal);
        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(TestToken.class);
    }
}
