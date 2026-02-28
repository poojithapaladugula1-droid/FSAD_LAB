package com.example.spring_autowire_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id = 1;
    private String name = "Poojitha";
    private String gender = "Female";

    @Autowired
    private Certification certification;

    @Override
    public String toString() {
        return "Student id=" + id +
               "\nName=" + name +
               "\nGender=" + gender +
               "\n" + certification;
    }
}