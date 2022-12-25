package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.business.abstracts.LessonContentService;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.entities.concretes.LessonContent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lesson_contents")
public class LessonContentsController {

    private final LessonContentService lessonContentService;

    public LessonContentsController(LessonContentService lessonContentService) {
        this.lessonContentService = lessonContentService;
    }

    @PostMapping
    public ResponseEntity<DataResult<LessonContent>> add(@RequestBody LessonContent lessonContent) throws Exception{
        DataResult result = lessonContentService.add(lessonContent);
        if (result.isSuccess()){
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<LessonContent>> update(@PathVariable int id, @RequestBody LessonContent lessonContent){
        DataResult result = lessonContentService.update(lessonContent);
        if (result.isSuccess()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable int id) throws Exception {
        Result result = lessonContentService.delete(id);
        if (result.isSuccess()){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<LessonContent>> getById(@PathVariable int id){
        DataResult result = lessonContentService.getById(id);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<DataResult<List<LessonContent>>> getAll(){
        DataResult result = lessonContentService.getAll();
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

}
