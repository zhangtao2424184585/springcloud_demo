package com.zt.memservice.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Classname SesiionTest
 * @Description TODO
 * @Date 2020/8/18 14:12
 * @Created by zhangtao
 */
@RestController
public class SesiionTest {
    @RequestMapping("session")
    public String session(HttpSession session){
        return session.getId();
    }
}
