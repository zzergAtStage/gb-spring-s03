package com.zergatstage.gbsprings03.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public NotificationService(){
        System.out.println("Notification service created!?");
    }

    public void callNotify(String userId){
        System.out.println("User " + userId + " created");
    }

}
