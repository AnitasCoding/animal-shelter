package de.animalshelter.controller;


import de.animalshelter.dao.DataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DataController {

    @Autowired
    DataDao dataDao;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    @ModelAttribute("allData")
    public ModelAndView index(Model model) {
        return manageDataMV("/", model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/animals-placement/")
    public ModelAndView animalPlacement(Model model) {
        return manageDataMV("/animals-placement/", model);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/lost-found/")
    public ModelAndView lostFound(Model model) {
        return manageDataMV("/lost-found/", model);
    }

    private ModelAndView manageDataMV(String request, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        List allData = null;
        String webContent = "";
        try {
            switch (request) {
                case "/":
                    allData = dataDao.selectNews();
                    webContent = "news";
                    break;
                case "/lost-found/":
                    allData = dataDao.selectLostFoundAnimals();
                    webContent = "lost-found";
                    break;
                case "/animals-placement/":
                    allData = dataDao.selectAnimalsOrdered();
                    webContent = "animals-placement";
                    break;
            }
            model.addAttribute("webContent", webContent);
            if (!(allData == null)) {
                modelAndView.addObject(allData);
                model.addAttribute("allData", allData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
