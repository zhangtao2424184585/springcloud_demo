package com.zt.memservice.web;

import org.springframework.stereotype.Component;

/**
 * @Classname testShixian
 * @Description TODO
 * @Date 2020/8/17 11:09
 * @Created by zhangtao
 */
@Component
public class testShixian implements FeignInterFaceC {


    @Override
    public String test() throws Exception {
        return "出现错误 服务降级";
    }
}
