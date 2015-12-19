package com.cpms.application.controllers;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Rakib on 11/21/2015.
 */
public class EndPoints {

    private static final String serviceRepositoryBaseUrl = "http://130.184.104.115:8081/ServiceRepository";
    private static final String virtualizationServiceBaseUrl = "http://130.184.104.115:8082/virtulization";
    private static final String baseUrl = "http://130.184.104.115:8083/cpms-app";
    private static final String subscriptionBaseUrl = "http://130.184.104.115:8084/cpms-subscription";

    public static String getURLWithContextPath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getLoginUrl() {
        return getUrl("login");
    }

    public static String getDashboardUrl() {
        return getUrl("dashboard");
    }

    public static String getSubscribableMachineListViewUrl() {
        return getUrl("subscription/list");
    }

    public static String getSubscribedMachineListUrl() {
        return getUrl(subscriptionBaseUrl, "machines/subscribed");
    }

    public static String getMachineSubscriptionUrl() {
        return getUrl(subscriptionBaseUrl, "machines/subscribe");
    }

    public static String getPublishedMachineListUrl() {
        return getUrl(serviceRepositoryBaseUrl, "machines");
    }

    public static String getMachineRegistrationUrl() {
        return getUrl("publish");
    }

    public static String getServiceRepositoryBaseUrl() {
        return serviceRepositoryBaseUrl;
    }

    public static String getSubscriptionLoginUrl() {
        return getUrl(subscriptionBaseUrl, "login");
    }

    private static String getUrl(String remainderUrl) {
        return String.format("%s/%s", baseUrl, remainderUrl);
    }

    private static String getUrl(String prefix, String suffix) {
        return String.format("%s/%s", prefix, suffix);
    }
}
