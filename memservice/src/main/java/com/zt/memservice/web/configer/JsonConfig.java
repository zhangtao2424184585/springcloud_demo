package com.zt.memservice.web.configer;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;

/**
 * @Classname JsonConfig
 * @Description TODO
 * @Date 2020/8/31 14:14
 * @Created by zhangtao
 */
public class JsonConfig<T extends JsonConfig<T, B>, B extends HttpSecurityBuilder<B>> extends AbstractHttpConfigurer<T, B> {
    private UserNamePasswordFilter userNamePasswordFilter;
    public JsonConfig( ){
        this.userNamePasswordFilter = new UserNamePasswordFilter();
    }
    @Override
    public void configure(B http) throws Exception {
        userNamePasswordFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        userNamePasswordFilter.setAuthenticationFailureHandler(new JsonFailuerHandler());
        userNamePasswordFilter.setSessionAuthenticationStrategy(new NullAuthenticatedSessionStrategy());
        UserNamePasswordFilter filter = postProcess(userNamePasswordFilter);
        http.addFilterAfter(filter, LogoutFilter.class);
    }
    //设置成功的Handler，这个handler定义成Bean，所以从外面set进来
    public JsonConfig<T,B> loginSuccessHandler(AuthenticationSuccessHandler authSuccessHandler){
        userNamePasswordFilter.setAuthenticationSuccessHandler(authSuccessHandler);
        return this;
    }
}
