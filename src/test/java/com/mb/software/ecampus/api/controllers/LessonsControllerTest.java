package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.business.abstracts.AcademicDepartmentService;

import static org.mockito.Mockito.*;

import com.mb.software.ecampus.business.abstracts.LessonService;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.entities.concretes.AcademicDepartment;
import com.mb.software.ecampus.entities.concretes.AcademicUnit;
import com.mb.software.ecampus.entities.concretes.Lesson;
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
        assertEquals(response.getBody().getData(),prepareUpdateData());
    }


    private DataResult<Lesson> prepareUpdateData() {
        return null;
    }

    private DataResult<Lesson> prepareCreatedData() {
        return null;
    }

    private DataResult<List<Lesson>> prepareDataList() {
        return null;
    }

    private static final int lessonId = 1;
}
