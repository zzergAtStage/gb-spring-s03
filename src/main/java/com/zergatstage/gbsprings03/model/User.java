package com.zergatstage.gbsprings03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User implements Comparable<User>{
    private String name;
    private int age;
    private String email;


    @Override
    public int compareTo(User o) {
        return this.getAge()-o.getAge();
    }
}
