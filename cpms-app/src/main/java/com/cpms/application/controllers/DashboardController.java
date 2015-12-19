package com.cpms.application.controllers;

import org.slf4j.LoggerFactory;
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

    private static final String VIEW_DASHBOARD = "dashboard";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getDashboardView(ModelMap model) {
        model.addAttribute("loginViewUrl", EndPoints.getLoginUrl());
        model.addAttribute("registerMachineViewUrl", EndPoints.getMachineRegistrationUrl());
        model.addAttribute("subscribableListViewUrl", EndPoints.getSubscribableMachineListViewUrl());
        model.addAttribute("baseUrl", EndPoints.getBaseUrl());
        model.addAttribute("machineListUrl", EndPoints.getSubscribedMachineListUrl());
        logger.debug("Loading dashboard.......");
        return VIEW_DASHBOARD;
    }
}
