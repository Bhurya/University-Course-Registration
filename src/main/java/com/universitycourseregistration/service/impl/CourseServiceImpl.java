package com.universitycourseregistration.service.impl;

import com.universitycourseregistration.dto.CourseInputClass;
import com.universitycourseregistration.exception.GenericExceptions;
import com.universitycourseregistration.model.Course;
import com.universitycourseregistration.repository.CourseRepository;
import com.universitycourseregistration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course addCourse(CourseInputClass course) {
        Course saveCourse = Course
                .builder()
                .courseName(course.getCourseName())
                .instructor(course.getInstructor())
                .build();
        return courseRepository.save(saveCourse);
    }

    @Override
    public List<Course> getCourseList() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseByCourseId(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new GenericExceptions("Course not found"));
    }



}

