package com.example.Course_Registration.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.example.Course_Registration.repository.EnrollmentRepository;
import java.time.LocalDateTime;
import com.example.Course_Registration.model.*;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepo;

    public void enroll(Student student, Course course) {
        Enrollment e = new Enrollment();
        e.setStudent(student);
        e.setCourse(course);
        e.setEnrollDate(LocalDateTime.now());

        enrollmentRepo.save(e);
    }
}
