package com.mb.software.ecampus.api.controllers;

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
import java.util.List;

@ExtendWith(SpringExtension.class)
public class StudentsControllerTest {

    @Mock
    private StudentService service;

    @InjectMocks
    private StudentsController studentController;

    @Test
    public void testGetAllMethodIsWorkingProperly(){
        when(service.getAll()).thenReturn(prepareDataList());
        ResponseEntity<DataResult<List<Student>>> response = studentController.getAll();
        assertEquals(response.getBody().getData(), prepareDataList().getData());
    }



    @Test
    public void testUpdateIsWorkingProperly() throws Exception {
        when(service.update(any())).thenReturn(prepareUpdateData());
        ResponseEntity<DataResult<Student>> response = studentController.add(any());
        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(response.getBody().getData(),prepareUpdateData().getData());
    }

    private DataResult<Student> prepareUpdateData() {
        return null;
    }

    private DataResult<List<Student>> prepareDataList() {
        return null;
    }
    private static DataResult<Student> prepareSingleData(){
        return new SuccessDataResult<>(
                new Student(
                        1,
                        new AcademicDepartment(1,"Computer Engineering",
                        new AcademicUnit(1,"Engineer Faculty",AcademicType.FACULTY)),
                        3,
                        new User())
        );
    }
}


