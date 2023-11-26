package com.universitycourseregistration.repository;

import com.universitycourseregistration.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}