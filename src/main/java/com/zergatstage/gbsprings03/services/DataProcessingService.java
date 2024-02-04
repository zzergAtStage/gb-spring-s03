package com.zergatstage.gbsprings03.services;

import com.zergatstage.gbsprings03.model.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    //private List<User> usersList;

    public List<User> getSortedUserList(List<User> users){
        Collections.sort(users);
        return users;
    }

    /**
     * Filter users by Age above
     * @param users List of users
     * @param filterAboveAge The threshold, where users will be filtered
     * @return filtered list of users
     */
    public List<User> getFilteregUserList(List<User> users, int filterAboveAge){
        return users.stream().filter(u -> u.getAge() > filterAboveAge).collect(Collectors.toList());
    }

    public double getAverageAge(List<User> users){
        return users.stream().collect(Collectors.averagingDouble(User::getAge));
    }
}
