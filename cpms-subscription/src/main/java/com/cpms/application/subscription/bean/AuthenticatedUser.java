package com.cpms.application.subscription.bean;

/**
 * Created by Rakib on 12/7/2015.
 */
public class AuthenticatedUser {

    private String userEmail;
    private String userToken;
    private Integer userRole;

    public AuthenticatedUser() {
        userEmail = "";
        userToken = "";
        userRole = 0;
    }

    public AuthenticatedUser(String userEmail, String userToken, Integer userRole) {
        this.userEmail = userEmail;
        this.userToken = userToken;
        this.userRole = userRole;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }
}
