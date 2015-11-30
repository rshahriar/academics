package com.cpms.application.subscription.controllers;

import com.cpms.application.subscription.bean.UserBean;
import com.cpms.application.subscription.dao.AbstractDAO;
import com.cpms.application.subscription.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Rakib on 11/29/2015.
 */
@Controller
@RequestMapping(value = "/machines")
public class MachineSubscriptionController {

    @Autowired
    AbstractDAO<User> userDAO;

    @RequestMapping(value = "/subscribed/{user_id}")
    public @ResponseBody UserBean getUser(@PathVariable("user_id") int userId) {
        User user = userDAO.getById(userId);
        return new UserBean(user);
    }
}
