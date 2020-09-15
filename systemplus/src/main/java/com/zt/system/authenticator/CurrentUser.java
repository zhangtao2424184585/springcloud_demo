package com.zt.system.authenticator;

/**
 * @Classname CurrentUser
 * @Description TODO
 * @Date 2020/8/14 10:25
 * @Created by zhangtao
 */
public class CurrentUser {
    private String username;
    private Boolean isAdmin;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
