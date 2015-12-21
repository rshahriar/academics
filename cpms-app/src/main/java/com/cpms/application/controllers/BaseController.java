package com.cpms.application.controllers;

import com.cpms.application.bean.AppConfig;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Rakib on 11/22/2015.
 */

@Controller
@RequestMapping(value = "/")
public class BaseController {

    @Autowired
    private AppConfig appConfig;

    private static final String VIEW_INDEX = "index";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getView(ModelMap model) {
        model.addAttribute("loginViewUrl", appConfig.getLoginUrl());
        model.addAttribute("dashboardViewUrl", appConfig.getDashboardViewUrl());
        return VIEW_INDEX;
    }
}