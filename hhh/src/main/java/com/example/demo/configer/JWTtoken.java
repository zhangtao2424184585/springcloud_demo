package com.example.demo.configer;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * @Classname JWTtoken
 * @Description TODO
 * @Date 2020/9/9 9:52
 * @Created by zhangtao
 */
public class JWTtoken extends AbstractAuthenticationToken {

    private UserDetails credentials;
    private String Principal;
    private String token;

    /**
     * Creates a token with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     */
    public JWTtoken(Collection<? extends GrantedAuthority> authorities) {
        super(Collections.emptyList());
    }

    public JWTtoken() {
        super(Collections.emptyList());
    }

    @Override
    public UserDetails getCredentials() {
        return credentials;
    }

    public void setCredentials(UserDetails credentials) {
        this.credentials = credentials;
    }

    @Override
    public String getPrincipal() {
        return Principal;
    }

    public void setPrincipal(String principal) {
        Principal = principal;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
