package com.cpms.application.subscription.controllers;

import com.cpms.application.subscription.bean.SubscribedMachineBean;
import com.cpms.application.subscription.bean.UserBean;
import com.cpms.application.subscription.dao.AbstractDAO;
import com.cpms.application.subscription.model.SubscribedMachine;
import com.cpms.application.subscription.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Rakib on 11/29/2015.
 */
@Controller
@RequestMapping(value = "/machines")
public class MachineSubscriptionController {

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
                                           HttpServletResponse response, ModelMap model) {
        // FIXME: validate token before subscribing machines
        // validate by TokenHandler
        SubscribedMachineBean machineEntry = new SubscribedMachineBean(userEmail, machineId, remark);
        User user = userDAO.getByEmail(machineEntry.getUserEmail());
        SubscribedMachine machine = new SubscribedMachine();
        machine.setUser(user);
        machine.setMachine_id(machineEntry.getMachineId());
        machine.setRemarks(machineEntry.getRemarks());
        user.getSubscribedMachines().add(machine);
        userDAO.save(user);
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}
