package com.universitycourseregistration.service.impl;

import com.universitycourseregistration.dto.StudentInputClass;
import com.universitycourseregistration.exception.GenericExceptions;
import com.universitycourseregistration.model.Student;
import com.universitycourseregistration.repository.StudentRepository;
import com.universitycourseregistration.service.EnrollmentService;
import com.universitycourseregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private EnrollmentService enrollmentService;

    @Autowired
    public void setEnrollmentService(@Lazy EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student registerStudent(StudentInputClass student) {
        Student student1 = Student
                .builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .build();
        return studentRepository.save(student1);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new GenericExceptions("Student not found"));
    }
}
