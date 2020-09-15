package com.zt.memservice.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2020/8/17 10:25
 * @Created by zhangtao
 */
@RestController
public class TestController {
    private RestTemplate restTemplate;
    private FeignInterFaceC feignInterFaceC;
    public TestController(RestTemplate restTemplate,FeignInterFaceC feignInterFaceC){
        this.restTemplate = restTemplate;
        this.feignInterFaceC = feignInterFaceC;
    }
    @RequestMapping("/memr-service/memservice")
    public String memservice(){
        return restTemplate.getForObject("http://order-service/orderservice",String.class);
    }
    @RequestMapping("/system/memservice2")
    public String test() throws Exception {
        return feignInterFaceC.test();
    }
}
