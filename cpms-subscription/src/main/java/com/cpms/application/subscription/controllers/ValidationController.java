package com.cpms.application.subscription.controllers;

import com.cpms.application.subscription.dao.AbstractDAO;
import com.cpms.application.subscription.model.User;
import com.google.common.base.Strings;
import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Rakib on 12/11/2015.
 */

@Controller
@RequestMapping(value = "validate")
public class ValidationController {

    private final static Logger logger = LoggerFactory.getLogger(ValidationController.class);

    @Autowired
    private AbstractDAO<User> subscriptionDAO;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> validateToken(@RequestParam("token") String token, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        if (Strings.isNullOrEmpty(token)) {
            return new ResponseEntity<String>("Bad Token", HttpStatus.BAD_REQUEST);
        }
        TokenHandler tokenHandler = new TokenHandler(subscriptionDAO);
        try {
            tokenHandler.parseUserFromToken(token);
            logger.debug("Valid token: {}", token);
        } catch (IOException e) {
            return new ResponseEntity<>("Invalid Token", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}