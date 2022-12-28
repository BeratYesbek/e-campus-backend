package com.mb.software.ecampus.controllers;
import com.mb.software.ecampus.api.controllers.ChosenLessonsController;

import static org.mockito.Mockito.*;

import com.mb.software.ecampus.business.abstracts.ChosenLessonService;
import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.entities.concretes.*;
import com.mb.software.ecampus.entities.concretes.enums.AcademicRate;
import com.mb.software.ecampus.entities.concretes.enums.AcademicType;
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
public class ChoosedLessonControllerTest {


    @Mock
    private ChosenLessonService choosedLessonService;

    static Lesson lesson = new Lesson(1,
            new AcademicPersonal(1, AcademicRate.PROFESSOR,
                    new Employee(1,
                            new EmployeeDepartment(1,"Engineering"),
                            new AcademicUnit(1,"Computer Engineering",AcademicType.FACULTY),
                            new User(1,"Sehmus","test@gmail.com",
                                    null,
                                    null,
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
    static ChosenLesson choosedLesson = new ChosenLesson(1,lesson,student,null,"");
    static ChosenLesson choosedLesson1 = new ChosenLesson(0,lesson,student, null,"");

    @InjectMocks
    private ChosenLessonsController choosedLessonsController;

    @Test
    public void testGetAllMethodIsWorkingProperly() {
        when(choosedLessonService.getAll()).thenReturn(prepareDataList());
        ResponseEntity<DataResult<List<ChosenLesson>>> response = choosedLessonsController.getAll();
        assertEquals(response.getBody().getData(), prepareDataList().getData());
    }
    @Test
    public void testAddMethodIsWorkingProperly() throws Exception{
        when(choosedLessonService.add(any())).thenReturn(prepareCreatedData());
        ResponseEntity<DataResult<ChosenLesson>> response = choosedLessonsController.add(any());
        assertEquals(response.getStatusCode(),HttpStatus.CREATED);
        assertEquals(response.getBody().getData(),prepareCreatedData().getData());
    }

    @Test
    public void testUpdateIsWorkingProperly(){
        when(choosedLessonService.update(any())).thenReturn(prepareUpdateData());
        ResponseEntity<DataResult<ChosenLesson>> response = choosedLessonsController.update(choosedLessonId,any());
        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(response.getBody().getData(),prepareUpdateData().getData());
    }
    @Test
    public void testDeleteIsWorkingProperly() throws Exception {
        when(choosedLessonService.delete(choosedLessonId)).thenReturn(new SuccessResult());
        ResponseEntity<Result> response = choosedLessonsController.delete(choosedLessonId);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    public void testGetByIdIsWorkingProperly() {
        when(choosedLessonService.getById(choosedLessonId)).thenReturn(prepareSingleData());
        ResponseEntity<DataResult<ChosenLesson>> response = choosedLessonsController.getById(choosedLessonId);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getData(), prepareSingleData().getData());
    }

    private static DataResult <ChosenLesson>prepareSingleData(){
        return new SuccessDataResult<>(
                choosedLesson
        );
    }

    private static DataResult<ChosenLesson>prepareUpdateData(){
        return new SuccessDataResult<>(choosedLesson);
    }

    private static DataResult<ChosenLesson>prepareCreatedData(){
        return new SuccessDataResult<>(
                choosedLesson
        );
    }
    private DataResult<List<ChosenLesson>>prepareDataList(){
        List<ChosenLesson>choosed_Lessons = new ArrayList<>();
        choosed_Lessons.add(choosedLesson);
        choosed_Lessons.add(choosedLesson1);
        return new SuccessDataResult<>(choosed_Lessons);
    }

    private static final int choosedLessonId = 2;
}
