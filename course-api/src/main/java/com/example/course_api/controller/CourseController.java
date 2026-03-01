package com.example.course_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.course_api.entity.Course;
import com.example.course_api.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    // Add Course
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        Course c = service.addCourse(course);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    // Get All Courses
    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    // Get Course by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {
        Optional<Course> course = service.getCourse(id);

        if(course.isPresent()) {
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
        }
    }

    // Update Course
    @PutMapping
    public ResponseEntity<?> updateCourse(@RequestBody Course course) {
        Course updated = service.updateCourse(course);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // Delete Course
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        service.deleteCourse(id);
        return new ResponseEntity<>("Course deleted", HttpStatus.OK);
    }

    // Search by Title
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchCourse(@PathVariable String title) {
        return new ResponseEntity<>(service.searchByTitle(title), HttpStatus.OK);
    }
}