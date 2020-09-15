package com.zt.orderservice2.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrgderServuce
 * @Description TODO
 * @Date 2020/8/17 10:43
 * @Created by zhangtao
 */
@RestController
public class OrgderServuce {
    @RequestMapping("orderservice")
    public String orderservice9(){
        return "this id oderservice 2 from 8084";
    }
}
