package com.example.course_api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.course_api.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByTitle(String title);
}