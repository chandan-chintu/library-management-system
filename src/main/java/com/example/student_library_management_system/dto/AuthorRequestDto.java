package com.example.student_library_management_system.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AuthorRequestDto {

    private String name;

    private int age;

    private String country;

    private double rating;
}
