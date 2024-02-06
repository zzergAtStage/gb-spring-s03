package com.zergatstage.gbsprings03.controllers;

import com.zergatstage.gbsprings03.model.User;
import com.zergatstage.gbsprings03.services.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    private RegistrationService service;
    @RequestMapping("/home")
    public String homePage(Model model){
        log.info("/home point started");
        model.addAttribute("message","Some stupid message from java server!");
        model.addAttribute("messageBody", "The Someshit - is the ancient tree in Russia");
        return "home.html";
    }

    @RequestMapping("/")
    public String index(){
        return "index.html";
    }
    @GetMapping("/users/list")
    public String listUsers(Model model){
        log.info("/users/list point started");
        List<User> users = service.getDataProcessingService().getRepository().findAll();
        model.addAttribute("users", users);
        log.info("Retrieved all users: {}", users);
        return "add-user.html";
    }
    @RequestMapping("/users/add")
    public String addUser(User user, Model model){
        log.info("/users/add started");
        if (user != null) {
            service.processRegistration(user);
        }
        model.addAttribute("users", service.getDataProcessingService().getRepository().findAll());
        return "list-user.html";
    }


}
