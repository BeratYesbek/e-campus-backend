package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.business.abstracts.AcademicUnitService;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.entities.concretes.AcademicUnit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/academic_units")
public class AcademicUnitsController {
    private final AcademicUnitService academicUnitService;

    public AcademicUnitsController(AcademicUnitService academicUnitService) {
        this.academicUnitService = academicUnitService;
    }

    @PostMapping
    private ResponseEntity<DataResult<AcademicUnit>> add(@RequestBody AcademicUnit academicUnit) throws Exception {
        return new ResponseEntity<>(academicUnitService.add(academicUnit), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<DataResult<AcademicUnit>> update(@PathVariable int id, @RequestBody AcademicUnit academicUnit) {
        return new ResponseEntity<>(academicUnitService.update(academicUnit), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Result> delete(@PathVariable int id) {
        return new ResponseEntity<>(academicUnitService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<DataResult<AcademicUnit>> getById(@PathVariable int id) {
        return new ResponseEntity<>(academicUnitService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<DataResult<List<AcademicUnit>>> getAll() {
        return new ResponseEntity<>(academicUnitService.getAll(), HttpStatus.OK);
    }
}
