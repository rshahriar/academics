package com.cpms.servicerepository;

import com.cpms.servicerepository.bean.MachineServicesBean;
import com.cpms.servicerepository.bean.MachineServicesFactory;
import com.cpms.servicerepository.dao.MachineServicesDAO;
import com.cpms.servicerepository.model.MachineServices;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewService(@ModelAttribute("userForm") MachineServicesBean machineServicesBean,
                                     ModelMap model) {

        MachineServices machineServices = MachineServicesFactory.getMachineServices(machineServicesBean);
        machineServicesDAO.save(machineServices);
        return "success";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getRegisterNewServiceView(Map<String, Object> model) {
        MachineServicesBean machineServices = new MachineServicesBean();
        model.put("machineServices", machineServices);
        return new ModelAndView("new_service");
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ModelAndView welcomeName(@PathVariable String name, ModelMap model) {
        List<MachineServices> list = machineServicesDAO.list();
        List<MachineServicesBean> beans = new ArrayList<>();
        for (MachineServices machineServices : list) {
            beans.add(new MachineServicesBean(machineServices));
            logger.debug("[Machine Services Entry] : {}", machineServices.toString());
        }
        model.addAttribute("persons", beans);
        return new ModelAndView("test");
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public @ResponseBody List<MachineServicesBean> getAllMachineServicesInJSON() {
        List<MachineServices> list = machineServicesDAO.list();
        List<MachineServicesBean> beans = new ArrayList<>();
        for (MachineServices machineServices : list) {
            beans.add(new MachineServicesBean(machineServices));
            logger.debug("[Machine Services Entry] : {}", machineServices.toString());
        }
        return beans;
    }

    @RequestMapping(value = "/services/{machineId}", method = RequestMethod.GET)
    public @ResponseBody MachineServicesBean getMachineServicesInJSON(@PathVariable int machineId) {
        MachineServices machineServices = machineServicesDAO.getMachineServicesById(machineId);
        return new MachineServicesBean(machineServices);
    }
}