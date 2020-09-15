package com.example.xixixi.configer;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

/**
 * @Classname TestToken
 * @Description TODO
 * @Date 2020/9/1 16:47
 * @Created by zhangtao
 */
public class TestToken extends AbstractAuthenticationToken {
    public TestToken(UserDetails principal){
        super(Collections.emptyList());
        this.principal = principal;
    }

    private String credentials;
    private UserDetails principal;

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}
