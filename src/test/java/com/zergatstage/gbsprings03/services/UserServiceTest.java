package com.zergatstage.gbsprings03.services;

import com.zergatstage.gbsprings03.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private String name;
    private int age;
    private String email;
    private User user;
    @BeforeEach
    void setUp() {
        name = "John";
        age = 31;
        email = "noAge_29@aol.com";
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createUser() {
        user = new User( name,age,email);
        assertNotNull(user);
        assertEquals(age,user.getAge());
        assertEquals(name,user.getName());
        assertEquals(email,user.getEmail());

    }
}