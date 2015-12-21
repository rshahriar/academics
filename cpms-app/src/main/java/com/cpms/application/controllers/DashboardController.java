package com.cpms.application.controllers;

import com.cpms.application.bean.AppConfig;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Rakib on 12/10/2015.
 */
@Controller
@RequestMapping(value = "dashboard")
public class DashboardController {

    @Autowired
    private AppConfig appConfig;

    private static final String VIEW_DASHBOARD = "dashboard";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getDashboardView(ModelMap model) {
        model.addAttribute("loginViewUrl", appConfig.getLoginUrl());
        model.addAttribute("registerMachineViewUrl", appConfig.getMachineRegistrationViewUrl());
        model.addAttribute("subscribableListViewUrl", appConfig.getSubscribableMachineListViewUrl());
        model.addAttribute("baseUrl", appConfig.getBaseUrl());
        model.addAttribute("machineListUrl", appConfig.getSubscribedMachineListUrl());
        model.addAttribute("publishedMachineListUrl", appConfig.getPublishedMachineListUrl());
        model.addAttribute("tokenValidationUrl", appConfig.getSubscriptionValidationUrl());
        logger.debug("Loading dashboard.......");
        return VIEW_DASHBOARD;
    }
}
