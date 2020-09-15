package com.example.xixixi.configer;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @Classname JsonConfig
 * @Description TODO
 * @Date 2020/8/31 14:14
 * @Created by zhangtao
 */
public class JwtConfig<T extends JwtConfig<T, B>, B extends HttpSecurityBuilder<B>> extends AbstractHttpConfigurer<T, B> {
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    public JwtConfig( ){
        this.jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
    }
    @Override
    public void configure(B http) throws Exception {
        jwtAuthenticationTokenFilter.setManager(http.getSharedObject(AuthenticationManager.class));
        JwtAuthenticationTokenFilter filter = postProcess(jwtAuthenticationTokenFilter);
        http.addFilterBefore(filter, BasicAuthenticationFilter.class);
    }
//    //设置成功的Handler，这个handler定义成Bean，所以从外面set进来
//    public JwtConfig<T,B> loginSuccessHandler(AuthenticationSuccessHandler authSuccessHandler){
//        userNamePasswordFilter.setAuthenticationSuccessHandler(authSuccessHandler);
//        return this;
//    }
}
