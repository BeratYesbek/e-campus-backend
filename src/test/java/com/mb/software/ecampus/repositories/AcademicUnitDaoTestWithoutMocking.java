package com.mb.software.ecampus.repositories;

import com.mb.software.ecampus.dataAccess.dao.AcademicUnitDao;
import com.mb.software.ecampus.entities.concretes.AcademicUnit;
import com.mb.software.ecampus.entities.concretes.enums.AcademicType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AcademicUnitDaoTestWithoutMocking {

    @Autowired
    public AcademicUnitDao academicUnitDao;

    @Test
    public void testSave() {
        AcademicUnit academicUnit = new AcademicUnit(0, "Engineering Faculty", AcademicType.FACULTY);
        AcademicUnit addedAcademicUnit = academicUnitDao.save(academicUnit);
        assertEquals(academicUnit, addedAcademicUnit);
    }

    @Test
    public void testDelete() {
        AcademicUnit academicUnit = new AcademicUnit(0, "Engineering Faculty", AcademicType.FACULTY);
        AcademicUnit addedAcademicUnit = academicUnitDao.save(academicUnit);
        academicUnitDao.deleteById(addedAcademicUnit.getId());
    }

    @Test
    public void testFindById() {
        AcademicUnit academicUnit = new AcademicUnit(0, "Engineering Faculty", AcademicType.FACULTY);
        AcademicUnit addedAcademicUnit = academicUnitDao.save(academicUnit);
        AcademicUnit foundAcademicUnit = academicUnitDao.findById(addedAcademicUnit.getId()).get();
        assertEquals(addedAcademicUnit.getId(),foundAcademicUnit.getId());
    }

    @Test
    public void testFindAll() {
        Collection<AcademicUnit> academicUnits = academicUnitDao.findAll();
        assertNotNull(academicUnits);
    }
}
