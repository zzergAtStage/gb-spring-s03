package com.zergatstage.gbsprings03.services;

import com.zergatstage.gbsprings03.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class UserService {
    @Autowired
    private NotificationService notificationService;

    public User createUser(String name, int age, String email){
        User newUser = new User(name, age, email);
        notificationService.callNotify();
        return newUser;
    }

}
