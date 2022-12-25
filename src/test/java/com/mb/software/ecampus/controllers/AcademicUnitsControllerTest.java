package com.mb.software.ecampus.controllers;

import com.mb.software.ecampus.api.controllers.AcademicUnitsController;
import com.mb.software.ecampus.core.business.abstracts.AcademicUnitService;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.entities.concretes.AcademicUnit;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class AcademicUnitsControllerTest {

    @Mock
    private AcademicUnitService academicUnitService;

    static AcademicUnit academicUnit = new AcademicUnit(0,"Engineering",AcademicType.FACULTY);
    static AcademicUnit academicUnit1 = new AcademicUnit(1,"Engineering",AcademicType.FACULTY);


    @InjectMocks
    private AcademicUnitsController academicUnitsController;
    @Test
    public void testGetAllMethodIsWorkingProperly() {
        when(academicUnitService.getAll()).thenReturn(prepareDataList());
        ResponseEntity<DataResult<List<AcademicUnit>>> response = academicUnitsController.getAll();
        assertEquals(response.getBody().getData(), prepareDataList().getData());
    }
    @Test
    public void testAddMethodWorkingProperly() throws Exception {
        when(academicUnitService.add(any())).thenReturn(prepareCreatedData());
        ResponseEntity<DataResult<AcademicUnit>> response = academicUnitsController.add(any());
        assertEquals(response.getStatusCode(),HttpStatus.CREATED);
        assertEquals(response.getBody().getData() ,prepareCreatedData().getData());
    }

    @Test
    public void testUpdateIsWorkingProperly() {
        when(academicUnitService.update(any())).thenReturn(prepareUpdateData());
        ResponseEntity<DataResult<AcademicUnit>> response = academicUnitsController.update(academicUnitId, any());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getData(), prepareUpdateData().getData());
    }


    @Test
    public void testDeleteIsWorkingProperly() throws Exception {
        when(academicUnitService.delete(academicUnitId)).thenReturn(new SuccessResult());
        ResponseEntity<Result> response = academicUnitsController.delete(academicUnitId);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testGetByIdIsWorkingProperly() {
        when(academicUnitService.getById(academicUnitId)).thenReturn(prepareSingleData());
        ResponseEntity<DataResult<AcademicUnit>> response = academicUnitsController.getById(academicUnitId);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody().getData(), prepareSingleData().getData());
    }

    private static DataResult<AcademicUnit> prepareSingleData(){
        return new SuccessDataResult<>(
                academicUnit);

    }


    private static DataResult<AcademicUnit> prepareUpdateData(){
        return new SuccessDataResult<>(
                academicUnit);

    }

    private static DataResult<AcademicUnit> prepareCreatedData() {
        return new SuccessDataResult<>(
                academicUnit);
    }
    private DataResult<List<AcademicUnit>> prepareDataList(){
        List<AcademicUnit> academicUnits = new ArrayList<>();
        academicUnits.add(academicUnit);
        academicUnits.add(academicUnit1);
        return new SuccessDataResult<>(academicUnits);
    }

    private static final int academicUnitId = 1;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
}
