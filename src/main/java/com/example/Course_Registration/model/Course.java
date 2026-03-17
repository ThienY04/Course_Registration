package com.example.Course_Registration.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    private int credits;
    private String lecturer;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}