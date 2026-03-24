package com.example.Course_Registration.service;

import com.example.Course_Registration.model.Student; 
import com.example.Course_Registration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepository.findByUsername(username);

        if (student == null) {
            throw new UsernameNotFoundException("Không tìm thấy sinh viên!");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(student.getUsername())
                .password(student.getPassword())
                .roles("USER") 
                .build();
    }
}
