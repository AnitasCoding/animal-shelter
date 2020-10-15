package de.animalshelter.controller;


import de.animalshelter.dao.DataDao;
import de.animalshelter.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

    @RequestMapping(method = RequestMethod.GET, value = "/employee/")
    public ModelAndView employee(Model model) {
        return manageDataMV("/employee/", model);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addAnimal")
    public String addAnimal(Model model, @ModelAttribute("animal") Animal animal) {
        File file = new File("targetFile.jpg");
        try {
            file.createNewFile();
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(animal.getMultipartFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        animal.setDisplayImage(file);
        dataDao.insertAnimal(animal);
        file.delete();
        return "redirect:/employee/";
    }

    @ModelAttribute("animal")
    public Animal populateAnimal() {
        return new Animal();
    }

    private ModelAndView manageDataMV(String request, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        List allData = null;
        String webContent = "";
        try {
            switch (request) {
                case "/":
                    modelAndView.setViewName("index.html");
                    allData = dataDao.selectNews();
                    webContent = "news";
                    break;
                case "/lost-found/":
                    modelAndView.setViewName("index.html");
                    allData = dataDao.selectLostFoundAnimals();
                    webContent = "lost-found";
                    break;
                case "/animals-placement/":
                    modelAndView.setViewName("index.html");
                    allData = dataDao.selectAnimalsOrdered();
                    webContent = "animals-placement";
                    break;
                case "/employee/":
                    modelAndView.setViewName("employee.html");
                    model.addAttribute("animal");
                    break;
            }
            if (!webContent.isBlank()) {
                model.addAttribute("webContent", webContent);
                if (!(allData == null)) {
                    modelAndView.addObject(allData);
                    model.addAttribute("allData", allData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
