package com.cpms.servicerepository.controllers;

import com.cpms.servicerepository.bean.MachineServicesBean;
import com.cpms.servicerepository.bean.MachineServicesFactory;
import com.cpms.servicerepository.dao.MachineServicesDAO;
import com.cpms.servicerepository.model.MachineServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Rakib on 11/21/2015.
 */
@Controller
@RequestMapping(value = "/register")
public class ServiceRegisterController {

    @Autowired
    private MachineServicesDAO machineServicesDAO;

    @RequestMapping(method = RequestMethod.POST)
    public String registerNewService(@ModelAttribute("userForm") MachineServicesBean machineServicesBean,
                                     ModelMap model, HttpServletRequest request) {
        MachineServices machineServices = MachineServicesFactory.getMachineServices(machineServicesBean);
        machineServicesDAO.save(machineServices);
        model.addAttribute("baseUrl", Utils.getURLWithContextPath(request));
        return "success";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getRegisterNewServiceView(Map<String, Object> model) {
        MachineServicesBean machineServices = new MachineServicesBean();
        model.put("machineServices", machineServices);
        return new ModelAndView("new_service");
    }

}
