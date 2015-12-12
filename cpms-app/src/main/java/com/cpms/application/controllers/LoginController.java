package com.cpms.application.controllers;

import com.cpms.application.bean.AuthenticatedUserBean;
import com.cpms.application.bean.BasicAuthentcationBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Rakib on 12/7/2015.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private static final String VIEW_LOGIN = "login";
    private static final String VIEW_AUTH = "auth";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getLoginView(ModelMap model) {
        BasicAuthentcationBean basicAuthenticationBean = new BasicAuthentcationBean();
        model.addAttribute("basicAuthenticationBean", basicAuthenticationBean);
        return VIEW_LOGIN;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doLogin(@ModelAttribute("basicAuthenticationBean")BasicAuthentcationBean basicAuthentcationBean,
                          ModelMap model,
                          HttpServletRequest request) throws IOException {
        // POST TO SUBSCRIPTION MODULE
        HttpClient client = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(client.getParams(), 5000);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(basicAuthentcationBean);
        HttpPost post = new HttpPost(EndPoints.getSubscriptionLoginUrl());
        StringEntity entity = new StringEntity(jsonString);
        post.addHeader("Content-Type", "application/json");
        post.setEntity(entity);
        HttpResponse response = client.execute(post);
        if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            return VIEW_LOGIN;
        }

        // Login Success
        String responseObjectString = EntityUtils.toString(response.getEntity());
        AuthenticatedUserBean authenticatedUserBean = mapper.readValue(responseObjectString, AuthenticatedUserBean.class);
        model.addAttribute("authenticatedUserBean", authenticatedUserBean);
        model.addAttribute("dashboardViewUrl", EndPoints.getDashboardUrl());
        return VIEW_AUTH;
    }
}
