package com.cpms.servicerepository;

import com.cpms.servicerepository.bean.PersonBean;
import com.cpms.servicerepository.dao.PersonDAO;
import com.cpms.servicerepository.model.Person;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BaseController {

    @Autowired
    private PersonDAO personDAO;

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
        List<Person> list = personDAO.list();
        List<PersonBean> beans = new ArrayList<>();
        for (Person person : list) {
            beans.add(new PersonBean(person));
            logger.debug("[Person] : {}", person.toString());
        }
        model.addAttribute("persons", beans);
        return new ModelAndView("test");
    }

}