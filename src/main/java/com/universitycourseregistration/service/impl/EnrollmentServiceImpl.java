package com.universitycourseregistration.service.impl;

import com.universitycourseregistration.dto.EnrollmentInputClass;
import com.universitycourseregistration.exception.GenericExceptions;
import com.universitycourseregistration.model.Course;
import com.universitycourseregistration.model.Enrollment;
import com.universitycourseregistration.model.Student;
import com.universitycourseregistration.repository.EnrollmentRepository;
import com.universitycourseregistration.service.CourseService;
import com.universitycourseregistration.service.EnrollmentService;
import com.universitycourseregistration.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    private final CourseService courseService;

    private StudentService studentService;

    @Autowired
    public void setStudentService(@Lazy StudentService studentService) {
        this.studentService = studentService;
    }


    @Autowired
    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository, CourseService courseService) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseService = courseService;
    }

    @Override
    @Transactional
    public Enrollment enrollStudentInCourse(Long studentId, Long courseCode) {
        Student student = studentService.getStudentById(studentId);
        Course course = courseService.getCourseByCourseId(courseCode);

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }

    @Override
    @Transactional
    public Enrollment updateEnrollmentDetails(Long enrollmentId, EnrollmentInputClass enrollmentInputClass) {
        Student student = studentService.getStudentById(enrollmentInputClass.getStudentId());
        Course course = courseService.getCourseByCourseId(enrollmentInputClass.getCourseCode());

        Optional<Enrollment> enrollment = enrollmentRepository.findById(enrollmentId);
        if (enrollment.isEmpty()) {
            throw new GenericExceptions("Enrollment not found");
        }

        enrollment.get().setStudent(student);
        if (enrollment.get().getCourse().equals(course)) {
            throw new GenericExceptions("Course is already assigned to the student");
        }
        enrollment.get().setCourse(course);

        return enrollmentRepository.save(enrollment.get());
    }


    @Override
    public void deleteEnrollment(Long enrollmentId) {
        Optional<Enrollment> enrollment = enrollmentRepository.findById(enrollmentId);
        if (enrollment.isEmpty()) {
            throw new GenericExceptions("Enrollment not found");
        }
        enrollmentRepository.delete(enrollment.get());
    }

    @Override
    public List<Enrollment> getCoursesForStudent(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

}

