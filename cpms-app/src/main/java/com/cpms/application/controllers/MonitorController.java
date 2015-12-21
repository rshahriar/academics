package com.cpms.application.controllers;

import com.cpms.application.bean.AppConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;
import java.net.MalformedURLException;
import java.util.HashMap;

/**
 * Created by Rakib on 11/22/2015.
 */
@Controller
@RequestMapping(value = "/monitor")
public class MonitorController {

    @Autowired
    private AppConfig appConfig;

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MonitorController.class);

    @RequestMapping(value = "/{machineId}", method = RequestMethod.GET)
    public String getMonitorView(@PathVariable String machineId, ModelMap model) {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet request = new HttpGet(appConfig.getPublishedMachineUrl(machineId));
            request.addHeader("accpet", "application/json");
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output = br.readLine();
            logger.debug("JSON response : "+ output);
            HashMap<String, Object> jsonMap = new ObjectMapper().readValue(output, HashMap.class);

            model.addAttribute("machineId", jsonMap.get("machineId"));
            model.addAttribute("machineModel", jsonMap.get("machineModel"));
            model.addAttribute("controlServiceUrl", jsonMap.get("controlServiceUrl"));
            model.addAttribute("monitorServiceUrl", jsonMap.get("monitorServiceUrl"));
            model.addAttribute("statusServiceUrl", jsonMap.get("statusServiceUrl"));
            model.addAttribute("characteristicsServiceUrl", jsonMap.get("characteristicsServiceUrl"));

            httpClient.getConnectionManager().shutdown();
        } catch (MalformedURLException e) {
            logger.error("BAD URL");
        } catch (ClientProtocolException e) {
            logger.error("Exception occurred for HTTP call");
        } catch (IOException e) {
            logger.error("Exception occurred for parsing");
        }
        return "monitor";
    }
}
