package com.cpms.application.subscription.controllers;

import com.cpms.application.subscription.bean.SubscribedMachineBean;
import com.cpms.application.subscription.bean.UserBean;
import com.cpms.application.subscription.dao.AbstractDAO;
import com.cpms.application.subscription.model.SubscribedMachine;
import com.cpms.application.subscription.model.User;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Rakib on 11/29/2015.
 */
@Controller
@RequestMapping(value = "/machines")
public class MachineSubscriptionController {

    private final static Logger logger = LoggerFactory.getLogger(MachineSubscriptionController.class);

    @Autowired
    private AbstractDAO<User> subscriptionDAO;

    @Autowired
    AbstractDAO<User> userDAO;

    @RequestMapping(value = "/subscribed", method = RequestMethod.GET)
    public @ResponseBody UserBean getUser(@RequestParam("email") String email, HttpServletResponse response) {
        User user = userDAO.getByEmail(email);
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new UserBean(user);
    }

    @RequestMapping(value = "/subscribe", method = RequestMethod.POST)
    public ResponseEntity<String> subscribeMachine(@RequestParam("userEmail") String userEmail,
                                                   @RequestParam("userToken") String userToken,
                                                   @RequestParam("machineId") int machineId,
                                                   @RequestParam("remark") String remark,
                                                   HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        if (Strings.isNullOrEmpty(userToken)) {
            return new ResponseEntity<>("Bad Token", HttpStatus.BAD_REQUEST);
        }
        try {
            TokenHandler tokenHandler = new TokenHandler(subscriptionDAO);
            tokenHandler.parseUserFromToken(userToken);

            SubscribedMachineBean machineEntry = new SubscribedMachineBean(userEmail, machineId, remark);
            User user = userDAO.getByEmail(machineEntry.getUserEmail());
            SubscribedMachine machine = new SubscribedMachine();
            machine.setUser(user);
            machine.setMachine_id(machineEntry.getMachineId());
            machine.setRemarks(machineEntry.getRemarks());
            user.getSubscribedMachines().add(machine);
            userDAO.save(user);
        } catch (IOException e) {
            logger.error("Token validation failed: {}", e);
            return new ResponseEntity<>("Invalid Token or Server Error", HttpStatus.UNAUTHORIZED);
        } catch (DataAccessException e) {
            logger.error("Database Error: {}", e);
            return new ResponseEntity<>("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
