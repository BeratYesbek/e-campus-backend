package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.StudentService;
import com.mb.software.ecampus.core.utilities.Result;
import com.mb.software.ecampus.core.utilities.SuccessResult;
import com.mb.software.ecampus.core.utilities.data.DataResult;
import com.mb.software.ecampus.core.utilities.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.StudentDao;
import com.mb.software.ecampus.entities.concretes.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public DataResult<Student> add(Student entity) {
        return new SuccessDataResult<>(studentDao.save(entity));
    }

    @Override
    public DataResult<Student> update(Student entity) {
        return new SuccessDataResult<>(studentDao.save(entity));
    }

    @Override
    public Result delete(int id) {
        studentDao.deleteById(id);
        return new SuccessResult("Student has been deleted");
    }

    @Override
    public DataResult<Student> getById(int id) {
        return new SuccessDataResult<>(studentDao.findById(id).get());
    }

    @Override
    public DataResult<List<Student>> getAll() {
        return new SuccessDataResult<>(studentDao.findAll());
    }
}
