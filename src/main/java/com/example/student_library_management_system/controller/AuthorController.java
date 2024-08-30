package com.example.student_library_management_system.controller;

import com.example.student_library_management_system.dto.AuthorRequestDto;
import com.example.student_library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/create")
    public String createAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        return authorService.createAuthor(authorRequestDto);
    }
}
