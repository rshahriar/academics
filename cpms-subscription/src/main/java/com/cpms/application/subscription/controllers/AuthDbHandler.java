package com.cpms.application.subscription.controllers;

import com.cpms.application.subscription.bean.UserCredentials;
import com.cpms.application.subscription.bean.UserBean;
import com.cpms.application.subscription.dao.AbstractDAO;
import com.cpms.application.subscription.model.User;

/**
 * Created by Rakib on 11/29/2015.
 */
public class AuthDbHandler {

    private AbstractDAO<User> subscriptionDAO;
    private UserCredentials userCredentials;

    public AuthDbHandler(UserCredentials userCredentials, AbstractDAO<User> subscriptionDAO) {
        this.userCredentials = userCredentials;
        this.subscriptionDAO = subscriptionDAO;
    }

    public UserBean doAuth() {
        User user = subscriptionDAO.getByEmail(userCredentials.getUserEmail());
        return user != null && user.getUser_password().equals(userCredentials.getPassword()) ? new UserBean(user) : null;
    }
}
