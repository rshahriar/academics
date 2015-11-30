package com.cpms.application.subscription.bean;

/**
 * Created by Rakib on 11/29/2015.
 */
public class AuthBean {

    private String user_email;
    private String user_credential;

    public AuthBean() {
        this.user_email = "";
        this.user_credential = "";
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_credential() {
        return user_credential;
    }

    public void setUser_credential(String user_credential) {
        this.user_credential = user_credential;
    }
}
