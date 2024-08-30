package com.example.student_library_management_system.dto;

import com.example.student_library_management_system.enums.Genre;
import lombok.Data;

@Data
public class BookRequestDto {

    private String name;

    private int pages;

    private Genre genre;

    private boolean issuedToStudent;

    private int cardId;

    private int authorId;
}
