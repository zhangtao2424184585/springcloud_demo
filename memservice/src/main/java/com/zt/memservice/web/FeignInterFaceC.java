package com.zt.memservice.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname FeignInterFaceC
 * @Description TODO
 * @Date 2020/8/17 10:59
 * @Created by zhangtao
 */
@FeignClient(value = "order-service", fallback = testShixian.class)
public interface FeignInterFaceC {
    @RequestMapping("orderservice")
    String test() throws Exception;
}
