package com.example.Course_Registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Course_Registration.model.Enrollment;
import com.example.Course_Registration.model.Student;
import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudent(Student student);
}