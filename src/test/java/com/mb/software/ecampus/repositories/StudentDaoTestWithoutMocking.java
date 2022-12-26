package com.mb.software.ecampus.repositories;

import com.mb.software.ecampus.core.entities.User;
import com.mb.software.ecampus.dataAccess.dao.AcademicUnitDao;
import com.mb.software.ecampus.dataAccess.dao.StudentDao;
import com.mb.software.ecampus.entities.concretes.AcademicDepartment;
import com.mb.software.ecampus.entities.concretes.AcademicUnit;
import com.mb.software.ecampus.entities.concretes.Student;
import com.mb.software.ecampus.entities.concretes.enums.AcademicType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentDaoTestWithoutMocking {

    @Autowired
    public StudentDao studentDao;

    public void testSave(){
        Student student = Student.builder()
                .academicDepartment(new AcademicDepartment(1,"","seher",new AcademicUnit(1,"Engineering Faculty",AcademicType.FACULTY)))
                .user(new User(1,"seherst","seher@gmail.com",new Date(2000,01,12)
                ,new Date(2022,01,12),"123456","","","","","")).build();

        Student addedStudent = studentDao.save(student);
        assertEquals(student,addedStudent);

    }

}
