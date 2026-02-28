package com.example.SpringDI_4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.AppConfig;

public class App {
    public static void main(String[] args) {

        // Load the Java-based configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the Student bean
        Student student = context.getBean(Student.class);

        // Display values
        student.display();
    }
}