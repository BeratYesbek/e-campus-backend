package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.business.abstracts.StudentService;
import com.mb.software.ecampus.core.utilities.data.DataResult;
import com.mb.software.ecampus.entities.concretes.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    private final StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    private ResponseEntity<DataResult<Student>> add(Student student) {
        DataResult result = studentService.add(student);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
