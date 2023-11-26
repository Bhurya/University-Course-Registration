package com.universitycourseregistration.controller;

import com.universitycourseregistration.dto.EnrollmentInputClass;
import com.universitycourseregistration.model.Enrollment;
import com.universitycourseregistration.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/enroll/{studentId}/{courseCode}")
    public ResponseEntity<Enrollment> enrollStudentInCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseCode
    ) {
        Enrollment enrollment = enrollmentService.enrollStudentInCourse(studentId, courseCode);
        return ResponseEntity.ok(enrollment);
    }

    @DeleteMapping("/delete/{enrollmentId}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable Long enrollmentId) {
        enrollmentService.deleteEnrollment(enrollmentId);
        return ResponseEntity.ok("Enrollment deleted successfully.");
    }


    @PostMapping("/update/{enrollmentId}")
    public ResponseEntity<Enrollment> enrollStudentInCourse(
            @PathVariable Long enrollmentId,
            @RequestBody EnrollmentInputClass enrollmentInputClass
            ) {
        Enrollment enrollment = enrollmentService.updateEnrollmentDetails(enrollmentId, enrollmentInputClass);
        return ResponseEntity.ok(enrollment);
    }

    @GetMapping("/getCourseForStudent/{studentId}")
    public ResponseEntity<List<Enrollment>> getCourseForStudent(@PathVariable Long studentId){
        List<Enrollment> enrollmentList = enrollmentService.getCoursesForStudent(studentId);
        return ResponseEntity
                .ok(enrollmentList);
    }

}
