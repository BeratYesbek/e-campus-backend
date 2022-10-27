package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.business.abstracts.AcademicDepartmentService;
import static org.mockito.Mockito.*;

import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.entities.concretes.AcademicDepartment;
import com.mb.software.ecampus.entities.concretes.AcademicUnit;
import com.mb.software.ecampus.entities.concretes.enums.AcademicType;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.*;
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

    @Test
    public void testGetAllMethodIsWorkingProperly() {
        when(service.getAll()).thenReturn(prepareDataList());
        ResponseEntity<DataResult<List<AcademicDepartment>>> response = academicDepartmentsController.getAll();
        assertEquals(response.getBody().getData(),prepareDataList().getData());
    }

    private DataResult<List<AcademicDepartment>> prepareDataList() {
        List<AcademicDepartment> academicDepartments = new ArrayList<>();
        academicDepartments.add(new AcademicDepartment(1,"Software Engineering",new AcademicUnit(1,"Engineering Faculty", AcademicType.FACULTY)));
        academicDepartments.add(new AcademicDepartment(2,"Computer Engineering",new AcademicUnit(2,"Engineering Faculty",AcademicType.FACULTY)));
        return new SuccessDataResult<>(academicDepartments);
    }

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
    }

}
