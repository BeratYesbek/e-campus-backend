package com.mb.software.ecampus.repositories;

import com.mb.software.ecampus.dataAccess.dao.AcademicUnitDao;
import com.mb.software.ecampus.entities.concretes.AcademicUnit;
import com.mb.software.ecampus.entities.concretes.enums.AcademicType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AcademicUnitDaoTestWithoutMocking {

    @Autowired
    public AcademicUnitDao academicUnitDao;

    @Test
    public void testSave() {
        AcademicUnit academicUnit = new AcademicUnit(0,"Engineering Faculty", AcademicType.FACULTY);
        AcademicUnit addedAcademicUnit =  academicUnitDao.save(academicUnit);
        assertEquals(academicUnit, addedAcademicUnit);
    }
}
