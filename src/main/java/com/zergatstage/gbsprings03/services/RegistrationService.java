package com.zergatstage.gbsprings03.services;

import com.zergatstage.gbsprings03.model.User;
import com.zergatstage.gbsprings03.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Objects;

@Service
public class RegistrationService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private DataProcessingService getDataProcessingService;

    public DataProcessingService getDataProcessingService(){
        return getDataProcessingService;
    }
    public User processRegistration(Model model){
        String name = Objects.requireNonNull(model.getAttribute("name")).toString();
        int age = Integer.getInteger(String.valueOf(model.getAttribute("age")));
        String email = Objects.requireNonNull(model.getAttribute("email")).toString();
        User newUser = userService.createUser(name, age, email);
        userRepository.save(newUser);
        return newUser;
    }


}
