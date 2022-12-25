package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.business.abstracts.ChoosedLessonService;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.entities.concretes.ChoosedLesson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/choosed_lessons")
public class ChoosedLessonsController {

    private final ChoosedLessonService choosedLessonService;

    public ChoosedLessonsController(ChoosedLessonService choosedLessonService) {
        this.choosedLessonService = choosedLessonService;
    }

    @PostMapping
    public ResponseEntity<DataResult<ChoosedLesson>> add(@RequestBody ChoosedLesson choosedLesson) throws Exception{
        DataResult result = choosedLessonService.add(choosedLesson);
        if (result.isSuccess()){
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<ChoosedLesson>> update(@PathVariable int id,@RequestBody ChoosedLesson choosedLesson){
        DataResult result = choosedLessonService.update(choosedLesson);
        if (result.isSuccess()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable int id){
        Result result = choosedLessonService.delete(id);
        if (result.isSuccess()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<ChoosedLesson>> getById(@PathVariable int id){
        DataResult result = choosedLessonService.getById(id);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<DataResult<List<ChoosedLesson>>> getAll(){
        DataResult result = choosedLessonService.getAll();
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
