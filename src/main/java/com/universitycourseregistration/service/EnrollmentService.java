package com.universitycourseregistration.service;

import com.universitycourseregistration.dto.EnrollmentInputClass;
import com.universitycourseregistration.model.Course;
import com.universitycourseregistration.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    Enrollment enrollStudentInCourse(Long studentId, Long courseCode);
    Enrollment updateEnrollmentDetails(Long enrollmentId, EnrollmentInputClass enrollmentInputClass);
    void deleteEnrollment(Long enrollmentId);
    List<Enrollment> getCoursesForStudent(Long studentId);
    // Add other relevant methods
}

