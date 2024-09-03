package com.example.student_library_management_system.controller;

import com.example.student_library_management_system.dto.StudentRequestDto;
import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Student;
import com.example.student_library_management_system.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    /*
    Loggers - displays the messages in console which helps in track the application flow
    levels of loggers
    info - displays the information
    debug - used while debugging application debug mode
    error - used to display error messages
    warn - used to warning messages
     */
    // declaring loggers
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        logger.info("addStudent API has started");
        try {
            logger.info("addStudent API has ended");
            return studentService.addStudent(studentRequestDto);
        }catch (Exception e){
            logger.error("addStudent API has encountered with exception");
            return "Exception occured while saving : "+e.getMessage();
        }
    }

    @GetMapping("/findAll")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/find/{studentid}")
    public ResponseEntity<?> getStudentById(@PathVariable("studentid") int studentId){
        logger.info("getStudentById API has started");
        try {
            logger.info("getStudentById API has ended");
            return ResponseEntity.ok().body(studentService.getStudentById(studentId));
        }catch (Exception e){
            logger.error("getStudentById API has encountered exception");
            return ResponseEntity.internalServerError().body("Exception occured : "+e.getMessage());
        }
    }

    @PutMapping("/update/{studentid}")
    public String updateStudent(@RequestBody StudentRequestDto studentRequestDto,@PathVariable("studentid") int studentId){
        return studentService.updateStudent(studentRequestDto,studentId);
    }

    @DeleteMapping("/delete/{studentid}")
    public String deleteStudentById(@PathVariable("studentid") int studentId){
        return studentService.deleteStudentById(studentId);
    }

    @GetMapping("/findByEmail")
    public Student getStudentByEmail(@RequestParam("email") String email){
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/findByGrade")
    public List<Student> getStudentsByGrade(@RequestParam("grade") String grade){
        return studentService.getStudentByGrade(grade);
    }

    @GetMapping("/findStudentPages")
    public List<Student> getStudentsBasedOnPagination(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize, @RequestParam("sortParameter") String sortParameter){
        return studentService.getStudentsBasedOnPagination(pageNo, pageSize, sortParameter);
    }

    @GetMapping("/getCount")
    public String getStudentCount(){
        return studentService.getStudentCount();
    }
}
