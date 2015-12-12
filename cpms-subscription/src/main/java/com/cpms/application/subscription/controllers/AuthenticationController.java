package com.cpms.application.subscription.controllers;

import com.cpms.application.subscription.bean.AuthenticatedUser;
import com.cpms.application.subscription.bean.AuthenticationUser;
import com.cpms.application.subscription.bean.UserBean;
import com.cpms.application.subscription.bean.UserCredentials;
import com.cpms.application.subscription.dao.AbstractDAO;
import com.cpms.application.subscription.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Rakib on 11/29/2015.
 */

@Controller
public class AuthenticationController {

    private static final long THIRY_MINUTES = 1000 * 60 * 30;

    @Autowired
    private AbstractDAO<User> subscriptionDAO;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<AuthenticatedUser> doLogin(@RequestBody UserCredentials credentials) throws JsonProcessingException {
        AuthDbHandler handler = new AuthDbHandler(credentials, subscriptionDAO);
        UserBean userBean = handler.doAuth();
        if (userBean == null) {
            // login error
            AuthenticatedUser user = new AuthenticatedUser();
            return new ResponseEntity<>(user, HttpStatus.UNAUTHORIZED);
        } else {
            // login success
            AuthenticationUser authenticationUser = new AuthenticationUser(credentials, System.currentTimeMillis() + THIRY_MINUTES, userBean.getUserRole());
            TokenHandler tokenHandler = new TokenHandler(subscriptionDAO);
            String token = tokenHandler.createTokenForUser(authenticationUser);
            AuthenticatedUser user = new AuthenticatedUser(userBean.getEmail(), token, userBean.getUserRole());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }
}
