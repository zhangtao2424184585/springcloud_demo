package com.example.fff.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Classname MyConfiger
 * @Description TODO
 * @Date 2020/9/7 11:18
 * @Created by zhangtao
 */
@EnableWebSecurity
public class MyConfiger extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().anyRequest().authenticated().and()
                .formLogin().and()
                .sessionManagement().disable()
                .httpBasic().disable();
    }
}
