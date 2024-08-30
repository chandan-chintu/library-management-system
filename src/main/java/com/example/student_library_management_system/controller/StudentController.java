package com.example.student_library_management_system.controller;

import com.example.student_library_management_system.dto.StudentRequestDto;
import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.addStudent(studentRequestDto);
    }

    @GetMapping("/findAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
