package com.cpms.application.subscription.controllers;

import com.cpms.application.subscription.bean.AuthBean;
import com.cpms.application.subscription.bean.UserBean;
import com.cpms.application.subscription.dao.AbstractDAO;
import com.cpms.application.subscription.model.User;

/**
 * Created by Rakib on 11/29/2015.
 */
public class AuthHandler {

    private AbstractDAO<User> subscriptionDAO;
    private AuthBean authBean;

    public AuthHandler(AuthBean authBean, AbstractDAO<User> subscriptionDAO) {
        this.authBean = authBean;
        this.subscriptionDAO = subscriptionDAO;
    }

    public UserBean doAuth() {
        User user = subscriptionDAO.getByEmail(authBean.getUser_email());
        return user != null && user.getUser_password().equals(authBean.getUser_credential()) ? new UserBean(user) : null;
    }
}
