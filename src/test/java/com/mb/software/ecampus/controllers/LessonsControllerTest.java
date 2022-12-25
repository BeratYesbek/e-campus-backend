package com.mb.software.ecampus.controllers;

import com.mb.software.ecampus.api.controllers.LessonsController;

import static org.mockito.Mockito.*;

import com.mb.software.ecampus.core.business.abstracts.LessonService;
import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.entities.concretes.*;
import com.mb.software.ecampus.entities.concretes.enums.AcademicRate;
import com.mb.software.ecampus.entities.concretes.enums.AcademicType;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class LessonsControllerTest {
    @Mock
    private LessonService service;
    static Lesson lesson = new Lesson(0,new AcademicPersonal(),new AcademicDepartment(),"math","bl01","description",3,5,1,true);
    static Lesson lesson1 = new Lesson(0,new AcademicPersonal(),new AcademicDepartment(),"math","bl01","description",3,5,1,true);


    @InjectMocks
    private LessonsController lessonsController;

    @Test
    public void testGetAllMethodIsWorkingProperly(){
        when(service.getAll()).thenReturn(prepareDataList());
        ResponseEntity<DataResult<List<Lesson>>> response = lessonsController.getAll();
        assertEquals(response.getBody().getData(),prepareDataList().getData());
    }

    @Test
    public void testAddMethodIsWorkingProperly() throws Exception{
        when(service.add(any())).thenReturn(prepareCreatedData());
        ResponseEntity<DataResult<Lesson>> response = lessonsController.add(any());
        assertEquals(response.getStatusCode(),HttpStatus.CREATED);
        assertEquals(response.getBody().getData(),prepareCreatedData().getData());
    }

    @Test
    public void testUpdateIsWorkingProperly(){
        when(service.update(any())).thenReturn(prepareUpdateData());
        ResponseEntity<DataResult<Lesson>> response = lessonsController.update(lessonId,any());
        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(response.getBody().getData(),prepareUpdateData().getData());
    }

    @Test
    public void testDeleteIsWorkingProperly() throws Exception {
        when(service.delete(lessonId)).thenReturn(new SuccessResult());
        ResponseEntity<Result> response = lessonsController.delete(lessonId);
        assertEquals(response.getStatusCode(),HttpStatus.OK);
    }

    @Test
    public void testGetByIdIsWorkingProperly(){
        when(service.getById(lessonId)).thenReturn(prepareSingleData());
        ResponseEntity<DataResult<Lesson>> response =lessonsController.getById(lessonId);
        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(response.getBody().getData(),prepareSingleData().getData());
    }

    private static DataResult<Lesson> prepareSingleData() {
        return new SuccessDataResult<>(
                lesson
        );
    }


    private static DataResult<Lesson> prepareUpdateData() {
        return new SuccessDataResult<>(
                lesson
        );
    }

    private static DataResult<Lesson> prepareCreatedData() {
        return new SuccessDataResult<>(
                lesson
        );
    }

    private static DataResult<List<Lesson>> prepareDataList() {
        List<Lesson> lessons = new ArrayList<>();
        lessons.add(lesson);
        lessons.add(lesson1);
        return new SuccessDataResult<>(lessons);
    }
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    private static final int lessonId = 1;
}
