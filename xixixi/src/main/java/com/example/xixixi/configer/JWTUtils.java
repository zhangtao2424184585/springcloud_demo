package com.example.xixixi.configer;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Classname JWTUtils
 * @Description TODO
 * @Date 2020/9/1 16:29
 * @Created by zhangtao
 */
public class JWTUtils {
    public String getToken(String name){
        String key = "1234123412341234123412341234123412341234";
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        String token = Jwts.builder()
                .setSubject("hello world")
                .signWith(secretKey)
                .compact();
        return token;
    }
    public String checkToken(String token){
        String key1 = "1234123412341234123412341234123412341234";
        SecretKey secretKey = new SecretKeySpec(key1.getBytes(), SignatureAlgorithm.HS256.getJcaName());

        try {

            SecretKeySpec secretKeySpec = new SecretKeySpec(key1.getBytes(), SignatureAlgorithm.HS256.getJcaName());
            Jwts.parser().setSigningKey(secretKeySpec).parseClaimsJws(token);
            System.out.println("验证成功");
        }catch (JwtException e){
            System.out.println("验证失败");
        }
        Claims body = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return body.getSubject();
    }
}
