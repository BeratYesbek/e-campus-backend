package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.business.abstracts.AcademicUnitService;
import com.mb.software.ecampus.core.utilities.data.DataResult;
import com.mb.software.ecampus.entities.concretes.AcademicUnit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/academic_units")
public class AcademicUnitsController {
    private final AcademicUnitService academicUnitService;

    public AcademicUnitsController(AcademicUnitService academicUnitService) {
        this.academicUnitService = academicUnitService;
    }

    @PostMapping
    private ResponseEntity<DataResult<AcademicUnit>>  add(@RequestBody AcademicUnit academicUnit) {
        return new ResponseEntity<>(academicUnitService.add(academicUnit),HttpStatus.OK);
    }
}
