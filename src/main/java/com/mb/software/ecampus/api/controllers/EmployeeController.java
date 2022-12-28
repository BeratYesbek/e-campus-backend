package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.business.abstracts.EmployeeService;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.entities.concretes.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/employee")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<DataResult<Employee>> add(@RequestBody Employee employee) throws Exception {
        DataResult result = employeeService.add(employee);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<DataResult<Employee>> update(@RequestBody Employee employee) throws Exception {
        DataResult result = employeeService.update(employee);
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<DataResult<Employee>> getAll() throws Exception {
        DataResult result = employeeService.getAll();
        if (result.isSuccess()) {
            return ResponseEntity.ok(result);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
