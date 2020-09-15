package com.example.demo.configer;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.jaas.AbstractJaasAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @Classname JwtTokenProvider
 * @Description TODO
 * @Date 2020/9/9 9:49
 * @Created by zhangtao
 */
@Component
public class JwtTokenProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return authentication.isAssignableFrom(JWTtoken.class);
    }
}
