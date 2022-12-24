package com.mb.software.ecampus.controllers;

import com.mb.software.ecampus.api.controllers.StudentsController;
import com.mb.software.ecampus.business.abstracts.AcademicDepartmentService;

import static org.mockito.Mockito.*;

import com.mb.software.ecampus.business.abstracts.StudentService;
import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.entities.concretes.AcademicDepartment;
import com.mb.software.ecampus.entities.concretes.AcademicUnit;
import com.mb.software.ecampus.entities.concretes.Student;
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
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class StudentsControllerTest {

    @Mock
    private StudentService service;

    @InjectMocks
    private StudentsController studentController;

    @Test
    public void testAddMethodIsWorkingProperly() throws Exception{
        when(service.add(any())).thenReturn(prepareCreatedData());
        ResponseEntity<DataResult<Student>> response = studentController.add(any());
        assertEquals(response.getStatusCode(),HttpStatus.CREATED);
        assertEquals(response.getBody().getData(),prepareCreatedData().getData());
    }

    @Test
    public void testGetAllMethodIsWorkingProperly(){
        when(service.getAll()).thenReturn(prepareDataList());
        ResponseEntity<DataResult<List<Student>>> response = studentController.getAll();
        assertEquals(response.getBody().getData(), prepareDataList().getData());
    }

    @Test
    public void testUpdateIsWorkingProperly() throws Exception {
        when(service.update(any())).thenReturn(prepareUpdateData());
        ResponseEntity<DataResult<Student>> response = studentController.update(studentId,any());
        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(response.getBody().getData(),prepareUpdateData().getData());
    }

    @Test
    public void testDeleteIsWorkingProperly() throws Exception {
        when(service.delete(studentId)).thenReturn(new SuccessResult());
        ResponseEntity<Result> response = studentController.delete(studentId);
        assertEquals(response.getStatusCode(),HttpStatus.OK);
    }

    @Test
    public void testGetByIdIsWorkingProperly(){
        when(service.getById(studentId)).thenReturn(prepareSingleData());
        ResponseEntity<DataResult<Student>> response =studentController.getById(studentId);
        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(response.getBody().getData(), prepareSingleData().getData());
    }

    private DataResult<Student> prepareUpdateData() {

        return new SuccessDataResult<>(
                new Student(
                        1,
                        new AcademicDepartment(
                                1,
                                "Computer Engineering",
                                new AcademicUnit(1,"Engineer Faculty",AcademicType.FACULTY)), 3, new User(1,"seherst","seher@gmail.com",new Date(2000,01,12),new Date(2000,01,12),"123456") )
        );
    }

    private static DataResult<Student> prepareCreatedData(){
        return new SuccessDataResult<>(
                new Student(1,
                        new AcademicDepartment(1,"Computer Engineering",
                                new AcademicUnit(1,"Engineer Faculty",AcademicType.FACULTY)),
                        3,
                        new User(1,"seherst","seher@gmail.com",new Date(2000,01,12),new Date(2000,01,12),"123456"))
        );
    }

    private DataResult<List<Student>> prepareDataList() {
        List<Student> students = new ArrayList<>();
        students.add( new Student(
                2,
                new AcademicDepartment(
                        1,
                        "Software Engineering",
                        new AcademicUnit(1,"Engineer Faculty",AcademicType.FACULTY)), 3, new User(2,"shmsacr","sehmus@gmail.com",new Date(2000,01,12),new Date(2000,12,01),"123456")));
        students.add( new Student(
                1,
                new AcademicDepartment(
                        1,
                        "Computer Engineering",
                        new AcademicUnit(1,"Engineer Faculty",AcademicType.FACULTY)), 3, new User(1,"seherst","seher@gmail.com",new Date(2000,01,12),new Date(2000,01,12),"123456")));
        return new SuccessDataResult<>(students);
    }

    private static DataResult<Student> prepareSingleData(){
        return new SuccessDataResult<>(
                new Student(
                        1,
                        new AcademicDepartment(1,"Computer Engineering",
                        new AcademicUnit(1,"Engineer Faculty",AcademicType.FACULTY)),
                        3,
                        new User(1,"seherst","seher@gmail.com",new Date(2000,01,12),new Date(2000,01,12),"123456"))
        );
    }

    private static final int studentId =1;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
}


