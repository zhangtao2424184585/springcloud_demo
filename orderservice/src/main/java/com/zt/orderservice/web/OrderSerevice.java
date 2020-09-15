package com.zt.orderservice.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderSerevice
 * @Description TODO
 * @Date 2020/8/17 10:29
 * @Created by zhangtao
 */
@RestController
public class OrderSerevice {
    @RequestMapping("orderservice")
    public String orderservice(){
        return "this id orderservice1  from 8083";
    }
}
