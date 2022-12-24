package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.StudentService;
import com.mb.software.ecampus.core.annotations.Logging;
import com.mb.software.ecampus.core.annotations.SecurityOperation;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.DbLogging;
import com.mb.software.ecampus.core.security.roles.SecurityRole;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.StudentDao;
import com.mb.software.ecampus.entities.concretes.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @SecurityOperation(security = {SecurityRole.STUDENT_AFFAIRS})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<Student> add(Student entity) {
        return new SuccessDataResult<>(studentDao.save(entity));
    }

    @SecurityOperation(security = {SecurityRole.STUDENT_AFFAIRS})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<Student> update(Student entity) {
        return new SuccessDataResult<>(studentDao.save(entity));
    }

    @SecurityOperation(security = {SecurityRole.STUDENT_AFFAIRS})
    @Logging(logType = DbLogging.class)
    @Override
    public Result delete(int id) {
        studentDao.deleteById(id);
        return new SuccessResult("Student has been deleted");
    }

    @SecurityOperation(security = {SecurityRole.USER})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<Student> getById(int id) {
        return new SuccessDataResult<>(studentDao.findById(id).get());
    }

    @SecurityOperation(security = {SecurityRole.USER})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<List<Student>> getAll() {
        return new SuccessDataResult<>(studentDao.findAll());
    }
}
