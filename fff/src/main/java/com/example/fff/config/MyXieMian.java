package com.example.fff.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Classname MyXieMian
 * @Description TODO
 * @Date 2020/9/7 17:33
 * @Created by zhangtao
 */
@Aspect
@Component
public class MyXieMian {
    @Before("execution(* com.example.fff.config.MyZhujie())")
//    @Before("execution(* com.sharpcj.aopdemo.test1.IBuy.buy(..))")
    public void xixi(){
        System.out.println("111");
    }
}
