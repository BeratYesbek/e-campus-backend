package com.mb.software.ecampus.api.controllers;

import com.mb.software.ecampus.business.abstracts.AcademicUnitService;
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

    private static DataResult<AcademicUnit> prepareCreatedData() {
        return new SuccessDataResult<>(new AcademicUnit(1, "Engineering", AcademicType.FACULTY));
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
}
