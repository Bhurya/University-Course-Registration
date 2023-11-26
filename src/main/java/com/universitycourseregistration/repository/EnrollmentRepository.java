package com.universitycourseregistration.repository;

import com.universitycourseregistration.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    @Query("select e from Enrollment e where e.student.studentId = ?1")
    List<Enrollment> findByStudentId(Long studentId);




}