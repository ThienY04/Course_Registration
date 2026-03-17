package com.example.Course_Registration.service;

import java.util.List;
import com.example.Course_Registration.model.*;
import com.example.Course_Registration.repository.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepo;

    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    public Category getById(Long id) {
        return categoryRepo.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}