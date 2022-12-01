package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.business.abstracts.AcademicUnitService;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.entities.concretes.AcademicDepartment;
import com.mb.software.ecampus.entities.concretes.AcademicUnit;
import com.mb.software.ecampus.entities.concretes.enums.AcademicType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class AcademicUnitsControllerTest {

    @Mock
    private AcademicUnitService academicUnitService;

    @InjectMocks
    private AcademicUnitsController academicUnitsController;

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

    private static DataResult<AcademicUnit> prepareUpdateData(){
        return new SuccessDataResult<>(
                new AcademicUnit(2, "Engineering", AcademicType.FACULTY));

    }

    @Test
    public void testDeleteIsWorkingProperly() {
        when(academicUnitService.delete(academicUnitId)).thenReturn(new SuccessResult());
        ResponseEntity<Result> response = academicUnitsController.delete(academicUnitId);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    private static DataResult<AcademicUnit> prepareCreatedData() {
        return new SuccessDataResult<>(
                new AcademicUnit(1, "Engineering", AcademicType.FACULTY));
    }

    private static final int academicUnitId = 1;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
}
