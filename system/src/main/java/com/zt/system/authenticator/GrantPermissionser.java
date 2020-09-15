package com.zt.system.authenticator;

import org.pac4j.core.authorization.generator.AuthorizationGenerator;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.profile.UserProfile;

import java.util.Optional;

/**
 * @Classname GrantPermissionser
 * @Description TODO
 * @Date 2020/8/14 9:59
 * @Created by zhangtao
 */
public class GrantPermissionser implements AuthorizationGenerator{

    @Override
    public Optional<UserProfile> generate(WebContext webContext, UserProfile userProfile) {
        System.out.println("11111");
        String id = userProfile.getId();
        CurrentUser user = new CurrentUser();
        if (id.equals("zhangtao")){
            userProfile.addRole("admin");
            userProfile.addPermission("all");
            user.setAdmin(true);
            user.setUsername("超级管理员");

        }else if (id.equals("zhangtao1")){
            userProfile.addPermission("shanchu");
            userProfile.addRole("common");
            user.setUsername("普通用户");
        }
        Optional<UserProfile> optional = Optional.ofNullable(userProfile);
        return optional;
    }
}
