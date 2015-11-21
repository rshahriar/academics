package com.cpms.servicerepository;

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
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BaseController {

    @Autowired
    private MachineServicesDAO machineServicesDAO;

    private int counter = 0;
    private static final String VIEW_INDEX = "index";
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        model.addAttribute("message", "Welcome");
        model.addAttribute("counter", ++counter);
        logger.debug("[welcome] counter : {}", counter);

        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;
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
    public @ResponseBody List<MachineServicesBean> getMachineServicesInJSON() {
        List<MachineServices> list = machineServicesDAO.list();
        List<MachineServicesBean> beans = new ArrayList<>();
        for (MachineServices machineServices : list) {
            beans.add(new MachineServicesBean(machineServices));
            logger.debug("[Machine Services Entry] : {}", machineServices.toString());
        }
        return beans;
    }
}