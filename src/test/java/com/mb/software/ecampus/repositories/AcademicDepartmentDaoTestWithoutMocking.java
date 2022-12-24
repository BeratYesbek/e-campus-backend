package com.mb.software.ecampus.repositories;

import com.mb.software.ecampus.dataAccess.dao.AcademicDepartmentDao;
import com.mb.software.ecampus.dataAccess.dao.AcademicUnitDao;
import com.mb.software.ecampus.entities.concretes.AcademicDepartment;
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
public class AcademicDepartmentDaoTestWithoutMocking {

    @Autowired
    public AcademicDepartmentDao academicDepartmentDao;

    @Test
    public void testSave(){
        AcademicDepartment academicDepartment =
                new AcademicDepartment(0,"Software Engineering",
                        new AcademicUnit(1, "Engineering Faculty", AcademicType.FACULTY));
        AcademicDepartment addedAcademicDepartment = academicDepartmentDao.save(academicDepartment);
        assertNotNull(addedAcademicDepartment);


    }

    @Test
    public void testDelete(){
        AcademicDepartment academicDepartment = new AcademicDepartment(0,"Software Engineering",
                new AcademicUnit(1, "Engineering Faculty", AcademicType.FACULTY));
        AcademicDepartment addedAcademicDepartment = academicDepartmentDao.save(academicDepartment);
        academicDepartmentDao.deleteById(addedAcademicDepartment.getId());
    }

    @Test
    public void testFinById(){
        AcademicDepartment academicDepartment = new AcademicDepartment(0,"Software Engineering",
                new AcademicUnit(1, "Engineering Faculty", AcademicType.FACULTY));
        AcademicDepartment addedAcademicDepartment = academicDepartmentDao.save(academicDepartment);
        AcademicDepartment foundAcademicUnit = academicDepartmentDao.findById(addedAcademicDepartment.getId()).get();
        assertEquals(addedAcademicDepartment.getId(),foundAcademicUnit.getId());
    }

    @Test

    public  void testFindAll(){
        Collection<AcademicDepartment> academicDepartments = academicDepartmentDao.findAll();
        assertNotNull(academicDepartments);
    }



}
