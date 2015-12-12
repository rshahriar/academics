package com.cpms.application.subscription.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Rakib on 12/6/2015.
 */
public class AuthenticationUser {
    private String userEmail;
    private String password;
    private Long expires;
    private Integer userRole;

    public AuthenticationUser() {
        userEmail = "";
        password = "";
        expires = 0L;
        userRole = 0;
    }

    public AuthenticationUser(UserCredentials credentials, Long expires, Integer userRole) {
        userEmail = credentials.getUserEmail();
        password = credentials.getPassword();
        this.expires = expires;
        this.userRole = userRole;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

//    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }
}
