package com.cpms.application.bean;

/**
 * Created by Rakib on 12/7/2015.
 */
public class BasicAuthentcationBean {
    private String userEmail;
    private String password;

    public BasicAuthentcationBean() {
        userEmail = "rakib@uark.edu";
        password = "1234";
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
