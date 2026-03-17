package com.example.Course_Registration.service;

import com.example.Course_Registration.model.Student; // Import class Entity Student
import com.example.Course_Registration.repository.StudentRepository; // Import Repository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository; // Giả sử bạn đã có Repository này

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Tìm student trong DB
        Student student = studentRepository.findByUsername(username);

        if (student == null) {
            throw new UsernameNotFoundException("Không tìm thấy sinh viên!");
        }

        // Trả về đối tượng User của Spring Security
        return org.springframework.security.core.userdetails.User
                .withUsername(student.getUsername())
                .password(student.getPassword())
                .roles("USER") // Hoặc lấy từ bảng student_role của bạn
                .build();
    }
}