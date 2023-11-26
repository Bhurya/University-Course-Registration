package com.universitycourseregistration.service;

import com.universitycourseregistration.dto.StudentInputClass;
import com.universitycourseregistration.model.Course;
import com.universitycourseregistration.model.Student;

import java.util.List;

public interface StudentService {

    Student registerStudent(StudentInputClass student);

    //List<Course> getCoursesForStudent(Long studentId);

    Student getStudentById(Long studentId);
}

