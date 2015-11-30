package com.cpms.application.subscription.controllers;

import com.cpms.application.subscription.bean.AuthBean;
import com.cpms.application.subscription.dao.AbstractDAO;
import com.cpms.application.subscription.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Rakib on 11/29/2015.
 */

@Controller
public class LoginController {

    @Autowired
    private AbstractDAO<User> subscriptionDAO;

    private static final String VIEW_INDEX = "index";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getLoginView(Map<String, Object> model) {
        model.put("userAuth", new AuthBean());
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView doLogin(@ModelAttribute("userAuth") AuthBean userAuth, ModelMap model, HttpServletRequest request) {
        AuthHandler handler = new AuthHandler(userAuth, subscriptionDAO);
        if (handler.doAuth() == null) {
            // login error
            model.addAttribute("retryUrl", Utils.getURLWithContextPath(request));
            return new ModelAndView("auth_failed");
        } else {
            // login success
            model.addAttribute("authStatus", "1");
            return new ModelAndView("redirect:" + "http://130.184.104.115:8083/cpms-app/");
        }
    }
}
