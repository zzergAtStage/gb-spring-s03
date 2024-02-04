package com.zergatstage.gbsprings03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparable<User>{
    private UUID id;
    private String name;
    private int age;
    private String email;


    @Override
    public int compareTo(User o) {
        return this.getAge()-o.getAge();
    }
}
