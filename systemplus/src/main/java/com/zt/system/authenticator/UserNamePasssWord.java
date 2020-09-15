package com.zt.system.authenticator;

import org.pac4j.core.context.WebContext;
import org.pac4j.core.credentials.UsernamePasswordCredentials;
import org.pac4j.core.credentials.authenticator.Authenticator;
import org.pac4j.core.exception.CredentialsException;
import org.pac4j.core.profile.CommonProfile;
import org.springframework.stereotype.Component;

/**
 * @Classname UserNamePasssWord
 * @Description TODO
 * @Date 2020/8/13 17:37
 * @Created by zhangtao
 */
@Component
public class UserNamePasssWord implements  Authenticator<UsernamePasswordCredentials> {
    @Override
    public void validate(UsernamePasswordCredentials usernamePasswordCredentials, WebContext webContext) {
        String username = usernamePasswordCredentials.getUsername();
        if (!username.equals("zhangtao")&&!username.equals("zhangtao1")){
            throw new CredentialsException("账户错误");
        }
        final CommonProfile profile = new CommonProfile();
        profile.setId(username);
        profile.addAttribute("username",username);
        usernamePasswordCredentials.setUserProfile(profile);
    }
}
