package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.business.abstracts.EmployeeDepartmentService;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.entities.concretes.EmployeeDepartment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/employeeDepartments")
@RestController
public class EmployeeDepartmentsController {

    private final EmployeeDepartmentService employeeDepartmentService;

    public EmployeeDepartmentsController(EmployeeDepartmentService employeeDepartmentService) {
        this.employeeDepartmentService = employeeDepartmentService;
    }

    @PostMapping
    public ResponseEntity<DataResult<EmployeeDepartment>> add(@RequestBody EmployeeDepartment employeeDepartment) throws Exception {
        DataResult result = employeeDepartmentService.add(employeeDepartment);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<DataResult<EmployeeDepartment>> getAll() throws Exception {
        DataResult result = employeeDepartmentService.getAll();
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

}