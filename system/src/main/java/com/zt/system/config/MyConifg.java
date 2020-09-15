package com.zt.system.config;

import com.zt.system.authenticator.GrantPermissionser;
import com.zt.system.authenticator.VerifyPermissionser;
import org.pac4j.cas.client.CasClient;
import org.pac4j.core.authorization.authorizer.ProfileAuthorizer;
import org.pac4j.core.authorization.generator.AuthorizationGenerator;
import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;
import org.pac4j.http.client.indirect.FormClient;
import org.pac4j.springframework.web.CallbackController;
import org.pac4j.springframework.web.LogoutController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Classname MyConifg
 * @Description TODO
 * @Date 2020/8/14 10:53
 * @Created by zhangtao
 */
@Configuration
@PropertySource(value = "classpath:pac4j.properties")
public class MyConifg {
    private FormClient client;
    private CasClient casClient;
    public MyConifg(FormClient client,CasClient casClient){
        this.client = client;
        this.casClient = casClient;
    }
    @Bean
    public Config pac4jConfig(AuthorizationGenerator authorizationGenerator, ProfileAuthorizer profileAuthorizer){
        Clients clients = new Clients(client,casClient);
        clients.addAuthorizationGenerator(authorizationGenerator);

        Config config = new Config(clients);

        config.addAuthorizer("VerifyPermissionser",profileAuthorizer);
        return config;
    }
    @Bean
    public AuthorizationGenerator authorizationGenerator(){
        return new GrantPermissionser();
    }
    @Bean
    public ProfileAuthorizer profileAuthorizer(){
        return new VerifyPermissionser();
    }
    @Bean
    public CallbackController callbackController(){
        return new CallbackController();
    }
    @Bean
    public LogoutController logoutController(){
        return new LogoutController();
    }
}
