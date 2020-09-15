package com.zt.system.authenticator;

import org.pac4j.core.authorization.authorizer.ProfileAuthorizer;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.profile.UserProfile;

import java.util.List;

/**
 * @Classname VerifyPermissionser
 * @Description TODO
 * @Date 2020/8/14 10:16
 * @Created by zhangtao
 */
public class VerifyPermissionser extends ProfileAuthorizer {
    @Override
    public boolean isAuthorized(WebContext webContext, final List profiles) {
        return isAnyAuthorized(webContext,profiles);
    }

    @Override
    protected boolean isProfileAuthorized(WebContext webContext, UserProfile userProfile) {
        System.out.println("2222");
        if (userProfile.getId().equals("zhangtao")){
            return true;
        }
        return false;
    }
}
