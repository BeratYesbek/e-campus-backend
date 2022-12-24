package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.core.business.abstracts.AcademicPersonalService;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.entities.concretes.AcademicPersonal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/academic_personals")
public class AcademicPersonalsController {
    public final AcademicPersonalService academicPersonalService;

    public AcademicPersonalsController(AcademicPersonalService academicPersonalService) {
        this.academicPersonalService = academicPersonalService;
    }

    @PostMapping
    public ResponseEntity<DataResult<AcademicPersonal>> add(@RequestBody AcademicPersonal academicPersonal) throws Exception {
        return new ResponseEntity<>(academicPersonalService.add(academicPersonal), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<AcademicPersonal>> update(@PathVariable int id, @RequestBody AcademicPersonal academicPersonal){
        return new ResponseEntity<>(academicPersonalService.update(academicPersonal), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable int id){
        return new ResponseEntity<>(academicPersonalService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<AcademicPersonal>> getById(@PathVariable int id){
        return new ResponseEntity<>(academicPersonalService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DataResult<List<AcademicPersonal>>> getAll(){
        return new ResponseEntity<>(academicPersonalService.getAll(), HttpStatus.OK);
    }
}
