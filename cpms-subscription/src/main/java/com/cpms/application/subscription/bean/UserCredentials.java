package com.cpms.application.subscription.bean;

/**
 * Created by Rakib on 11/29/2015.
 */
public class UserCredentials {

    private String userEmail;
    private String password;

    public UserCredentials() {
        this.userEmail = "";
        this.password = "";
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
