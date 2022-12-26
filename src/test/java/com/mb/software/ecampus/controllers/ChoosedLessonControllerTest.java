package com.mb.software.ecampus.controllers;
import com.mb.software.ecampus.api.controllers.ChoosedLessonsController;
import com.mb.software.ecampus.business.abstracts.AcademicDepartmentService;

import static org.mockito.Mockito.*;

import com.mb.software.ecampus.business.abstracts.ChoosedLessonService;
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
public class ChoosedLessonControllerTest {


    @Mock
    private ChoosedLessonService choosedLessonService;

    static Lesson lesson = new Lesson(1,
            new AcademicPersonal(1, AcademicRate.PROFESSOR,
                    new Employee(1,
                            new EmployeeDepartment(1,"Engineering"),
                            new AcademicUnit(1,"Computer Engineering",AcademicType.FACULTY),
                            new User(1,"Sehmus","test@gmail.com",
                                    new Date(any()),
                                    new Date(any()),
                                    "123456","+900","Female","","",""),null),5,"65","65","65","65"),
            new AcademicDepartment(1,"Computer Engineerinh","",
                    new AcademicUnit(1,"Computer Engineering",AcademicType.FACULTY)),"STP","BL301","",5,5,2022,true);
    static Student student = new Student(1,
            new AcademicDepartment(),3,"191","lisans",3,
            new Date(2022,23,12),
            new Date(2022,23,12),false,
            new User(1,"seherst","seher@gmail.com",
                    new Date(2000,12,01),
                    new Date(2022,12,23),"123456","0538","female","ankara","Ankara","Türkiye"));
    static ChoosedLesson choosedLesson = new ChoosedLesson(1,lesson,student,new Date(any()),"");

    @InjectMocks
    private ChoosedLessonsController choosedLessonsController;

    @Test
    public void testAddMethodIsWorkingProperly() throws Exception{
        when(choosedLessonService.add(any())).thenReturn(prepareCreatedData());
        ResponseEntity<DataResult<ChoosedLesson>> response = choosedLessonsController.add(any());
        assertEquals(response.getStatusCode(),HttpStatus.CREATED);
        assertEquals(response.getBody().getData(),prepareCreatedData().getData());
    }

    @Test
    public void testUpdateIsWorkingProperly(){
        when(choosedLessonService.update(any())).thenReturn(prepareUpdateData());
        ResponseEntity<DataResult<ChoosedLesson>> response = choosedLessonsController.update(choosedLessonId,any());
        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(response.getBody().getData(),prepareUpdateData().getData());
    }
    @Test
    public void testDeleteIsWorkingProperly() throws Exception {
        when(choosedLessonService.delete(choosedLessonId)).thenReturn(new SuccessResult());
        ResponseEntity<Result> response = choosedLessonsController.delete(choosedLessonId);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    private static DataResult<ChoosedLesson>prepareUpdateData(){
        return new SuccessDataResult<>(choosedLesson);
    }

    private static DataResult<ChoosedLesson>prepareCreatedData(){
        return new SuccessDataResult<>(
                choosedLesson
        );
    }

    private static final int choosedLessonId = 2;
}
