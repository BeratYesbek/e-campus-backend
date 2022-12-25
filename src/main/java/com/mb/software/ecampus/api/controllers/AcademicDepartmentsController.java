package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.core.business.abstracts.AcademicDepartmentService;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.entities.concretes.AcademicDepartment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/academic_departments")
public class AcademicDepartmentsController extends BaseController {

    private final AcademicDepartmentService academicDepartmentService;

    public AcademicDepartmentsController(AcademicDepartmentService academicDepartmentService) {
            this.academicDepartmentService = academicDepartmentService;
    }

    @PostMapping
    public ResponseEntity<DataResult<AcademicDepartment>> add(@RequestBody AcademicDepartment academicDepartment) throws Exception {
        return new ResponseEntity<>(academicDepartmentService.add(academicDepartment), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<AcademicDepartment>> update(@PathVariable int id, @RequestBody AcademicDepartment academicDepartment) {
        return new ResponseEntity<>(academicDepartmentService.update(academicDepartment), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable int id) throws Exception {
        return new ResponseEntity<>(academicDepartmentService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<AcademicDepartment>> getById(@PathVariable int id) {
        return new ResponseEntity<>(academicDepartmentService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DataResult<List<AcademicDepartment>>> getAll() {
        return new ResponseEntity<>(academicDepartmentService.getAll(), HttpStatus.OK);
    }

}
