package com.universitycourseregistration.service;

import com.universitycourseregistration.dto.CourseInputClass;
import com.universitycourseregistration.model.Course;

import java.util.List;

public interface CourseService {
    Course addCourse(CourseInputClass course);

    List<Course> getCourseList();

    Course getCourseByCourseId(Long courseId);
}

