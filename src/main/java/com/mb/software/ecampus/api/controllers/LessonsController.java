package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.core.business.abstracts.LessonService;

import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.entities.concretes.Lesson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lessons")
public class LessonsController {

    private final LessonService lessonService;

    public LessonsController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping
    public ResponseEntity<DataResult<Lesson>> add(@RequestBody Lesson lesson) throws Exception {
        return new ResponseEntity<>(lessonService.add(lesson), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<Lesson>> update(@PathVariable int id,@RequestBody Lesson lesson){
        return new ResponseEntity<>(lessonService.update(lesson), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable int id) throws Exception {
        return new ResponseEntity<>(lessonService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<Lesson>> getById(@PathVariable int id){
        return new ResponseEntity<>(lessonService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DataResult<List<Lesson>>> getAll(){
        return new ResponseEntity<>(lessonService.getAll(), HttpStatus.OK);
    }


}
