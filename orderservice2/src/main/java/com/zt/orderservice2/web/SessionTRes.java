package com.zt.orderservice2.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Classname SessionTRes
 * @Description TODO
 * @Date 2020/8/18 14:13
 * @Created by zhangtao
 */
@RestController
public class SessionTRes {
    @RequestMapping("session")
    public String session(HttpSession session) {
        return session.getId();
    }
}

