package com.example.demo.configer;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @Classname JWtConfiguer
 * @Description TODO
 * @Date 2020/9/9 9:54
 * @Created by zhangtao
 */
public class JWtConfiguer <T extends JsonConfig<T, B>, B extends HttpSecurityBuilder<B>> extends AbstractHttpConfigurer<T, B> {
    private JwtAuthenticationTokenFilter filter;
    public JWtConfiguer(){
        filter = new JwtAuthenticationTokenFilter();
    }
    @Override
    public void configure(B builder) throws Exception {
        filter.setAuthenticationManager(builder.getSharedObject(AuthenticationManager.class));
        filter = postProcess(filter);
        builder.addFilterBefore(filter, BasicAuthenticationFilter.class);
    }
}
