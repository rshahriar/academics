package com.cpms.servicerepository.controllers;

import com.cpms.servicerepository.bean.MachineBean;
import com.cpms.servicerepository.bean.MachineServicesBean;
import com.cpms.servicerepository.bean.ServiceBean;
import com.cpms.servicerepository.dao.AbstractDAO;
import com.cpms.servicerepository.model.Machine;
import com.cpms.servicerepository.model.Service;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/machines")
public class ServiceRepositoryController {

    @Autowired
    private AbstractDAO abstractDAO;

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ServiceRepositoryController.class);

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<MachineBean> getMachines(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        List<Machine> list = abstractDAO.list();
        List<MachineBean> beans = new ArrayList<>();
        for (Machine machine : list) {
            beans.add(new MachineBean(machine));
            logger.debug("[Machine Services Entry] : {}", machine.toString());
        }
        return beans;
    }

    @RequestMapping(value = "/{machineId}/services", method = RequestMethod.GET)
    public @ResponseBody MachineServicesBean getAllMachineServicesInJSON(@PathVariable("machineId") Integer machineId,
                                                                               HttpServletResponse response) {
        Machine machine = (Machine) abstractDAO.getMachineById(machineId);
        MachineServicesBean machineServicesBean = new MachineServicesBean(machine);
        response.addHeader("Access-Control-Allow-Origin", "*");
        return machineServicesBean;
    }

    @RequestMapping(value = "/{machineId}/services/{serviceId}")
    public @ResponseBody ServiceBean getService(@PathVariable("machineId") Integer machineId,
                                                @PathVariable("serviceId") Integer serviceId,
                                                HttpServletResponse response) {
        Machine machine = (Machine) abstractDAO.getMachineById(machineId);
        ServiceBean serviceBean = new ServiceBean();
        for (Service service : machine.getServices()) {
            if (serviceId.equals(service.getService_id())) {
                serviceBean = new ServiceBean(service);
                break;
            }
        }
        response.addHeader("Access-Control-Allow-Origin", "*");
        return serviceBean;
    }

    @RequestMapping(value = "/{machineId}", method = RequestMethod.GET)
    public @ResponseBody MachineServicesBean getMachineServicesInJSON(@PathVariable("machineId") Integer machineId, HttpServletResponse response) {
        Machine machine = (Machine) abstractDAO.getMachineById(machineId);
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new MachineServicesBean(machine);
    }
}