package com.mb.software.ecampus.api.controllers;
import com.mb.software.ecampus.business.abstracts.AcademicDepartmentService;

import static org.mockito.Mockito.*;

import com.mb.software.ecampus.business.abstracts.AcademicPersonalService;
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

import javax.print.Doc;
import javax.xml.crypto.Data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class AcademicPersonalsControllerTest {

    @Mock
    private AcademicPersonalService service;

    @InjectMocks
    private AcademicPersonalsController academicPersonalsController;

    @Test
    public  void testGetAllMethodUsWorkingProperly(){
        when(service.getAll()).thenReturn(prepareDataList());
        ResponseEntity<DataResult<List<AcademicPersonal>>> response = academicPersonalsController.getAll();
        assertEquals(response.getBody().getData(),prepareDataList().getData());

    }

    @Test
    public void testAddMethodIsWorkingProperly() throws Exception {
        when(service.add(any())).thenReturn(prepareCreatedData());
        ResponseEntity<DataResult<AcademicPersonal>> response =academicPersonalsController.add(any());
        assertEquals(response.getStatusCode(),HttpStatus.CREATED);
        assertEquals(response.getBody().getData(),prepareCreatedData().getData());
    }

    @Test
    public void testUpdateIsWorkingProperly(){
        when(service.update(any())).thenReturn(prepareUpdateData());
        ResponseEntity<DataResult<AcademicPersonal>> response =academicPersonalsController.update(academicPersonelId,any());
        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertEquals(response.getBody().getData(),prepareUpdateData().getData());

    }

    @Test
    public void testDeleteByIdIsWorkingProperly(){
        when(service.delete(academicPersonelId)).thenReturn(new SuccessResult());
        ResponseEntity<Result> response = academicPersonalsController.delete(academicPersonelId);
        assertEquals(response.getStatusCode(), HttpStatus.OK);

    }

    @Test
    public void testGetByIdIsWorkingProperly(){
        when(service.getById(academicPersonelId)).thenReturn(prepareSingleData());
        ResponseEntity<DataResult<AcademicPersonal>> response = academicPersonalsController.getById(academicPersonelId);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getData(), prepareSingleData().getData());

    }

    private static DataResult<AcademicPersonal>prepareSingleData(){
        return new SuccessDataResult<>(
                new AcademicPersonal(2, AcademicRate.PROFESSOR,
                        new Employee(1,
                                new EmployeeDepartment(1,"Sehmus"),
                                new AcademicUnit(1, "Engineering Faculty",
                                        AcademicType.FACULTY),new User(1,"Sehmus","test@gmail.com",
                                new Date(2000, Calendar.DECEMBER,5),
                                new Date(2022, Calendar.SEPTEMBER,5,12,45),"123456"))));


    }

    private static DataResult<AcademicPersonal>prepareUpdateData(){
        return new SuccessDataResult<>(
                new AcademicPersonal(2, AcademicRate.PROFESSOR,
                        new Employee(1,
                                new EmployeeDepartment(1,"Sehmus"),
                                new AcademicUnit(1, "Engineering Faculty",
                                        AcademicType.FACULTY),new User(1,"Sehmus","test@gmail.com",
                                new Date(2000, Calendar.DECEMBER,5),
                                new Date(2022, Calendar.SEPTEMBER,5,12,45),"123456"))));


    }

    private static DataResult<AcademicPersonal>prepareCreatedData(){
        return new SuccessDataResult<>(
                new AcademicPersonal(1, AcademicRate.DOC,
                        new Employee(1,
                                new EmployeeDepartment(1,"Sehmus"),
                                new AcademicUnit(1, "Engineering Faculty",
                                        AcademicType.FACULTY),new User(1,"Sehmus","test@gmail.com",
                                new Date(2000, Calendar.DECEMBER,5),
                                new Date(2022, Calendar.SEPTEMBER,5,12,45),"123456"))));

    }


    private DataResult<List<AcademicPersonal>> prepareDataList(){
        List<AcademicPersonal> academicPersonals = new ArrayList<>();
        academicPersonals.add(new AcademicPersonal(1, AcademicRate.DOC,
                new Employee(1,
                        new EmployeeDepartment(1,"Sehmus"),
                        new AcademicUnit(1, "Engineering Faculty",
                                AcademicType.FACULTY),new User(1,"Sehmus","test@gmail.com",
                        new Date(2000, Calendar.DECEMBER,5),
                        new Date(2022, Calendar.SEPTEMBER,5,12,45),"123456"))));

        academicPersonals.add(new AcademicPersonal(2, AcademicRate.PROFESSOR,
                new Employee(2,new EmployeeDepartment(2,"Seher"),
                        new AcademicUnit(2, "Engineering Faculty", AcademicType.FACULTY),
                        new User(2,"Seher","test2@gmail.com",new Date(2000, Calendar.AUGUST,2),
                                new Date(2022, Calendar.MARCH,5,12,45),"123456"))));

        return new SuccessDataResult<>(academicPersonals);
    }

    private  static  final int academicPersonelId = 2;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
}
