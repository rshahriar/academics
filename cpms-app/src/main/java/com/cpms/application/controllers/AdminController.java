package com.cpms.application.controllers;

import com.cpms.application.bean.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Rakib on 12/20/2015.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AppConfig appConfig;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getMachineRegistrationView(ModelMap model) {
        model.addAttribute("dashboardUrl", appConfig.getDashboardViewUrl());
        model.addAttribute("registrationUrl", appConfig.getMachineRegistrationUrl());
        return "registerNewMachine";
    }

    @RequestMapping(value = "/update/{machineId}", method = RequestMethod.GET)
    public String getMachineUpdateView(@PathVariable("machineId") Integer machineId, ModelMap model) {
        model.addAttribute("machineId", machineId);
        model.addAttribute("selfUrl", appConfig.getMachineServicesUpdateViewUrl(machineId));
        model.addAttribute("machineServicesUrl", appConfig.getPublishedMachineUrl(String.valueOf(machineId.intValue())));
        model.addAttribute("servicePublishUrl", appConfig.getServicePublishUrl());
        return "updateMachine";
    }
}
