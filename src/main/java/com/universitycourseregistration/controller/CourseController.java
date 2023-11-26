package com.universitycourseregistration.controller;

import com.universitycourseregistration.dto.CourseInputClass;
import com.universitycourseregistration.model.Course;
import com.universitycourseregistration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestBody CourseInputClass course) {
        Course addedCourse = courseService.addCourse(course);
        return ResponseEntity
                .ok(addedCourse);
    }

    @PostMapping("/getAllCourse")
    public ResponseEntity<List<Course>> getAllCourse() {
        List<Course> addedCourse = courseService.getCourseList();
        return ResponseEntity
                .ok(addedCourse);
    }




}
