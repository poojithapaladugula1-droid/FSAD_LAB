package com.example.StudentAPI.controller;

import com.example.StudentAPI.model.Student;
import com.example.StudentAPI.exception.StudentNotFoundException;
import com.example.StudentAPI.exception.InvalidInputException;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Vaishnavi", "Computer Science"));
        students.add(new Student(2, "Poojitha", "Mathematics"));
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        int studentId;

        try {
            studentId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Student ID must be a number!");
        }

        return students.stream()
                .filter(s -> s.getId() == studentId)
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + studentId + " not found!"));
    }
}