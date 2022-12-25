package com.mb.software.ecampus.controllers;

import com.mb.software.ecampus.api.controllers.AcademicDepartmentsController;
import com.mb.software.ecampus.core.business.abstracts.AcademicDepartmentService;

import static org.mockito.Mockito.*;

import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.entities.concretes.AcademicDepartment;
import com.mb.software.ecampus.entities.concretes.AcademicUnit;
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
import java.util.List;

@ExtendWith(SpringExtension.class)
public class AcademicDepartmentsControllerTest {

    @Mock
    private AcademicDepartmentService service;

    @InjectMocks
    private AcademicDepartmentsController academicDepartmentsController;

    static AcademicDepartment academicDepartment = new AcademicDepartment(0,"seher","içerik",new AcademicUnit(0,"Enginnering Faculty",AcademicType.FACULTY));
    static AcademicDepartment academicDepartment1 = new AcademicDepartment(1,"seher","içerik",new AcademicUnit(0,"Enginnering Faculty",AcademicType.FACULTY));


    @Test
    public void testGetAllMethodIsWorkingProperly() {
        when(service.getAll()).thenReturn(prepareDataList());
        ResponseEntity<DataResult<List<AcademicDepartment>>> response = academicDepartmentsController.getAll();
        assertEquals(response.getBody().getData(), prepareDataList().getData());
    }

    @Test
    public void testAddMethodIsWorkingProperly() throws Exception {
        when(service.add(any())).thenReturn(prepareCreatedData());
        ResponseEntity<DataResult<AcademicDepartment>> response = academicDepartmentsController.add(any());
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody().getData(), prepareCreatedData().getData());
    }

    @Test
    public void testUpdateIsWorkingProperly() {
        when(service.update(any())).thenReturn(prepareUpdateData());
        ResponseEntity<DataResult<AcademicDepartment>> response = academicDepartmentsController.update(academicUnitId, any());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getData(), prepareUpdateData().getData());
    }

    @Test
    public void testDeleteIsWorkingProperly() throws Exception {
        when(service.delete(academicUnitId)).thenReturn(new SuccessResult());
        ResponseEntity<Result> response = academicDepartmentsController.delete(academicUnitId);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetByIdIsWorkingProperly() {
        when(service.getById(academicUnitId)).thenReturn(prepareSingleData());
        ResponseEntity<DataResult<AcademicDepartment>> response = academicDepartmentsController.getById(academicUnitId);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getData(), prepareSingleData().getData());
    }

    private static DataResult<AcademicDepartment> prepareUpdateData() {
        return new SuccessDataResult<>(
                academicDepartment
                );
    }

    private static DataResult<AcademicDepartment> prepareCreatedData() {
        return new SuccessDataResult<>(
                academicDepartment);
    }

    private static DataResult<AcademicDepartment> prepareSingleData() {
        return new SuccessDataResult<>(
                academicDepartment);
    }

    private DataResult<List<AcademicDepartment>> prepareDataList() {
        List<AcademicDepartment> academicDepartments = new ArrayList<>();
        academicDepartments.add(academicDepartment);
        academicDepartments.add(academicDepartment1);
        return new SuccessDataResult<>(academicDepartments);
    }

    private static final int academicUnitId = 1;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

}
