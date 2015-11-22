package com.cpms.servicerepository.controllers;

import com.cpms.servicerepository.bean.MachineServicesBean;
import com.cpms.servicerepository.bean.MachineServicesFactory;
import com.cpms.servicerepository.dao.MachineServicesDAO;
import com.cpms.servicerepository.model.MachineServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Rakib on 11/21/2015.
 */
@Controller
@RequestMapping(value = "/edit")
public class ServiceEditController {
    @Autowired
    private MachineServicesDAO machineServicesDAO;

    @RequestMapping(value = "/{machineId}", method = RequestMethod.GET)
    public String getServiceEditView(@PathVariable int machineId, ModelMap model, HttpServletRequest request) {
        MachineServices machineServices = machineServicesDAO.getMachineServicesById(machineId);
        MachineServicesBean machineServicesBean = MachineServicesFactory.getMachineServicesBean(machineServices);
        model.addAttribute("machineServices", machineServicesBean);
        model.addAttribute("baseUrl", Utils.getURLWithContextPath(request));
        return "edit_service";
    }

    @RequestMapping(value = "/{machineId}", method = RequestMethod.POST)
    public String saveEditedService(@ModelAttribute("machineServices")MachineServicesBean machineServicesBean,
                                    ModelMap model, HttpServletRequest request) {
        MachineServices machineServices = MachineServicesFactory.getMachineServices(machineServicesBean);
        machineServicesDAO.save(machineServices);
        model.addAttribute("baseUrl", Utils.getURLWithContextPath(request));
        return "success";
    }
}
