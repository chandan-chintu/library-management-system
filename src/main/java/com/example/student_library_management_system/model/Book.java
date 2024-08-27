package com.example.student_library_management_system.model;

import com.example.student_library_management_system.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "pages", nullable = false)
    private int pages;

    @Column(name = "genre", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Column(name = "issued_to_student", nullable = false)
    private boolean issuedToStudent;
}
