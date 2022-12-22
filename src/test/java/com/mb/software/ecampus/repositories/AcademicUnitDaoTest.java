package com.mb.software.ecampus.repositories;

import com.mb.software.ecampus.dataAccess.dao.AcademicUnitDao;
import com.mb.software.ecampus.entities.concretes.AcademicUnit;
import com.mb.software.ecampus.entities.concretes.enums.AcademicType;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class AcademicUnitDaoTest {
        @Mock
    public AcademicUnitDao academicUnitDao;

    @Test
    public void testSave() {
        AcademicUnit academicUnit = new AcademicUnit(0,"Engineering Faculty", AcademicType.FACULTY);
        when(academicUnitDao.save(academicUnit)).thenReturn(academicUnit);
        AcademicUnit addedAcademicUnit =  academicUnitDao.save(academicUnit);
        assertEquals(academicUnit, addedAcademicUnit);
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
}
