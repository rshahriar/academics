package com.cpms.application.controllers;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Rakib on 11/21/2015.
 */
public class Utils {

    public static String getURLWithContextPath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
