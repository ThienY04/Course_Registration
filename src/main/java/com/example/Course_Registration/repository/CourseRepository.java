package com.example.Course_Registration.repository;

import com.example.Course_Registration.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Page<Course> findByNameContaining(String keyword, Pageable pageable);
}