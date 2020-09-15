package com.zt.system.client;

import com.zt.system.authenticator.UserNamePasssWord;
import org.pac4j.http.client.indirect.FormClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname FormClientFactory
 * @Description TODO
 * @Date 2020/8/13 18:23
 * @Created by zhangtao
 */
@Configuration
public class FormClientFactory {
    private  UserNamePasssWord userNamePasssWord;
    public FormClientFactory(UserNamePasssWord userNamePasssWord){
        this.userNamePasssWord = userNamePasssWord;
    }
    @Bean
    public FormClient formClient(){
        System.out.println("FormClient 注册成功");
        System.out.println(userNamePasssWord);
        return new FormClient("http://localhost:8080/authe/index.html",userNamePasssWord);
    }
}
