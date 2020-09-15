package com.example.fff.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2020/9/7 11:33
 * @Created by zhangtao
 */
@RestController
public class TestController {
    @RequestMapping("test")
    @MyZhujie
    public String aaa(HttpServletRequest request){
        HttpSession session = request.getSession();
        System.out.println(session);

        System.out.println();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String header = request.getHeader(headerNames.nextElement());
            System.out.println(header);
        }
        return "hello";
    }
    @RequestMapping("/heihei")
    @MyZhujie
    public String heihei(){
        return "heihei";
    }
}
