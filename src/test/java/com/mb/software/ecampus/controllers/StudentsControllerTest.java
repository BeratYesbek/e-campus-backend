package com.mb.software.ecampus.controllers;

import com.mb.software.ecampus.api.controllers.StudentsController;

import static org.mockito.Mockito.*;

import com.mb.software.ecampus.core.business.abstracts.StudentService;
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
public class StudentsControllerTest {

    @Mock
    private StudentService service;
    static Student student = new Student(1,new AcademicDepartment(),3,"191","lisans",3,new Date(2022,23,12),new Date(2022,23,12),false,new User(1,"seherst","seher@gmail.com",new Date(2000,12,01),new Date(2022,12,23),"123456","0538","female","ankara","Ankara","Türkiye"));
    static Student student1 = new Student(2,new AcademicDepartment(),3,"191","lisans",3,new Date(2022,23,12),new Date(2022,23,12),false,new User(1,"seherst","seher@gmail.com",new Date(2000,12,01),new Date(2022,12,23),"123456","0538","female","ankara","Ankara","Türkiye"));


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
                student
        );
    }

    private static DataResult<Student> prepareCreatedData(){
        return new SuccessDataResult<>(
                student
        );
    }

    private DataResult<List<Student>> prepareDataList() {
        List<Student> students = new ArrayList<>();
        students.add( student);
        students.add( student);
        return new SuccessDataResult<>(students);
    }

    private static DataResult<Student> prepareSingleData(){
        return new SuccessDataResult<>(
                student
        );
    }

    private static final int studentId =1;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
}


