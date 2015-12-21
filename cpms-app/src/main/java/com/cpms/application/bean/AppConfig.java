package com.cpms.application.bean;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Rakib on 11/21/2015.
 */
public class AppConfig {

    private String serviceRepositoryBaseUrl;
    private String virtualizationServiceBaseUrl;
    private String baseUrl;
    private String subscriptionBaseUrl;

    public AppConfig() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            //load a properties file from class path, inside static method
            prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

            //get the property value and print it out
            serviceRepositoryBaseUrl = prop.getProperty("serviceRepository");
            virtualizationServiceBaseUrl = prop.getProperty("virtualization");
            baseUrl = prop.getProperty("cpmsApp");
            subscriptionBaseUrl = prop.getProperty("cpmsSubscribption");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getURLWithContextPath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getLoginUrl() {
        return getUrl("login");
    }

    public String getDashboardViewUrl() {
        return getUrl("dashboard");
    }

    public String getMachineServicesUpdateViewUrl(Integer machineId) {
        String urlCluase = String.format("update/%s", String.valueOf(machineId.intValue()));
        return getUrl(urlCluase);
    }

    public String getSubscribableMachineListViewUrl() {
        return getUrl("subscription/list");
    }

    public String getSubscriptionValidationUrl() {
        return getUrl(subscriptionBaseUrl, "validate");
    }

    public String getSubscribedMachineListUrl() {
        return getUrl(subscriptionBaseUrl, "machines/subscribed");
    }

    public String getMachineSubscriptionUrl() {
        return getUrl(subscriptionBaseUrl, "machines/subscribe");
    }

    public String getPublishedMachineListUrl() {
        return getUrl(serviceRepositoryBaseUrl, "machines");
    }

    public String getPublishedMachineUrl(String machineId) {
        String urlClause = String.format("machines/%s", machineId);
        return getUrl(serviceRepositoryBaseUrl, urlClause);
    }

    public String getMachineServicesUrl(Integer machineId) {
        String urlClause = String.format("%s/services", String.valueOf(machineId.intValue()));
        return getUrl(serviceRepositoryBaseUrl, urlClause);
    }

    public String getMachineRegistrationViewUrl() {
        return getUrl("admin/register");
    }

    public String getMachineRegistrationUrl() {
        return getUrl(serviceRepositoryBaseUrl, "register/machine");
    }

    public String getServicePublishUrl() {
        return getUrl(serviceRepositoryBaseUrl, "register/service");
    }

    public String getServiceRepositoryBaseUrl() {
        return serviceRepositoryBaseUrl;
    }

    public String getSubscriptionLoginUrl() {
        return getUrl(subscriptionBaseUrl, "login");
    }

    private String getUrl(String remainderUrl) {
        return String.format("%s/%s", baseUrl, remainderUrl);
    }

    private String getUrl(String prefix, String suffix) {
        return String.format("%s/%s", prefix, suffix);
    }
}
