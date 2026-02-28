package com.example.spring_autowire_demo;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 101;
    private String name = "Java Programming";
    private String dateOfCompletion = "10-02-2026";

    @Override
    public String toString() {
        return "Certification [id=" + id + ", name=" + name + "]";
    }
}