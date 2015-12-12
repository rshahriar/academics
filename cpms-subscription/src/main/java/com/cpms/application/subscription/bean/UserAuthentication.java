package com.cpms.application.subscription.bean;

/**
 * Created by Rakib on 12/6/2015.
 */
public class UserAuthentication {

    private AuthenticationUser details;

    public UserAuthentication(AuthenticationUser user) {
    }

    public AuthenticationUser getDetails() {
        return details;
    }

    public void setDetails(AuthenticationUser details) {
        this.details = details;
    }
}
