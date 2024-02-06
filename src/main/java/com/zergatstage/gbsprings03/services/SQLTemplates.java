package com.zergatstage.gbsprings03.services;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myapp.sql")
public class SQLTemplates {

    private String findAllUsers;
    private String findUserById;
    private String insertUser;
    private String updateUser;
    private String deleteUser;

    // Getters and setters for each SQL template

    public String getFindAllUsers() {
        return findAllUsers;
    }

    public void setFindAllUsers(String findAllUsers) {
        this.findAllUsers = findAllUsers;
    }

    public String getFindUserById() {
        return findUserById;
    }

    public void setFindUserById(String findUserById) {
        this.findUserById = findUserById;
    }

    public String getInsertUser() {
        return insertUser;
    }

    public void setInsertUser(String insertUser) {
        this.insertUser = insertUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser;
    }
}
