package com.example.student_library_management_system.service;

import com.example.student_library_management_system.dto.AuthorRequestDto;
import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.student_library_management_system.converters.AuthorConverter.convertAuthorRequestDtoToAuthor;

@Service // it contains business logic
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public String createAuthor(AuthorRequestDto authorRequestDto){
        Author author = new Author();
        author = convertAuthorRequestDtoToAuthor(authorRequestDto);
        authorRepository.save(author);
        return "Author saved successfully";
    }
}
