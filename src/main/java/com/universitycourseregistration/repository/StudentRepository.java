package com.universitycourseregistration.repository;

import com.universitycourseregistration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}