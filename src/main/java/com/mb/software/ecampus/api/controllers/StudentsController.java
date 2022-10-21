package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.business.abstracts.StudentService;
import com.mb.software.ecampus.core.utilities.Result;
import com.mb.software.ecampus.core.utilities.data.DataResult;
import com.mb.software.ecampus.entities.concretes.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

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

    @PutMapping("/{id}")
    private ResponseEntity<DataResult<Student>> update(@PathVariable int id, @RequestBody Student student) {
        DataResult result = studentService.update(student);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Result> delete(@PathVariable int id) {
        Result result = studentService.delete(id);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    private ResponseEntity<DataResult<Student>> getById(@PathVariable int id) {
        DataResult result = studentService.getById(id);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    private ResponseEntity<DataResult<List<Student>>> getAll() {
        DataResult result = studentService.getAll();
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }


}
