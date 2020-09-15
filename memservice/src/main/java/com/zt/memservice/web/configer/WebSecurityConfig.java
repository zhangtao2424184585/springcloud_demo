package com.zt.memservice.web.configer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.header.Header;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * @Classname WebSecurityConfig
 * @Description TODO
 * @Date 2020/8/31 14:26
 * @Created by zhangtao
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin/**")
//                .authenticated()
//                .and()
//                .formLogin().disable()
//                .cors().disable()
//                .sessionManagement().disable()
//                .headers().addHeaderWriter(new StaticHeadersWriter(Arrays.asList(
//                new Header("Access-control-Allow-Origin", "*"),
//                new Header("Access-Control-Expose-Headers", "Authorization"))))
//                .and()
//                .addFilterAfter(new OptionsRequestFilter(), CorsFilter.class)
//                .apply(new JsonConfig<>()).loginSuccessHandler(jsonLoginSuccessHandler());
        http
                .addFilterBefore(jwtAuthenticationTokenFilter, BasicAuthenticationFilter.class)
                .authorizeRequests()

//                .antMatchers("/login.html").permitAll()
//                .antMatchers("/image/**").permitAll()
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
//                .antMatchers("/hello").hasRole("USER")
                .anyRequest()
//                .authenticated()
//                .permitAll()
                .access("@rbacauthorityservice.hasPermission(request,authentication)") // RBAC 动态 url 认证
                .and()
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement()
                .disable()
                .cors()
                .and()
                .headers().addHeaderWriter(new StaticHeadersWriter(Arrays.asList(
                new Header("Access-control-Allow-Origin", "*"),
                new Header("Access-Control-Expose-Headers", "Authorization"))))
                .and()
                .addFilterAfter(new OptionsRequestFilter(), CorsFilter.class)
                .apply(new JsonConfig<>()).loginSuccessHandler(jsonLoginSuccessHandler());
//                .and()
//                .apply(new TestConfif<>());
    }

    @Bean
    protected JsonLoginSuccessHandler jsonLoginSuccessHandler() {
        return new JsonLoginSuccessHandler(jwtUserService());
    }
    @Bean("jwtUserService")
    protected JwtService jwtUserService() {
        return new JwtService();
    }

    @Bean
    protected CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "HEAD", "OPTION"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.addExposedHeader("Authorization");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}
