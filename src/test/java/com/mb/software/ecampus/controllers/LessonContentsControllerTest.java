package com.mb.software.ecampus.controllers;

import com.mb.software.ecampus.api.controllers.AcademicUnitsController;
import com.mb.software.ecampus.api.controllers.LessonContentsController;
import com.mb.software.ecampus.business.abstracts.AcademicUnitService;
import com.mb.software.ecampus.business.abstracts.LessonContentService;
import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.entities.concretes.*;
import com.mb.software.ecampus.entities.concretes.enums.AcademicRate;
import com.mb.software.ecampus.entities.concretes.enums.AcademicType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.Before;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
public class LessonContentsControllerTest {

    @Mock
    private LessonContentService lessonContentService;

    @InjectMocks
    private LessonContentsController lessonContentsController;

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
    static LessonContent lessonContent = new LessonContent(1,lesson,"Data Sciens","",1);
    static LessonContent lessonContent1 = new LessonContent(0,lesson,"Data Sciens","",1);

    @Test
    public void testGetAllMethodIsWorkingProperly() {
        when(lessonContentService.getAll()).thenReturn(prepareDataList());
        ResponseEntity<DataResult<List<LessonContent>>> response = lessonContentsController.getAll();
        assertEquals(response.getBody().getData(), prepareDataList().getData());
    }
    @Test
    public void testAddMethodWorkingProperly() throws Exception {
        when(lessonContentService.add(any())).thenReturn(prepareCreatedData());
        ResponseEntity<DataResult<LessonContent>> response = lessonContentsController.add(any());
        assertEquals(response.getStatusCode(),HttpStatus.CREATED);
        assertEquals(response.getBody().getData() ,prepareCreatedData().getData());
    }

    @Test
    public void testUpdateIsWorkingProperly() {
        when(lessonContentService.update(any())).thenReturn(prepareUpdateData());
        ResponseEntity<DataResult<LessonContent>> response = lessonContentsController.update(lessonContentId, any());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getData(), prepareUpdateData().getData());
    }


    @Test
    public void testDeleteIsWorkingProperly() throws Exception {
        when(lessonContentService.delete(lessonContentId)).thenReturn(new SuccessResult());
        ResponseEntity<Result> response = lessonContentsController.delete(lessonContentId);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetByIdIsWorkingProperly() {
        when(lessonContentService.getById(lessonContentId)).thenReturn(prepareSingleData());
        ResponseEntity<DataResult<LessonContent>> response = lessonContentsController.getById(lessonContentId);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getData(), prepareSingleData().getData());
    }
    private static DataResult<LessonContent> prepareSingleData(){
        return new SuccessDataResult<>(
                lessonContent);

    }


    private static DataResult<LessonContent> prepareUpdateData(){
        return new SuccessDataResult<>(
                lessonContent);

    }

    private static DataResult<LessonContent> prepareCreatedData() {
        return new SuccessDataResult<>(
                lessonContent);
    }
    private DataResult<List<LessonContent>> prepareDataList(){
        List<LessonContent> lesson_Contents = new ArrayList<>();
        lesson_Contents.add(lessonContent);
        lesson_Contents.add(lessonContent1);
        return new SuccessDataResult<>(lesson_Contents);
    }

    private static final int lessonContentId = 1;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
}
