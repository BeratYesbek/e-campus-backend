package com.mb.software.ecampus.repositories;

import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.dataAccess.dao.AcademicPersonalDao;
import com.mb.software.ecampus.dataAccess.dao.AcademicUnitDao;
import com.mb.software.ecampus.entities.concretes.AcademicPersonal;
import com.mb.software.ecampus.entities.concretes.AcademicUnit;
import com.mb.software.ecampus.entities.concretes.Employee;
import com.mb.software.ecampus.entities.concretes.EmployeeDepartment;
import com.mb.software.ecampus.entities.concretes.enums.AcademicRate;
import com.mb.software.ecampus.entities.concretes.enums.AcademicType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AcademicPersonalDaoTestWithoutMocking {


    @Autowired
    public AcademicPersonalDao academicPersonalDao;

    @Test
    public void testSave() {
        AcademicPersonal academicPersonal = new AcademicPersonal(2, AcademicRate.PROFESSOR,
                new Employee(1,
                        new EmployeeDepartment(1, "Sehmus"),
                        new AcademicUnit(1, "Engineering Faculty", AcademicType.FACULTY),
                        new User(1, "Sehmus", "test@gmail.com",
                                new Date(2000, Calendar.DECEMBER, 5),
                                new Date(2022, Calendar.SEPTEMBER, 5, 12, 45), "123456", "null", "null", "null", "null", "null"),
                        null), 1, "", "", "", ""))
        AcademicPersonal addesAcademicPersonal = academicPersonalDao.save(academicPersonal);
        assertEquals(academicPersonal, addesAcademicPersonal);
    }

    @Test
    public void testFindById() {
        AcademicPersonal academicPersonal = new AcademicPersonal(2, AcademicRate.PROFESSOR,
                new Employee(1,
                        new EmployeeDepartment(1, "Sehmus"),
                        new AcademicUnit(1, "Engineering Faculty", AcademicType.FACULTY),
                        new User(1, "Sehmus", "test@gmail.com",
                                new Date(2000, Calendar.DECEMBER, 5),
                                new Date(2022, Calendar.SEPTEMBER, 5, 12, 45), "123456", "null", "null", "null", "null", "null"),
                        null), 1, "", "", "", ""))
        AcademicPersonal addedAcademicPersonal = academicPersonalDao.save(academicPersonal);
        AcademicPersonal foundAcademicPersonal = academicPersonalDao.findById(addedAcademicPersonal.getId()).get();
        assertEquals(addedAcademicPersonal.getId(), foundAcademicPersonal.getId());
    }

}
