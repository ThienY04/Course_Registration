package com.example.Course_Registration.controller;

import com.example.Course_Registration.model.Course;
import com.example.Course_Registration.repository.CourseRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final CourseRepository courseRepo;

    @GetMapping({ "/", "/home" })
    public String home(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            Model model) {

        Pageable pageable = PageRequest.of(page, 5);

        Page<Course> coursePage;

        if (keyword.isEmpty()) {
            coursePage = courseRepo.findAll(pageable);
        } else {
            coursePage = courseRepo.findByNameContaining(keyword, pageable);
        }

        model.addAttribute("courses", coursePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", coursePage.getTotalPages());
        model.addAttribute("keyword", keyword);

        return "home";
    }
}