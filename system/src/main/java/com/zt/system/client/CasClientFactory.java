package com.zt.system.client;

import org.pac4j.cas.client.CasClient;
import org.pac4j.cas.config.CasConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname CasClientFactory
 * @Description TODO
 * @Date 2020/8/14 14:27
 * @Created by zhangtao
 */
@Configuration
public class CasClientFactory {
    @Bean
    public CasClient casClient(){
        CasConfiguration casConfiguration = new CasConfiguration("http://192.168.1.73/cas/login");
        return new CasClient(casConfiguration);
    }
}
