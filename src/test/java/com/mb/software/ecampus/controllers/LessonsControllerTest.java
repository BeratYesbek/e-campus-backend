package com.mb.software.ecampus.controllers;

import com.mb.software.ecampus.api.controllers.LessonsController;
import com.mb.software.ecampus.business.abstracts.AcademicDepartmentService;

import static org.mockito.Mockito.*;

import com.mb.software.ecampus.business.abstracts.LessonService;
import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.entities.concretes.*;
import com.mb.software.ecampus.entities.concretes.enums.AcademicRate;
import com.mb.software.ecampus.entities.concretes.enums.AcademicType;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class LessonsControllerTest {
    @Mock
    private LessonService service;

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
                new Lesson(1,new AcademicPersonal(1,AcademicRate.DOC,new Employee(1,new EmployeeDepartment(1,"Engineering"),new AcademicUnit(1,"Computer Engineering",AcademicType.FACULTY),new User(1,"seherst","seher@gmail.com",new Date(2000,12,01),new Date(2022,12,01,15,45),"123456"))),new AcademicDepartment(1,"Engineering",new AcademicUnit(1,"Computer Engineering",AcademicType.FACULTY)),"Data structure"
                )
        );
    }


    private static DataResult<Lesson> prepareUpdateData() {
        return new SuccessDataResult<>(
                new Lesson(1,new AcademicPersonal(1,AcademicRate.DOC,new Employee(1,new EmployeeDepartment(1,"Engineering"),new AcademicUnit(1,"Computer Engineering",AcademicType.FACULTY),new User(1,"seherst","seher@gmail.com",new Date(2000,12,01),new Date(2022,12,01,15,45),"123456"))),new AcademicDepartment(1,"Engineering",new AcademicUnit(1,"Computer Engineering",AcademicType.FACULTY)),"Data structure"
                )
        );
    }

    private static DataResult<Lesson> prepareCreatedData() {
        return new SuccessDataResult<>(
                new Lesson(1,new AcademicPersonal(1,AcademicRate.DOC,new Employee(1,new EmployeeDepartment(1,"Engineering"),new AcademicUnit(1,"Computer Engineering",AcademicType.FACULTY),new User(1,"seherst","seher@gmail.com",new Date(2000,12,01),new Date(2022,12,01,15,45),"123456"))),new AcademicDepartment(1,"Engineering",new AcademicUnit(1,"Computer Engineering",AcademicType.FACULTY)),"Data structure"
                )
        );
    }

    private static DataResult<List<Lesson>> prepareDataList() {
        List<Lesson> lessons = new ArrayList<>();
        lessons.add(new Lesson(1,new AcademicPersonal(1,AcademicRate.DOC,new Employee(1,new EmployeeDepartment(1,"Engineering"),new AcademicUnit(1,"Computer Engineering",AcademicType.FACULTY),new User(1,"seherst","seher@gmail.com",new Date(2000,12,01),new Date(2022,12,01,15,45),"123456"))),new AcademicDepartment(1,"Engineering",new AcademicUnit(1,"Computer Engineering",AcademicType.FACULTY)),"Data structure"
        ));
        lessons.add(new Lesson(2,new AcademicPersonal(1,AcademicRate.DOC,new Employee(1,new EmployeeDepartment(1,"Engineering"),new AcademicUnit(1,"Computer Engineering",AcademicType.FACULTY),new User(1,"seherst","seher@gmail.com",new Date(2000,12,01),new Date(2022,12,01,15,45),"123456"))),new AcademicDepartment(1,"Engineering",new AcademicUnit(1,"Computer Engineering",AcademicType.FACULTY)),"Data structure"
        ));
        return new SuccessDataResult<>(lessons);
    }
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    private static final int lessonId = 1;
}
