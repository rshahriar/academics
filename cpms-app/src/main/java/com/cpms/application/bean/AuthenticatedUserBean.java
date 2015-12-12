package com.cpms.application.bean;

/**
 * Created by Rakib on 12/7/2015.
 */
public class AuthenticatedUserBean {

    private String userEmail;
    private String userToken;
    private Integer userRole;

    public AuthenticatedUserBean() {
        userEmail = "";
        userToken = "";
        userRole = 0;
    }

    public AuthenticatedUserBean(String userEmail, String userToken, Integer userRole) {
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
