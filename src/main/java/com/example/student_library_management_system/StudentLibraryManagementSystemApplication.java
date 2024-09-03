package com.example.student_library_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
public class StudentLibraryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentLibraryManagementSystemApplication.class, args);
	}

}
