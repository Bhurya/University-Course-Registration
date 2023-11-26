package com.universitycourseregistration.controller;

import com.universitycourseregistration.dto.StudentInputClass;
import com.universitycourseregistration.model.Course;
import com.universitycourseregistration.model.Student;
import com.universitycourseregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody StudentInputClass student) {
        Student registeredStudent = studentService.registerStudent(student);
        return ResponseEntity.ok(registeredStudent);
    }


}

