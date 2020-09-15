package com.example.demo.configer;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 2020/8/31 14:47
 * @Created by zhangtao
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request) {
        String authorization = request.getHeader("authorization");
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            System.out.println(s);

        }
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authorization);
        return "hello world";
    }

    @RequestMapping("/xixi")
    public String xixi() {
        return "xixi";
    }
    @RequestMapping(value = "/system/username", method = RequestMethod.GET)
    public String currentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        return "";
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    public String ccurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        return "";
    }
}


