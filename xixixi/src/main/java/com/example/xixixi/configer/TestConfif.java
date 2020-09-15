package com.example.xixixi.configer;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.logout.LogoutFilter;

/**
 * @Classname TestConfif
 * @Description TODO
 * @Date 2020/9/1 17:03
 * @Created by zhangtao
 */
public class TestConfif<T extends JsonConfig<T, B>, B extends HttpSecurityBuilder<B>> extends AbstractHttpConfigurer<T, B> {
    private TestFilter testFilter;
    public TestConfif(){
        this.testFilter = new TestFilter();
    }
    @Override
    public void configure(B builder) throws Exception {
        testFilter.setAuthenticationManager(builder.getSharedObject(AuthenticationManager.class));
        TestFilter filter = postProcess(testFilter);
        builder.addFilterAfter(filter, LogoutFilter.class);
    }
}
