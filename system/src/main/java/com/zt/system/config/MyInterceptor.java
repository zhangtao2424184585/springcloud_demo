package com.zt.system.config;

import org.pac4j.core.config.Config;
import org.pac4j.springframework.web.SecurityInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * @Classname MyInterceptor
 * @Description TODO
 * @Date 2020/8/14 11:05
 * @Created by zhangtao
 */
@Configuration
public class MyInterceptor implements WebMvcConfigurer {
    private Config config;
    public MyInterceptor(Config config){
        this.config = config;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new SecurityInterceptor(config, "FormClient", "VerifyPermissionser"));
        interceptorRegistration.addPathPatterns("/**");
        interceptorRegistration.excludePathPatterns(Arrays.asList("/callback", "/error/**","/authe/**"));
    }
}
