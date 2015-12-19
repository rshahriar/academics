package com.cpms.application.controllers;

import com.cpms.application.bean.SubscribedMachineBean;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by Rakib on 11/30/2015.
 */

@Controller
@RequestMapping(value = "/subscription")
public class SubscriptionController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(SubscriptionController.class);


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getSubscribableList(ModelMap model) {
        model.addAttribute("baseUrl", EndPoints.getBaseUrl());
        model.addAttribute("machineListUrl", EndPoints.getPublishedMachineListUrl());
        return "subscribableList";
    }

    @RequestMapping(value = "/{machineId}", method = RequestMethod.GET)
    public String getSubscriptionView(@PathVariable("machineId") Integer machineId, ModelMap model) {
        model.addAttribute("machineId", machineId);
        model.addAttribute("subscriptionUrl", EndPoints.getMachineSubscriptionUrl());
        model.addAttribute("subscriptionListViewUrl", EndPoints.getSubscribableMachineListViewUrl());
        return "subscribe";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String subscribe(@ModelAttribute("machineEntry") SubscribedMachineBean subscribedMachineBean,
                            HttpServletRequest request, ModelMap model) {
        String message = "Failed to subscribe machine";
        String url = "http://130.184.104.115:8084/cpms-subscription/machines/subscribe?userEmail="
                + subscribedMachineBean.getUserEmail() + "&machineId=" + subscribedMachineBean.getMachineId()
                + "&remark=" + subscribedMachineBean.getRemark();
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("accpet", "application/json");
            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                message = "Successfully subscribed machine";
            }
        } catch (MalformedURLException e) {
            logger.error("BAD URL");
        } catch (ClientProtocolException e) {
            logger.error("Exception occurred for HTTP call");
        } catch (IOException e) {
            logger.error("Exception occurred for parsing");
        }
        model.addAttribute("message", message);
        model.addAttribute("dashboard", EndPoints.getURLWithContextPath(request) + "?userEmail=" + subscribedMachineBean.getUserEmail());
        return "subscription_success";
    }
}
