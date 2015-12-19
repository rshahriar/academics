package com.cpms.servicerepository.controllers;

import com.cpms.servicerepository.bean.MachineBean;
import com.cpms.servicerepository.bean.MachineServicesBean;
import com.cpms.servicerepository.dao.MachineServicesDAO;
import com.cpms.servicerepository.model.MachineServices;
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
public class ServiceRepositoryController {

    @Autowired
    private MachineServicesDAO machineServicesDAO;

    private static final String VIEW_INDEX = "index";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ServiceRepositoryController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        List<MachineServices> list = machineServicesDAO.list();
        List<MachineServicesBean> beans = new ArrayList<>();
        for (MachineServices machineServices : list) {
            beans.add(new MachineServicesBean(machineServices));
            logger.debug("[Machine Services Entry] : {}", machineServices.toString());
        }
        model.addAttribute("machineServicesList", beans);
        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/indexView", method = RequestMethod.GET)
    public String getIndexView(ModelMap model) {
        return welcome(model);
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public @ResponseBody List<MachineServicesBean> getAllMachineServicesInJSON(HttpServletResponse response) {
        List<MachineServices> list = machineServicesDAO.list();
        List<MachineServicesBean> beans = new ArrayList<>();
        for (MachineServices machineServices : list) {
            beans.add(new MachineServicesBean(machineServices));
            logger.debug("[Machine Services Entry] : {}", machineServices.toString());
        }
        response.addHeader("Access-Control-Allow-Origin", "*");
        return beans;
    }

    @RequestMapping(value = "/machines", method = RequestMethod.GET)
    public @ResponseBody List<MachineBean> getPublishedMachines(HttpServletResponse response) {
        List<MachineServices> list = machineServicesDAO.list();
        List<MachineBean> machineBeans = new ArrayList<>();
        for (MachineServices machineServices : list) {
            MachineBean machineBean = new MachineBean(machineServices);
            machineBeans.add(machineBean);
            logger.debug("[Machine Id: {} ]", machineServices.getMachine_id());
        }
        response.addHeader("Access-Control-Allow-Origin", "*");
        return machineBeans;
    }

    @RequestMapping(value = "/services/{machineId}", method = RequestMethod.GET)
    public @ResponseBody MachineServicesBean getMachineServicesInJSON(@PathVariable int machineId, HttpServletResponse response) {
        MachineServices machineServices = machineServicesDAO.getMachineServicesById(machineId);
        response.addHeader("Access-Control-Allow-Origin", "*");
        return new MachineServicesBean(machineServices);
    }
}