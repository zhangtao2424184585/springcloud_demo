package com.example.demo.configer;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Date;

/**
 * @Classname JwtService
 * @Description TODO
 * @Date 2020/8/31 13:59
 * @Created by zhangtao
 */

public class JwtService implements UserDetailsService {
//    UsernamePasswordAuthenticationFilter
    public String saveUserLoginInfo(UserDetails user) {
        String salt = "123456ef"; //BCrypt.gensalt();  正式开发时可以调用该方法实时生成加密的salt
        /**
         * @todo 将salt保存到数据库或者缓存中
         * redisTemplate.opsForValue().set("token:"+username, salt, 3600, TimeUnit.SECONDS);
         */
        Algorithm algorithm = Algorithm.HMAC256(salt);
        Date date = new Date(System.currentTimeMillis()+3600*1000);  //设置1小时后过期
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(date)
                .withIssuedAt(new Date())
                .sign(algorithm);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return User.builder().username("zhangtao").password("123").roles("USER").build();
    }
}
