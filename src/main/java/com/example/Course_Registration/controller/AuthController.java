package com.example.Course_Registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // Trả về file register.html
    }

    @Autowired
    private PasswordEncoder passwordEncoder; // Tiêm Encoder vào đây

    @PostMapping("/register/save")
    public String registration(@RequestParam("username") String username,
            @RequestParam("password") String password) {

        // Mã hóa mật khẩu trước khi lưu
        String encodedPassword = passwordEncoder.encode(password);

        // Lưu encodedPassword này vào Database thay vì password thuần
        System.out.println("Mật khẩu sau khi mã hóa để lưu DB: " + encodedPassword);

        return "redirect:/login";
    }
}