package com.zt.system.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname TestContrller
 * @Description TODO
 * @Date 2020/8/14 14:23
 * @Created by zhangtao
 */
@RestController
public class TestContrller {
    @RequestMapping("test")
    public String test(){
        return "success";
    }
}
