package com.example.demo.configer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Classname SecurityConfig
 * @Description TODO
 * @Date 2020/8/27 15:15
 * @Created by zhangtao
 */

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;
    public SecurityConfig(@Qualifier("userDetailsService") UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(rawPassword.toString());
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.formLogin().loginPage("/auth/login.html")
               .loginProcessingUrl("/login")
               .usernameParameter("username")
               .passwordParameter("password")
               .failureForwardUrl("http://lcaohost:8081/auth/login.html222")
               .and()
               .authorizeRequests()
               .antMatchers("/auth/login.html","/login")
               .permitAll()
               .antMatchers("/admin/**")
               .authenticated()
               .antMatchers("/**")
               .authenticated()
               .and()
               .csrf().disable();
       http.logout().logoutUrl("/logout");

    }
}
